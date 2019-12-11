package com.dingdang.autocenter.web.server.services.impl;

import com.dingdang.commons.basic.Answer;
import com.dingdang.commons.http.HttpServiceController;
import com.dingdang.commons.utils.GZipUtils;
import com.dingdang.commons.utils.HttpRequestCommonParamUtils;
import com.dingdang.commons.utils.JsonUtil;
import com.dingdang.commons.web.server.bean.HttpRequestCommonParam;
import com.dingdang.commons.web.server.bean.ResponseStringBody;
import com.dingdang.commons.web.server.controller.BaseController;
import com.dingdang.commons.web.server.enums.ExceptionCodeEnum;
import com.dingdang.commons.web.server.util.HttpRequestParamUtils;
import com.dingdang.commons.web.server.util.ServiceInvocationUtil;
import com.esotericsoftware.kryo.io.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoutao
 * @date 2019/12/9
 */
public class IBaseController extends BaseController {

    private final transient Logger logger = LoggerFactory.getLogger(IBaseController.class);

    @Override
    protected void processRequest(String serviceName, String methodName, Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
            Assert.notNull(serviceName, "serviceName is null!");
            Assert.notNull(methodName, "methodName is null!");
            HttpRequestCommonParam httpRequestCommonParam = HttpRequestParamUtils.createHttpRequestCommonParam(requestMap, request);
            HttpRequestCommonParamUtils.setCurrentHttpRequestCommonParam(httpRequestCommonParam);
            HttpServiceController.enableInvoke(serviceName, methodName);
            Object obj = ServiceInvocationUtil.invoke(serviceName, methodName, httpRequestCommonParam, requestMap);
            Answer answer = new Answer();
            answer.setResult(obj);
            answer.setCode(ExceptionCodeEnum.SUCCESS.getCode());
            answer.setMessage(ExceptionCodeEnum.SUCCESS.getMessage());
            String content = answer.getResult() instanceof String ? answer.getResult().toString() : JsonUtil.jsonFromObject(answer);
            ServletOutputStream servletOutputStream = null;
            try {
                servletOutputStream = response.getOutputStream();
                byte[] bs = content.getBytes("utf-8");
                bs = GZipUtils.compress(bs);
                response.setContentLength(bs.length);
                response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Content-Encoding", "gzip");
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
                response.setHeader("Access-Control-Allow-Headers", "*");
                servletOutputStream.write(bs);
                servletOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    servletOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    protected Map<String, Object> parseParams(HttpServletRequest request) {
        HashMap requestMap = new HashMap();

        try {
            Map map = request.getParameterMap();
            for (Object key : map.keySet()) {
                requestMap.put(key.toString(), request.getParameter(key.toString()));
            }
            return requestMap;
        } catch (Exception var6) {
            logger.error("parse param error !", var6);
            return requestMap;
        }
    }
}
