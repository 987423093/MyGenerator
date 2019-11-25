package com.dingdang.shopcenter.biz.shop.repository;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.ShopSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Shop;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
public interface ShopRepository {

    /**
     * 增加店铺
     * @param shop
     */
    void addShop(Shop shop);

    /**
     * 修改店铺
     * @param shop
     */
    void modifyShop(Shop shop);

    /**
     * 得到店铺详情
     * @param shopId
     * @return
     */
    Shop getShopDetail(Long shopId);

    /**
     * 移除店铺
     * @param shopId
     */
    void removeShop(Long shopId);

    /**
     * 列出店铺
     * @param shopSearch
     * @return
     */
    List<Shop> listShop(ShopSearch shopSearch);

    /**
     * 分页列出店铺
     * @param shopSearch
     * @param pagerListBean
     * @return
     */
    PagerListBean<Shop> listShopByPage(ShopSearch shopSearch, PagerListBean pagerListBean);

    /**
     * 批量添加店铺
     * @param shops
     * @return
     */
    List<Long> batchAddShop(List<Shop> shops);
}
