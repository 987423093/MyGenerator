package com.dingdang.autocenter.web.server.services;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingdang.autocenter.web.server.services.impl.IBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/service"})
public class IAPIController extends IBaseController {

    @RequestMapping(value = {"/{serviceName}/{methodName}.do"}, method = {RequestMethod.GET})
    public void doGet(@PathVariable String serviceName, @PathVariable String methodName, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> requestMap = this.parseParams(request);
        this.processRequest(serviceName, methodName, requestMap, request, response);
    }

    @RequestMapping(value = {"/{serviceName}/{methodName}.do"}, method = {RequestMethod.POST})
    public void doPost(@PathVariable String serviceName, @PathVariable String methodName, @RequestBody Map<String, Object> requestBodyMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> requestMap = this.parseParams(request);
        if (requestBodyMap != null) {
            requestMap.putAll(requestBodyMap);
        }

        this.processRequest(serviceName, methodName, requestMap, request, response);
    }

    @RequestMapping(value = {"/{serviceName}/{methodName}.do"}, method = {RequestMethod.OPTIONS})
    public void options(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "origin,content-type,accept,x-requested-with");
    }
}