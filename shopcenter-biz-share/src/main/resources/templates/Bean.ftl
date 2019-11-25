<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoutao's template
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Data
public class ${argObj}Bean implements Serializable {
    <#if dbObjects ??>
        <#list dbObjects as dbObject>

    /**
     * ${dbObject.cname}
     */
    private ${dbObject.type} ${dbObject.ename};
        </#list>
    </#if>
}