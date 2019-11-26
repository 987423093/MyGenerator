<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.share.autogenerator.code.server.param;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author zhoutao's template
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Data
public class ${argObj}SearchParam {
    <#if searchConditions ??>
        <#list searchConditions as searchCondition>

    /**
     * ${searchCondition.cname}
     */
    private ${searchCondition.type} ${searchCondition.ename};
        </#list>
    </#if>
    <#if likeConditions ??>
        <#list likeConditions as likeCondition>
    
    /**
     * ${likeCondition.cname}
     */
    private ${likeCondition.type} ${likeCondition.ename};
        </#list>
    </#if>
    <#if dateBetweenConditions ??>
        <#list dateBetweenConditions as dateBetweenCondition>

    /**
     * 开始${dateBetweenCondition.cname}
     */
    private ${dateBetweenCondition.type} start${dateBetweenCondition.ename?cap_first};

    /**
     * 结束${dateBetweenCondition.cname}
     */
    private ${dateBetweenCondition.type} end${dateBetweenCondition.ename?cap_first};
        </#list>
    </#if>
}