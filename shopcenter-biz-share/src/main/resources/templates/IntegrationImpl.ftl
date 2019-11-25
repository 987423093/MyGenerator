<#assign argObj = "${argName}"?cap_first>
package com.${company}.${projectName}.common.integration.${packageName}.impl;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.commons.utils.BeanUtils;
import com.${company}.${projectName}.common.integration.${packageName}.${argObj}IntegrationService;
import com.${company}.${projectName}.common.integration.${packageName}.param.${argObj}Param;
import com.${company}.${projectName}.common.integration.${packageName}.param.${argObj}SearchParam;
import com.${company}.${projectName}.common.integration.${packageName}.result.${argObj}Result;
import com.${company}.${argCenter}.common.facade.beans.${argObj}Bean;
import com.${company}.${argCenter}.common.facade.beans.${argObj}SearchBean;
import com.${company}.${argCenter}.common.facade.interfaces.${argObj}FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao's template
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Service
public class ${argObj}IntegrationServiceImpl implements ${argObj}IntegrationService {

    @Autowired
    private ${argObj}FacadeService ${argName}FacadeService;

    /**
     * 新增${argCN}
     * @param ${argName}Param
     */
    @Override
    public void add${argObj}(${argObj}Param ${argName}Param) {

        ${argObj}Bean ${argName}Bean = new ${argObj}Bean();
        BeanUtils.copyProperties2(${argName}Bean, ${argName}Param);
        ${argName}FacadeService.add${argObj}(${argName}Bean);
    }

    /**
     * 修改${argCN}
     * @param ${argName}Param
     */
    @Override
    public void modify${argObj}(${argObj}Param ${argName}Param) {

        ${argObj}Bean ${argName}Bean = new ${argObj}Bean();
        BeanUtils.copyProperties2(${argName}Bean, ${argName}Param);
        ${argName}FacadeService.modify${argObj}(${argName}Bean);
    }

    /**
     * 删除${argCN}
     * @param ${primaryObject.ename}
     */
    @Override
    public void remove${argObj}(Long ${primaryObject.ename}) {

        ${argName}FacadeService.remove${argObj}(${primaryObject.ename});
    }

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     * @return
     */
    @Override
    public ${argObj}Result get${argObj}Detail(Long ${primaryObject.ename}) {

        ${argObj}Bean ${argName}Bean = ${argName}FacadeService.get${argObj}Detail(${primaryObject.ename});
        if (${argName}Bean != null) {
            ${argObj}Result ${argName}Result = new ${argObj}Result();
            BeanUtils.copyProperties2(${argName}Result, ${argName}Bean);
            return ${argName}Result;
        }
        return null;
    }

    /**
     * 分页列出${argCN}列表
     * @param ${argName}SearchParam
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<${argObj}Result> list${argObj}ByPage(${argObj}SearchParam ${argName}SearchParam, PagerListBean pagerListBean) {

        ${argObj}SearchBean ${argName}SearchBean = new ${argObj}SearchBean();
        if (${argName}SearchParam != null) {
            BeanUtils.copyProperties2(${argName}SearchBean, ${argName}SearchParam);
        }
        PagerListBean<${argObj}Bean> list = ${argName}FacadeService.list${argObj}ByPage(${argName}SearchBean, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(${argObj}Result.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 列出${argCN}
     * @param ${argName}SearchParam
     * @return
     */
    @Override
    public List<${argObj}Result> list${argObj}(${argObj}SearchParam ${argName}SearchParam) {

        ${argObj}SearchBean ${argName}SearchBean = new ${argObj}SearchBean();
        if (${argName}SearchParam != null) {
           BeanUtils.copyProperties2(${argName}SearchBean, ${argName}SearchParam);
        }
        return BeanUtils.copyList(${argObj}Result.class, ${argName}FacadeService.list${argObj}(${argName}SearchBean));
    }
}