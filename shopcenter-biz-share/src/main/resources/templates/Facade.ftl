<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.common.facade.interfaces;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.${argCenter}.common.facade.beans.${argObj}Bean;
import com.${company}.${argCenter}.common.facade.beans.${argObj}SearchBean;

import java.util.List;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
public interface ${argObj}FacadeService {

    /**
     * 增加${argCN}
     * @param ${argName}Bean
     */
    ${argObj}Bean add${argObj}(${argObj}Bean ${argName}Bean);

    /**
     * 修改${argCN}
     * @param ${argName}Bean
     */
    ${argObj}Bean modify${argObj}(${argObj}Bean ${argName}Bean);

    /**
     * 移除${argCN}
     * @param ${primaryObject.ename}
     */
    void remove${argObj}(Long ${primaryObject.ename});

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     */
    ${argObj}Bean get${argObj}Detail(Long ${primaryObject.ename});

    /**
     * 列出${argCN}
     * @param ${argName}SearchBean
     */
    List<${argObj}Bean> list${argObj}(${argObj}SearchBean ${argName}SearchBean);

    /**
     * 分页列出${argCN}
     * @param ${argName}SearchBean
     * @param pagerListBean
     */
    PagerListBean<${argObj}Bean> list${argObj}ByPage(${argObj}SearchBean ${argName}SearchBean, PagerListBean pagerListBean);

    /**
     * 根据条件得到${argCN}
     * @param ${argName}SearchBean
     */
    ${argObj}Bean get${argObj}ByCondition(${argObj}SearchBean ${argName}SearchBean);

    /**
     * 批量添加${argCN}
     * @param ${argName}Beans
     */
    void batchAdd${argObj}(List<${argObj}Bean> ${argName}Beans);
}