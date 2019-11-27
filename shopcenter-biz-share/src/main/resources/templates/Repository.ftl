<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.${argItem}.repository;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.${argCenter}.biz.${argItem}.condition.${argObj}Search;
import com.${company}.${argCenter}.biz.${argItem}.dataobject.${argObj};

import java.util.List;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
public interface ${argObj}Repository {

    /**
     * 增加${argCN}
     * @param ${argName}
     * @return
     */
    ${argObj} add${argObj}(${argObj} ${argName});

    /**
     * 修改${argCN}
     * @param ${argName}
     * @return
     */
    ${argObj} modify${argObj}(${argObj} ${argName});

    /**
     * 移除${argCN}
     * @param ${primaryObject.ename}
     */
    void remove${argObj}(Long ${primaryObject.ename});

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     * @return
     */
    ${argObj} get${argObj}Detail(Long ${primaryObject.ename});

    /**
     * 列出${argCN}
     * @param ${argName}Search
     * @return
     */
    List<${argObj}> list${argObj}(${argObj}Search ${argName}Search);

    /**
     * 分页列出${argCN}
     * @param ${argName}Search
     * @param pagerListBean
     * @return
     */
    PagerListBean<${argObj}> list${argObj}ByPage(${argObj}Search ${argName}Search, PagerListBean pagerListBean);

    /**
     * 根据条件得到${argCN}
     * @param ${argName}Search
     * @return
     */
    ${argObj} get${argObj}ByCondition(${argObj}Search ${argName}Search);

    /**
     * 批量添加${argCN}
     * @param ${argName}s
     */
    void batchAdd${argObj}(List<${argObj}> ${argName}s);
}