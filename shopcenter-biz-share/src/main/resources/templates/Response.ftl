<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.share.autogenerator.code.server.web.response;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Data
public class ${argObj}Response {
    <#if dbObjects ??>
        <#list dbObjects as dbObject>

    /**
     * ${dbObject.cname}
     */
    private ${dbObject.type} ${dbObject.ename};
        </#list>
    </#if>
}