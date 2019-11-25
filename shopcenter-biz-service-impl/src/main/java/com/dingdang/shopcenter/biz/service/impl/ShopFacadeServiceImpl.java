package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.ShopSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Shop;
import com.dingdang.shopcenter.biz.shop.domainservice.ShopDomainService;
import com.dingdang.shopcenter.common.facade.beans.ShopBean;
import com.dingdang.shopcenter.common.facade.beans.ShopSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.ShopFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Service
public class ShopFacadeServiceImpl implements ShopFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(ShopFacadeServiceImpl.class);

    @Autowired
    private ShopDomainService shopDomainService;

    /**
     * 增加店铺
     * @param shopBean
     */
    @Override
    public void addShop(ShopBean shopBean) {

        if (shopBean == null){
            logger.error("Fail to addShop ! shopBean must not be null !");
            throw new ServiceException(-1, "shopBean 不能为空");
        }
        if (StringUtils.isBlank(shopBean.getShopName())){
            logger.error("Fail to addShop ! shopBean.getShopName() must not be empty !");
            throw new ServiceException(-1, "shopBean.getShopName() 不能为空字符串");
        }
        if (StringUtils.isBlank(shopBean.getMerchantNo())){
            logger.error("Fail to addShop ! shopBean.getMerchantNo() must not be empty !");
            throw new ServiceException(-1, "shopBean.getMerchantNo() 不能为空字符串");
        }
        if (shopBean.getShopType() == null){
            logger.error("Fail to addShop ! shopBean.getShopType() must not be null !");
            throw new ServiceException(-1, "shopBean.getShopType() 不能为空");
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties2(shop, shopBean);
        shopDomainService.addShop(shop);
    }

    /**
     * 修改店铺
     * @param shopBean
     */
    @Override
    public void modifyShop(ShopBean shopBean) {

        if (shopBean == null){
            logger.error("Fail to modifyShop ! shopBean must not be null !");
            throw new ServiceException(-1, "shopBean 不能为空");
        }
        if (shopBean.getShopId() == null){
            logger.error("Fail to modifyShop ! shopBean.getShopId() must not be null !");
            throw new ServiceException(-1, "shopBean.getShopId() 不能为空");
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties2(shop, shopBean);
        shopDomainService.modifyShop(shop);
    }

    /**
     * 得到店铺详情
     * @param shopId
     * @return
     */
    @Override
    public ShopBean getShopDetail(Long shopId) {

        if (shopId == null){
            logger.error("Fail to getShopDetail ! shopId must not be null !");
            throw new ServiceException(-1, "shopId 不能为空");
        }
        Shop shop = shopDomainService.getShopDetail(shopId);
        if (shop != null) {
            ShopBean shopBean = new ShopBean();
            BeanUtils.copyProperties2(shopBean, shop);
            return shopBean;
        }
        return null;
    }

    /**
     * 移除店铺
     * @param shopId
     */
    @Override
    public void removeShop(Long shopId) {

        if (shopId == null){
            logger.error("Fail to removeShop ! shopId must not be null !");
            throw new ServiceException(-1, "shopId 不能为空");
        }
        shopDomainService.removeShop(shopId);
    }

    /**
     * 列出店铺
     * @param shopSearchBean
     * @return
     */
    @Override
    public List<ShopBean> listShop(ShopSearchBean shopSearchBean) {

        ShopSearch shopSearch = new ShopSearch();
        if (shopSearchBean != null) {
            BeanUtils.copyProperties2(shopSearch, shopSearchBean);
        }
        return BeanUtils.copyList(ShopBean.class, shopDomainService.listShop(shopSearch));
    }

    /**
     * 分页列出店铺
     * @param shopSearchBean
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<ShopBean> listShopByPage(ShopSearchBean shopSearchBean, PagerListBean pagerListBean) {

        ShopSearch shopSearch = new ShopSearch();
        if (shopSearchBean != null) {
            BeanUtils.copyProperties2(shopSearch, shopSearchBean);
        }
        PagerListBean<Shop> list = shopDomainService.listShopByPage(shopSearch, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(ShopBean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 批量添加店铺
     * @param shopBeans
     * @return
     */
    @Override
    public List<Long> batchAddShop(List<ShopBean> shopBeans) {

        return shopDomainService.batchAddShop(BeanUtils.copyList(Shop.class, shopBeans));
    }
}
