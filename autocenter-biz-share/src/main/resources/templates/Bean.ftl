package com.${company}.${argCenter}.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ${author}
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