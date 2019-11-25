package com.${company}.monitor.common.integration.${packageName}.result;

import lombok.Data;

import java.util.Date;

@Data
public class ${argObj}Result {

<#if dbObjects ??>
    <#list dbObjects as dbObject>

    /**
     * ${dbObject.cname}
     */
    private ${dbObject.type} ${dbObject.ename};
    </#list>
</#if>

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 修改人名称
     */
    private String modifyName;
}