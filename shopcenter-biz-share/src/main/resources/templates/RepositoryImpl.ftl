<#assign argObj = "${argName}"?cap_first>

package com.${company}.${argCenter}.biz.${argItem}.repository.impl;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.commons.enums.StateEnum;
import com.${company}.commons.utils.Assert;
import com.${company}.commons.utils.CollectionUtils;
import com.${company}.commons.utils.StringUtils;
import com.${company}.${argCenter}.biz.${argItem}.condition.${argObj}Search;
import com.${company}.${argCenter}.biz.${argItem}.dao.${argObj}Mapper;
import com.${company}.${argCenter}.biz.${argItem}.dataobject.${argObj};
import com.${company}.${argCenter}.biz.${argItem}.dataobject.${argObj}Example;
import com.${company}.${argCenter}.biz.${argItem}.repository.${argObj}Repository;
import com.${company}.${argCenter}.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoutao's template
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Repository
public class ${argObj}RepositoryImpl implements ${argObj}Repository {

    @Autowired
    private ${argObj}Mapper ${argName}Mapper;

    /**
     * 增加${argCN}
     * @param ${argName}
     */
    @Override
    public ${argObj} add${argObj}(${argObj} ${argName}){

        Assert.notNull(${argName}, "${argName} must not be null !");
        <#if mustConditions ??>
            <#list mustConditions as mustCondition>
        Assert.notNull(${argName}.get${mustCondition.ename?cap_first}(), "${mustCondition.ename} must not be null !");
            </#list>
        </#if>
        Optionals.setDefaultInsert(${argName});
        ${argName}Mapper.insert(${argName});
        return ${argName};
    }

    /**
     * 修改${argCN}
     * @param ${argName}
     */
    @Override
    public ${argObj} modify${argObj}(${argObj} ${argName}){

        Assert.notNull(${argName}, "${argName} must not be null !");
        Assert.notNull(${argName}.get${primaryObject.ename?cap_first}(), "${argName}.get${primaryObject.ename?cap_first}() must not be null !");
        Optionals.setDefaultModify(${argName});
        ${argName}Mapper.updateByPrimaryKeySelective(${argName});
        return ${argName};
    }

    /**
    * 移除${argCN}
    * @param ${primaryObject.ename}
    */
    @Override
    public void remove${argObj}(Long ${primaryObject.ename}){

        Assert.notNull(${primaryObject.ename}, "${primaryObject.ename} must not be null !");
        ${argObj} ${argName} = new ${argObj}();
        ${argName}.set${primaryObject.ename?cap_first}(${primaryObject.ename});
        ${argName}.setState(StateEnum.NOT_USE.getCode());
        ${argName}Mapper.updateByPrimaryKeySelective(${argName});
    }

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     */
    @Override
    public ${argObj} get${argObj}Detail(Long ${primaryObject.ename}){

        Assert.notNull(${primaryObject.ename}, "${primaryObject.ename} must not be null !");
        ${argObj} ${argName} = ${argName}Mapper.selectByPrimaryKey(${primaryObject.ename});
        return (${argObj}) Optionals.getDefaultDetail(${argName});
    }

    /**
     * 列出${argCN}
     * @param ${argName}Search
     */
    @Override
    public List<${argObj}> list${argObj}(${argObj}Search ${argName}Search){

        ${argObj}Example ${argName}Example = new ${argObj}Example();
        this.setCondition(${argName}Example, ${argName}Search);
        return ${argName}Mapper.selectByExample(${argName}Example);
    }

    /**
     * 分页列出${argCN}
     * @param ${argName}Search
     * @param pagerListBean
     */
    @Override
    public PagerListBean<${argObj}> list${argObj}ByPage(${argObj}Search ${argName}Search, PagerListBean pagerListBean){

        ${argObj}Example ${argName}Example = new ${argObj}Example();
        this.setCondition(${argName}Example, ${argName}Search);
        Optionals.setDefaultOrderBy(${argName}Example, pagerListBean);
        pagerListBean.setTotal((long) ${argName}Mapper.countByExample(${argName}Example));
        pagerListBean.setItems(${argName}Mapper.selectByExample(${argName}Example));
        return pagerListBean;
    }

