<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.service.impl;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.commons.exceptions.ServiceException;
import com.${company}.commons.utils.BeanUtils;
import com.${company}.commons.utils.StringUtils;
import com.${company}.commons.utils.CollectionUtils;
import com.${company}.${argCenter}.biz.${argItem}.condition.${argObj}Search;
import com.${company}.${argCenter}.biz.${argItem}.dataobject.${argObj};
import com.${company}.${argCenter}.biz.${argItem}.domainservice.${argObj}DomainService;
import com.${company}.${argCenter}.common.facade.beans.${argObj}Bean;
import com.${company}.${argCenter}.common.facade.beans.${argObj}SearchBean;
import com.${company}.${argCenter}.common.facade.interfaces.${argObj}FacadeService;
import com.${company}.${argCenter}.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author zhoutao's template
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Service
public class ${argObj}FacadeServiceImpl implements ${argObj}FacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(${argObj}FacadeServiceImpl.class);

    @Autowired
    private ${argObj}DomainService ${argName}DomainService;

    /**
     * 增加${argCN}
     * @param ${argName}Bean
     */
    @Override
    public ${argObj}Bean add${argObj}(${argObj}Bean ${argName}Bean){

        if (${argName}Bean == null){
            logger.error("Fail to add${argObj} ! ${argName}Bean must not be null !");
            throw new ServiceException(-1, "${argName}Bean 不能为空");
        }
        <#if mustConditions ??>
             <#list mustConditions as mustCondition>
        if (${argName}Bean.get${mustCondition.ename?cap_first}() == null){
            logger.error("Fail to add${argObj} ! ${mustCondition.ename} must not be null or empty!");
            throw new ServiceException(-1, "${mustCondition.sname} 不能为空");
        }
             </#list>
        </#if>

        ${argObj} ${argName} = new ${argObj}();
        BeanUtils.copyProperties2(${argName}, ${argName}Bean);
        return (${argObj}Bean) Optionals.transformBean(${argName}DomainService.add${argObj}(${argName}), ${argObj}Bean.class);
    }

    /**
     * 修改${argCN}
     * @param ${argName}Bean
     */
    @Override
    public ${argObj}Bean modify${argObj}(${argObj}Bean ${argName}Bean){

        if (${argName}Bean == null){
             logger.error("Fail to modify${argObj} ! ${argName}Bean must not be null !");
             throw new ServiceException(-1, "${argName}Bean 不能为空");
        }
        if (${argName}Bean.get${primaryObject.ename?cap_first}() == null){
            logger.error("Fail to modify${argObj} ! ${argName}Bean.get${primaryObject.ename?cap_first}() must not be null !");
            throw new ServiceException(-1, "${argName}Bean.get${primaryObject.ename?cap_first}() 不能为空");
        }

        ${argObj} ${argName} = new ${argObj}();
        BeanUtils.copyProperties2(${argName}, ${argName}Bean);
        return (${argObj}Bean) Optionals.transformBean( ${argName}DomainService.modify${argObj}(${argName}), ${argObj}Bean.class);
    }

    /**
    * 移除${argCN}
    * @param ${primaryObject.ename}
    */
    @Override
    public void remove${argObj}(Long ${primaryObject.ename}){

        if (${primaryObject.ename} == null){
            logger.error("Fail to get${argObj}Detail ! ${primaryObject.ename} must not be null !");
            throw new ServiceException(-1, "${primaryObject.ename} 不能为空");
        }

        ${argName}DomainService.remove${argObj}(${primaryObject.ename});
    }

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     */
    @Override
    public ${argObj}Bean get${argObj}Detail(Long ${primaryObject.ename}){

        if (${primaryObject.ename} == null){
            logger.error("Fail to get${argObj}Detail ! ${primaryObject.ename} must not be null !");
            throw new ServiceException(-1, "${primaryObject.ename} 不能为空");
        }

        return (${argObj}Bean) Optionals.transformBean(${argName}DomainService.get${argObj}Detail(${primaryObject.ename}), ${argObj}Bean.class);
    }

    /**
     * 列出${argCN}
     * @param ${argName}SearchBean
     */
    @Override
    public List<${argObj}Bean> list${argObj}(${argObj}SearchBean ${argName}SearchBean){

        ${argObj}Search ${argName}Search = new ${argObj}Search();
        if (${argName}SearchBean != null) {
            BeanUtils.copyProperties2(${argName}Search, ${argName}SearchBean);
        }
        return BeanUtils.copyList(${argObj}Bean.class, ${argName}DomainService.list${argObj}(${argName}Search));
    }

    /**
     * 分页列出${argCN}
     * @param ${argName}SearchBean
     * @param pagerListBean
     */
    @Override
    public PagerListBean<${argObj}Bean> list${argObj}ByPage(${argObj}SearchBean ${argName}SearchBean, PagerListBean pagerListBean){

        ${argObj}Search ${argName}Search = new ${argObj}Search();
        if (${argName}SearchBean != null) {
            BeanUtils.copyProperties2(${argName}Search, ${argName}SearchBean);
        }
        PagerListBean<${argObj}> list = ${argName}DomainService.list${argObj}ByPage(${argName}Search, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(${argObj}Bean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 根据条件得到${argCN}
     * @param ${argName}SearchBean
     */
    @Override
    public ${argObj}Bean get${argObj}ByCondition(${argObj}SearchBean ${argName}SearchBean){

        ${argObj}Search ${argName}Search = new ${argObj}Search();
        if (${argName}SearchBean != null) {
            BeanUtils.copyProperties2(${argName}Search, ${argName}SearchBean);
        }
        ${argObj} ${argName} = ${argName}DomainService.get${argObj}ByCondition(${argName}Search);
        if (${argName} != null){
            ${argObj}Bean ${argName}Bean = new ${argObj}Bean();
            BeanUtils.copyProperties2(${argName}Bean, ${argName});
            return ${argName}Bean;
        }
        return null;
    }

    /**
     * 批量添加${argCN}
     * @param ${argName}Beans
     */
    @Override
    public void batchAdd${argObj}(List<${argObj}Bean> ${argName}Beans){

        if (CollectionUtils.isEmpty(${argName}Beans)){
            logger.error("Fail to batchAdd${argObj} ! ${argName}Beans must not be null !");
            throw new ServiceException(-1, "${argName}Beans 不能为空");
        }
            <#if mustConditions ??>
        for (${argObj}Bean ${argName}Bean : ${argName}Beans){
                <#list mustConditions as mustCondition>
            if (${argName}Bean.get${mustCondition.ename?cap_first}() == null){
            logger.error("Fail to add${argObj} ! ${mustCondition.ename} must not be null or empty!");
                throw new ServiceException(-1, "${mustCondition.sname} 不能为空");
            }
                </#list>
        }
            </#if>
        ${argName}DomainService.batchAdd${argObj}(BeanUtils.copyList(${argObj}.class, ${argName}Beans));
    }
}