<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.share.autogenerator.freemarker.condition;

import com.${company}.${argCenter}.biz.share.autogenerator.utils.MyObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Data
public class ${argObj}Conditions {
<#if dbObjects ??>
    <#list dbObjects as dbObject>

    /**
     * ${dbObject.cname}
     */
    public static MyObject ${dbObject.ename} = new MyObject("${dbObject.ename}", "${dbObject.type}", "${dbObject.cname}", "${dbObject.sname}");
    </#list>
</#if>
}