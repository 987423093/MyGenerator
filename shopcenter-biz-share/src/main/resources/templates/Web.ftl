<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.share.autogenerator.code.server.web;

import com.${company}.commons.annotations.Param;
import com.${company}.commons.basic.PagerListBean;
import com.${company}.commons.exceptions.ServiceException;
import com.${company}.commons.utils.BeanUtils;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.${argObj}IntegrationService;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.param.${argObj}Param;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.param.${argObj}SearchParam;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.result.${argObj}Result;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.web.request.${argObj}Request;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.web.request.${argObj}SearchRequest;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.web.response.${argObj}Response;
import com.${company}.${argCenter}.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Service("${argName}")
public class ${argObj}WebServer {

    private final transient Logger logger = LoggerFactory.getLogger(${argObj}WebServer.class);

    @Autowired
    private ${argObj}IntegrationService ${argName}IntegrationService;

    /**
     * 新增${argCN}
     * @param ${argName}Request
     * @return
     */
    public ${argObj}Response add${argObj}(@Param(name = "userId", type = Long.class) Long userId,
                                          @Param(name = "${argName}Request", type = ${argObj}Request.class) ${argObj}Request ${argName}Request) {

        if (${argName}Request == null){
            logger.error("Fail to add${argObj} ! ${argName}Request must not be null !");
            throw new ServiceException(-1, "${argName}Request 不能为空");
        }
        <#if mustConditions ??>
            <#list mustConditions as mustCondition>
        if (${argName}Request.get${mustCondition.ename?cap_first}() == null){
            logger.error("Fail to add${argObj} ! ${mustCondition.ename} must not be null or empty!");
            throw new ServiceException(-1, "${mustCondition.sname} 不能为空");
        }
            </#list>
        </#if>
        ${argObj}Param ${argName}Param = new ${argObj}Param();
        BeanUtils.copyProperties2(${argName}Param, ${argName}Request);
        ${argName}Param.setCreator(userId);
        return Optionals.transformBean(${argName}IntegrationService.add${argObj}(${argName}Param), ${argObj}Response.class);
    }

    /**
     * 修改${argCN}
     * @param ${argName}Request
     * @return
     */
    public ${argObj}Response modify${argObj}(@Param(name = "userId", type = Long.class) Long userId,
                                             @Param(name = "${argName}Request", type = ${argObj}Request.class) ${argObj}Request ${argName}Request) {

        if (${argName}Request == null){
            logger.error("Fail to modify${argObj} ! ${argName}Request must not be null !");
            throw new ServiceException(-1, "${argName}Request 不能为空");
        }
        if (${argName}Request.get${primaryObject.ename?cap_first}() == null){
            logger.error("Fail to modify${argObj} ! ${argName}Request.get${primaryObject.ename?cap_first}() must not be null !");
            throw new ServiceException(-1, "${argName}Request.get${primaryObject.ename?cap_first}() 不能为空");
        }
        ${argObj}Param ${argName}Param = new ${argObj}Param();
        BeanUtils.copyProperties2(${argName}Param, ${argName}Request);
        ${argName}Param.setModifier(userId);
        return Optionals.transformBean(${argName}IntegrationService.modify${argObj}(${argName}Param), ${argObj}Response.class);
    }

    /**
     * 删除${argCN}
     * @param ${primaryObject.ename}
     */
    public void remove${argObj}(@Param(name = "${primaryObject.ename}", type = Long.class) Long ${primaryObject.ename}) {

        if (${primaryObject.ename} == null){
            logger.error("Fail to remove${argObj} ! ${primaryObject.ename} must not be null !");
            throw new ServiceException(-1, "${primaryObject.ename} 不能为空");
        }
        ${argName}IntegrationService.remove${argObj}(${primaryObject.ename});
    }

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     * @return
     */
    public ${argObj}Response get${argObj}Detail(@Param(name = "${primaryObject.ename}", type = Long.class) Long ${primaryObject.ename}) {

        if (${primaryObject.ename} == null){
            logger.error("Fail to get${argObj}Detail ! ${primaryObject.ename} must not be null !");
            throw new ServiceException(-1, "${primaryObject.ename} 不能为空");
        }
        return Optionals.transformBean(${argName}IntegrationService.get${argObj}Detail(${primaryObject.ename}), ${argObj}Response.class);
    }

    /**
     * 分页列出${argCN}列表
     * @param ${argName}SearchRequest
     * @param pagerListBean
     * @return
     */
    public PagerListBean<${argObj}Response> list${argObj}ByPage(@Param(name = "${argName}SearchRequest", type = ${argObj}SearchRequest.class) ${argObj}SearchRequest ${argName}SearchRequest,
                                                                @Param(name = "pagerListBean", type = PagerListBean.class) PagerListBean pagerListBean) {

        ${argObj}SearchParam ${argName}SearchParam = new ${argObj}SearchParam();
        if (${argName}SearchRequest != null) {
            BeanUtils.copyProperties2(${argName}SearchParam, ${argName}SearchRequest);
        }
        PagerListBean<${argObj}Result> list = ${argName}IntegrationService.list${argObj}ByPage(${argName}SearchParam, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(${argObj}Response.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 列出${argCN}
     * @param ${argName}SearchRequest
     * @return
     */
    public List<${argObj}Response> list${argObj}(@Param(name = "${argName}SearchRequest", type = ${argObj}SearchRequest.class) ${argObj}SearchRequest ${argName}SearchRequest) {

        ${argObj}SearchParam ${argName}SearchParam = new ${argObj}SearchParam();
        if (${argName}SearchRequest != null) {
            BeanUtils.copyProperties2(${argName}SearchParam, ${argName}SearchRequest);
        }
        return BeanUtils.copyList(${argObj}Response.class, ${argName}IntegrationService.list${argObj}(${argName}SearchParam));
    }
}