package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.ShopSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Shop;
import com.dingdang.shopcenter.biz.shop.domainservice.ShopDomainService;
import com.dingdang.shopcenter.biz.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Service
public class ShopDomainServiceImpl implements ShopDomainService {

    @Autowired
    private ShopRepository shopRepository;

    /**
     * 增加店铺
     * @param shop
     */
    @Override
    public void addShop(Shop shop) {

        shopRepository.addShop(shop);
    }

    /**
     * 修改店铺
     * @param shop
     */
    @Override
    public void modifyShop(Shop shop) {

        shopRepository.modifyShop(shop);
    }

    /**
     * 得到店铺详情
     * @param shopId
     * @return
     */
    @Override
    public Shop getShopDetail(Long shopId) {

        return shopRepository.getShopDetail(shopId);
    }

    /**
     * 移除店铺
     * @param shopId
     */
    @Override
    public void removeShop(Long shopId) {

        shopRepository.removeShop(shopId);
    }

    /**
     * 列出店铺
     * @param shopSearch
     * @return
     */
    @Override
    public List<Shop> listShop(ShopSearch shopSearch) {

        return shopRepository.listShop(shopSearch);
    }

    /**
     * 分页列出店铺
     * @param shopSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Shop> listShopByPage(ShopSearch shopSearch, PagerListBean pagerListBean) {

        return shopRepository.listShopByPage(shopSearch, pagerListBean);
    }

    /**
     * 批量添加店铺
     * @param shops
     * @return
     */
    @Override
    public List<Long> batchAddShop(List<Shop> shops) {

        return shopRepository.batchAddShop(shops);
    }
}
