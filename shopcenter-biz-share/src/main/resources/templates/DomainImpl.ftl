<#assign argObj = "${argName}"?cap_first>
package com.${company}.${argCenter}.biz.${argItem}.domainservice.impl;

import com.${company}.commons.basic.PagerListBean;
import com.${company}.${argCenter}.biz.${argItem}.condition.${argObj}Search;
import com.${company}.${argCenter}.biz.${argItem}.dataobject.${argObj};
import com.${company}.${argCenter}.biz.${argItem}.domainservice.${argObj}DomainService;
import com.${company}.${argCenter}.biz.${argItem}.repository.${argObj}Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ${author}
 * @date ${dateTime?string("yyyy/MM/dd")}
 */
@Service
public class ${argObj}DomainServiceImpl implements ${argObj}DomainService {

    @Autowired
    private ${argObj}Repository ${argName}Repository;

    /**
     * 增加${argCN}
     * @param ${argName}
     * @return
     */
    @Override
    public ${argObj} add${argObj}(${argObj} ${argName}){

        return ${argName}Repository.add${argObj}(${argName});
    }

    /**
     * 修改${argCN}
     * @param ${argName}
     * @return
     */
    @Override
    public ${argObj} modify${argObj}(${argObj} ${argName}){

        return ${argName}Repository.modify${argObj}(${argName});
    }

    /**
    * 移除${argCN}
    * @param ${primaryObject.ename}
    */
    @Override
    public void remove${argObj}(Long ${primaryObject.ename}){

        ${argName}Repository.remove${argObj}(${primaryObject.ename});
    }

    /**
     * 得到${argCN}详情
     * @param ${primaryObject.ename}
     * @return
     */
    @Override
    public ${argObj} get${argObj}Detail(Long ${primaryObject.ename}){

        return ${argName}Repository.get${argObj}Detail(${primaryObject.ename});
    }

    /**
     * 列出${argCN}
     * @param ${argName}Search
     * @return
     */
    @Override
    public List<${argObj}> list${argObj}(${argObj}Search ${argName}Search){

        return ${argName}Repository.list${argObj}(${argName}Search);
    }

    /**
     * 分页列出${argCN}
     * @param ${argName}Search
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<${argObj}> list${argObj}ByPage(${argObj}Search ${argName}Search, PagerListBean pagerListBean){

        return ${argName}Repository.list${argObj}ByPage(${argName}Search, pagerListBean);
    }

    /**
     * 根据条件得到${argCN}
     * @param ${argName}Search
     * @return
     */
    @Override
    public ${argObj} get${argObj}ByCondition(${argObj}Search ${argName}Search){

        return ${argName}Repository.get${argObj}ByCondition(${argName}Search);
    }

    /**
     * 批量添加${argCN}
     * @param ${argName}s
     */
    @Override
    public void batchAdd${argObj}(List<${argObj}> ${argName}s){

        ${argName}Repository.batchAdd${argObj}(${argName}s);
    }
}