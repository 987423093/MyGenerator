<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.param.${argObj}SearchParam;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.param.${argObj}Param;
import com.${company}.${argCenter}.biz.share.autogenerator.code.server.integration.result.${argObj}Result;
import java.util.List;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
public interface ${argObj}IntegrationService {

    /**
     * 新增${argCN}
     * @param ${argName}Param
     * @return
     */
    ${argObj}Result add${argObj}(${argObj}Param ${argName}Param);
    
    /**
     * 修改${argCN}
     * @param ${argName}Param
     * @return
     */
    ${argObj}Result modify${argObj}(${argObj}Param ${argName}Param);
    
    /**
     * 删除${argCN}
     * @param ${primaryObject.ename}
     */
    void remove${argObj}(Long ${primaryObject.ename});
    
    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     * @return
     */
    ${argObj}Result get${argObj}Detail(Long ${primaryObject.ename});
    
    /**
     * 分页列出${argCN}列表
     * @param ${argName}SearchParam
     * @param pagerListBean
     * @return
     */
    PagerListBean<${argObj}Result> list${argObj}ByPage(${argObj}SearchParam ${argName}SearchParam, PagerListBean pagerListBean);
    
    /**
     * 列出${argCN}
     * @param ${argName}SearchParam
     * @return
     */
    List<${argObj}Result> list${argObj}(${argObj}SearchParam ${argName}SearchParam);

    /**
     * 批量添加${argCN}
     * @param ${argName}Params
     */
    void batchAdd${argObj}(List<${argObj}Param> ${argName}Params);
}
