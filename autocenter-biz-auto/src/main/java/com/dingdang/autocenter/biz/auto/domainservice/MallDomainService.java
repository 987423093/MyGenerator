package com.dingdang.autocenter.biz.auto.domainservice;

import com.dingdang.autocenter.biz.auto.dataobject.Mall;
import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.autocenter.biz.auto.condition.MallSearch;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
public interface MallDomainService {

    /**
     * 增加商城
     * @param mall
     * @return
     */
    Mall addMall(Mall mall);

    /**
     * 修改商城
     * @param mall
     * @return
     */
    Mall modifyMall(Mall mall);

    /**
     * 移除商城
     * @param mallId
     */
    void removeMall(Long mallId);

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    Mall getMallDetail(Long mallId);

    /**
     * 列出商城
     * @param mallSearch
     * @return
     */
    List<Mall> listMall(MallSearch mallSearch);

    /**
     * 分页列出商城
     * @param mallSearch
     * @param pagerListBean
     * @return
     */
    PagerListBean<Mall> listMallByPage(MallSearch mallSearch, PagerListBean pagerListBean);

    /**
     * 根据条件得到商城
     * @param mallSearch
     * @return
     */
    Mall getMallByCondition(MallSearch mallSearch);

    /**
     * 批量添加商城
     * @param malls
     */
    void batchAddMall(List<Mall> malls);
}