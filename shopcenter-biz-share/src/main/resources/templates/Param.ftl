package com.${company}.monitor.common.integration.${packageName}.param;

import lombok.Data;

import java.util.Date;

@Data
public class ${argObj}Param {

<#if dbObjects ??>
    <#list dbObjects as dbObject>

    /**
     * ${dbObject.cname}
     */
    private ${dbObject.type} ${dbObject.ename};
    </#list>
</#if>
}