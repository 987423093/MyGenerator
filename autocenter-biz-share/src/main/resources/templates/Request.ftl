package com.${company}.${argCenter}.biz.share.autogenerator.code.server.web.request;

import com.${company}.commons.web.server.bean.RequestJsonBody;
import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Data
public class ${argObj}Request extends RequestJsonBody {
    <#if dbObjects ??>
        <#list dbObjects as dbObject>

    /**
     * ${dbObject.cname}
     */
    private ${dbObject.type} ${dbObject.ename};
        </#list>
    </#if>
}