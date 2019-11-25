package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.ShopSearch;
import com.dingdang.shopcenter.biz.shop.dao.ShopMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.Shop;
import com.dingdang.shopcenter.biz.shop.dataobject.ShopExample;
import com.dingdang.shopcenter.biz.shop.repository.ShopRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Repository
public class ShopRepositoryImpl implements ShopRepository {

    @Autowired
    private ShopMapper shopMapper;

    /**
     * 增加店铺
     * @param shop
     */
    @Override
    public void addShop(Shop shop) {

        Assert.notNull(shop, "shop must not be null !");
        Assert.notNull(shop.getShopName(), "shop.getShopName() must not be null !");
        Assert.notNull(shop.getShopType(), "shop.getShopType() must not be null !");
        Assert.notNull(shop.getMerchantNo(), "shop.getMerchantId() must not be null !");
        shop.setEnableStatus(1);
        Optionals.setDefaultInsert(shop);
        shopMapper.insert(shop);
    }

    /**
     * 修改店铺
     * @param shop
     */
    @Override
    public void modifyShop(Shop shop) {

        Assert.notNull(shop, "shop must not be null !");
        Assert.notNull(shop.getShopId(), "shop.getShopId() must not be null !");
        Optionals.setDefaultModify(shop);
        shopMapper.updateByPrimaryKeySelective(shop);
    }

    /**
     * 得到店铺详情
     * @param shopId
     * @return
     */
    @Override
    public Shop getShopDetail(Long shopId) {

        Assert.notNull(shopId, "shopId must not be null !");
        Shop shop = shopMapper.selectByPrimaryKey(shopId);
        return (Shop) Optionals.getDefaultDetail(shop);
    }

    /**
     * 移除店铺
     * @param shopId
     */
    @Override
    public void removeShop(Long shopId) {

        Assert.notNull(shopId, "shopId must not be null !");
        Shop shop = new Shop();
        shop.setShopId(shopId);
        shop.setState(StateEnum.NOT_USE.getCode());
        shopMapper.updateByPrimaryKeySelective(shop);
    }

    /**
     * 列出店铺
     * @param shopSearch
     * @return
     */
    @Override
    public List<Shop> listShop(ShopSearch shopSearch) {

        ShopExample shopExample = new ShopExample();
        this.setCondition(shopExample, shopSearch);
        return shopMapper.selectByExample(shopExample);
    }

    /**
     * 分页列出店铺
     * @param shopSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Shop> listShopByPage(ShopSearch shopSearch, PagerListBean pagerListBean) {

        ShopExample shopExample = new ShopExample();
        this.setCondition(shopExample, shopSearch);
        Optionals.setDefaultOrderBy(shopExample, pagerListBean);
        pagerListBean.setTotal((long) shopMapper.countByExample(shopExample));
        pagerListBean.setItems(shopMapper.selectByExample(shopExample));
        return pagerListBean;
    }

    /**
     * 批量添加店铺
     * @param shops
     * @return
     */
    @Override
    public List<Long> batchAddShop(List<Shop> shops) {

        List<Long> shopIds = new ArrayList<>();
        for (Shop shop : shops) {
            Optionals.setDefaultInsert(shop);
            shopMapper.insert(shop);
            shopIds.add(shop.getShopId());
        }
        return shopIds;
    }

    /**
     * 设置条件
     * @param shopExample
     * @param shopSearch
     */
    private void setCondition(ShopExample shopExample, ShopSearch shopSearch){

        ShopExample.Criteria criteria = shopExample.createCriteria();
        if (shopSearch != null) {
            //店铺名称
            if (StringUtils.isNotBlank(shopSearch.getShopName())) {
                criteria.andShopNameLike("%" + shopSearch.getShopName() + "%");
            }
            //启用禁用
            if (shopSearch.getEnableStatus() != null) {
                criteria.andEnableStatusEqualTo(shopSearch.getEnableStatus());
            }
            //商户编号
            if (StringUtils.isNotBlank(shopSearch.getMerchantNo())) {
                criteria.andMerchantNoEqualTo(shopSearch.getMerchantNo());
            }
            //店铺id列表
            if (CollectionUtils.isNotEmpty(shopSearch.getShopIds())){
                criteria.andShopIdIn(shopSearch.getShopIds());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}
