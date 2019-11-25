package com.${company}.${projectName}.common.integration.${packageName};

import com.${company}.commons.basic.PagerListBean;
import com.${company}.${projectName}.common.integration.${packageName}.param.${argObj}Param;
import com.${company}.${projectName}.common.integration.${packageName}.param.${argObj}SearchParam;
import com.${company}.${projectName}.common.integration.${packageName}.result.${argObj}Result;

import java.util.List;

/**
 * @author zhoutao's template
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
public interface ${argObj}IntegrationService {

    /**
     * 新增${argCN}
     * @param ${argName}Param
     */
    void add${argObj}(${argObj}Param ${argName}Param);
    
    /**
     * 修改${argCN}
     * @param ${argName}Param
     */
    void modify${argObj}(${argObj}Param ${argName}Param);
    
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
}
