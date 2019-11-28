package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dao.BannerMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;
import com.dingdang.shopcenter.biz.shop.dataobject.BannerExample;
import com.dingdang.shopcenter.biz.shop.repository.BannerRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
@Repository
public class BannerRepositoryImpl implements BannerRepository {

    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 增加横幅
     * @param banner
     * @return
     */
    @Override
    public Banner addBanner(Banner banner){

        Assert.notNull(banner, "banner must not be null !");
        Optionals.setDefaultInsert(banner);
        bannerMapper.insert(banner);
        return banner;
    }

    /**
     * 修改横幅
     * @param banner
     * @return
     */
    @Override
    public Banner modifyBanner(Banner banner){

        Assert.notNull(banner, "banner must not be null !");
        Assert.notNull(banner.getBannerId(), "banner.getBannerId() must not be null !");
        Optionals.setDefaultModify(banner);
        bannerMapper.updateByPrimaryKeySelective(banner);
        return banner;
    }

    /**
     * 移除横幅
     * @param bannerId
     */
    @Override
    public void removeBanner(Long bannerId){

        Assert.notNull(bannerId, "bannerId must not be null !");
        Banner banner = new Banner();
        banner.setBannerId(bannerId);
        banner.setState(StateEnum.NOT_USE.getCode());
        bannerMapper.updateByPrimaryKeySelective(banner);
    }

    /**
     * 得到横幅详情
     * @param bannerId
     * @return
     */
    @Override
    public Banner getBannerDetail(Long bannerId){

        Assert.notNull(bannerId, "bannerId must not be null !");
        Banner banner = bannerMapper.selectByPrimaryKey(bannerId);
        return (Banner) Optionals.getDefaultDetail(banner);
    }

    /**
     * 列出横幅
     * @param bannerSearch
     * @return
     */
    @Override
    public List<Banner> listBanner(BannerSearch bannerSearch){

        BannerExample bannerExample = new BannerExample();
        this.setCondition(bannerExample, bannerSearch);
        return bannerMapper.selectByExample(bannerExample);
    }

    /**
     * 分页列出横幅
     * @param bannerSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Banner> listBannerByPage(BannerSearch bannerSearch, PagerListBean pagerListBean){

        BannerExample bannerExample = new BannerExample();
        this.setCondition(bannerExample, bannerSearch);
        Optionals.setDefaultOrderBy(bannerExample, pagerListBean);
        pagerListBean.setTotal((long) bannerMapper.countByExample(bannerExample));
        pagerListBean.setItems(bannerMapper.selectByExample(bannerExample));
        return pagerListBean;
    }

    /**
     * 根据条件得到横幅
     * @param bannerSearch
     * @return
     */
    @Override
    public Banner getBannerByCondition(BannerSearch bannerSearch){

        BannerExample bannerExample = new BannerExample();
        this.setCondition(bannerExample, bannerSearch);
        List<Banner> banners = bannerMapper.selectByExample(bannerExample);
        if (CollectionUtils.isNotEmpty(banners)){
            return banners.get(0);
        }
        return null;
    }

    /**
     * 批量添加横幅
     * @param banners
     */
    @Override
    public void batchAddBanner(List<Banner> banners){

        for (Banner banner : banners){
            Optionals.setDefaultInsert(banner);
        }
        bannerMapper.insertBatch(banners);
    }

    /**
     * 设置条件
     * @param bannerExample
     * @param bannerSearch
     */
    private void setCondition(BannerExample bannerExample, BannerSearch bannerSearch){

        BannerExample.Criteria criteria = bannerExample.createCriteria();
        if (bannerSearch != null) {

            //banner名称
            if (StringUtils.isNotBlank(bannerSearch.getBannerName())){
                criteria.andBannerNameEqualTo(bannerSearch.getBannerName());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}