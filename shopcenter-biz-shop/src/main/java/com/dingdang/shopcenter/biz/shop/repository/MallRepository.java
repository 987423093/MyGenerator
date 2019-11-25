package com.dingdang.shopcenter.biz.shop.repository;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.MallSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Mall;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/10/9
 */
public interface MallRepository {

    /**
     * 增加商城
     * @param mall
     */
    void addMall(Mall mall);

    /**
     * 修改商城
     * @param mall
     */
    void modifyMall(Mall mall);

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    Mall getMallDetail(Long mallId);

    /**
     * 移除商城
     * @param mallId
     */
    void removeMall(Long mallId);

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
}
