package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.ShopBean;
import com.dingdang.shopcenter.common.facade.beans.ShopSearchBean;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
public interface ShopFacadeService {

    /**
     * 增加店铺
     * @param shopBean
     */
    void addShop(ShopBean shopBean);

    /**
     * 修改店铺
     * @param shopBean
     */
    void modifyShop(ShopBean shopBean);

    /**
     * 得到店铺详情
     * @param shopId
     * @return
     */
    ShopBean getShopDetail(Long shopId);

    /**
     * 移除店铺
     * @param shopId
     */
    void removeShop(Long shopId);

    /**
     * 列出店铺
     * @param shopSearchBean
     * @return
     */
    List<ShopBean> listShop(ShopSearchBean shopSearchBean);

    /**
     * 分页列出店铺
     * @param shopSearchBean
     * @return
     */
    PagerListBean<ShopBean> listShopByPage(ShopSearchBean shopSearchBean, PagerListBean pagerListBean);

    /**
     * 批量添加店铺
     * @param shopBeans
     * @return
     */
    List<Long> batchAddShop(List<ShopBean> shopBeans);
}