    /**
     * 根据条件得到${argCN}
     * @param ${argName}Search
     */
    @Override
    public ${argObj} get${argObj}ByCondition(${argObj}Search ${argName}Search){

        ${argObj}Example ${argName}Example = new ${argObj}Example();
        this.setCondition(${argName}Example, ${argName}Search);
        List<${argObj}> ${argName}s = ${argName}Mapper.selectByExample(${argName}Example);
        if (CollectionUtils.isNotEmpty(${argName}s)){
            return ${argName}s.get(0);
        }
        return null;
    }

    /**
     * 批量添加${argCN}
     * @param ${argName}s
     */
    @Override
    public void batchAdd${argObj}(List<${argObj}> ${argName}s){

        for (${argObj} ${argName} : ${argName}s){
        <#if mustConditions ??>
            <#list mustConditions as mustCondition>
            Assert.notNull(${argName}.get${mustCondition.ename?cap_first}(), "${mustCondition.ename} must not be null !");
            </#list>
        </#if>
            Optionals.setDefaultInsert(${argName});
        }
        ${argName}Mapper.insertBatch(${argName}s);
    }

    /**
     * 设置条件
     * @param ${argName}Example
     * @param ${argName}Search
     */
    private void setCondition(${argObj}Example ${argName}Example, ${argObj}Search ${argName}Search){

        ${argObj}Example.Criteria criteria = ${argName}Example.createCriteria();
        if (${argName}Search != null) {

        <#if searchConditions ??>
            <#list searchConditions as searchCondition>
            //${searchCondition.cname}
                <#if searchCondition.type == "Integer" || searchCondition.type == "Long" || searchCondition.type == "BigDecimal">
            if (${argName}Search.get${searchCondition.ename?cap_first}() != null){
                criteria.and${searchCondition.ename?cap_first}EqualTo(${argName}Search.get${searchCondition.ename?cap_first}());
            }
                <#elseif searchCondition.type == "String">
            if (StringUtils.isNotBlank(${argName}Search.get${searchCondition.ename?cap_first}())){
                criteria.and${searchCondition.ename?cap_first}EqualTo(${argName}Search.get${searchCondition.ename?cap_first}());
            }
                <#elseif searchCondition.type == "List<String>" || searchCondition.type == "List<Integer>" || searchCondition.type == "List<Long>">
            if (CollectionUtils.isNotEmpty(${argName}Search.get${searchCondition.ename?cap_first}())){
                criteria.and${searchCondition.oname?cap_first}In(${argName}Search.get${searchCondition.ename?cap_first}());
            }
                </#if>
            </#list>
        </#if>
        <#if likeConditions ??>
            <#list likeConditions as likeCondition>
            //${likeCondition.cname}
            if (StringUtils.isNotBlank(${argName}Search.get${likeCondition.ename?cap_first}())){
                criteria.and${likeCondition.ename?cap_first}Like("%" + ${argName}Search.get${likeCondition.ename?cap_first}() + "%");
            }
            </#list>
        </#if>
        <#if dateBetweenConditions ??>
            <#list dateBetweenConditions as dateBetweenCondition>
            //${dateBetweenCondition.cname}
            if (${argName}Search.getStart${dateBetweenCondition.ename?cap_first}() != null && ${argName}Search.getEnd${dateBetweenCondition.ename?cap_first}() != null){
                criteria.and${dateBetweenCondition.ename?cap_first}Between(${argName}Search.getStart${dateBetweenCondition.ename?cap_first}(), ${argName}Search.getEnd${dateBetweenCondition.ename?cap_first}());
            }
            </#list>
        </#if>
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}