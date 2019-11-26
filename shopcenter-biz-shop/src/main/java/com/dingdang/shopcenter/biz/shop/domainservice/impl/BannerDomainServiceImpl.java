package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;
import com.dingdang.shopcenter.biz.shop.domainservice.BannerDomainService;
import com.dingdang.shopcenter.biz.shop.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao's template
 * @date 2019/11/26
 */
@Service
public class BannerDomainServiceImpl implements BannerDomainService {

    @Autowired
    private BannerRepository bannerRepository;

    /**
     * 增加横幅
     * @param banner
     */
    @Override
    public Banner addBanner(Banner banner){

        return bannerRepository.addBanner(banner);
    }

    /**
     * 修改横幅
     * @param banner
     */
    @Override
    public Banner modifyBanner(Banner banner){

        return bannerRepository.modifyBanner(banner);
    }

    /**
    * 移除横幅
    * @param bannerId
    */
    @Override
    public void removeBanner(Long bannerId){

        bannerRepository.removeBanner(bannerId);
    }

    /**
     * 得到横幅详情
     * @param bannerId
     */
    @Override
    public Banner getBannerDetail(Long bannerId){

        return bannerRepository.getBannerDetail(bannerId);
    }

    /**
     * 列出横幅
     * @param bannerSearch
     */
    @Override
    public List<Banner> listBanner(BannerSearch bannerSearch){

        return bannerRepository.listBanner(bannerSearch);
    }

    /**
     * 分页列出横幅
     * @param bannerSearch
     * @param pagerListBean
     */
    @Override
    public PagerListBean<Banner> listBannerByPage(BannerSearch bannerSearch, PagerListBean pagerListBean){

        return bannerRepository.listBannerByPage(bannerSearch, pagerListBean);
    }

    /**
     * 根据条件得到横幅
     * @param bannerSearch
     */
    @Override
    public Banner getBannerByCondition(BannerSearch bannerSearch){

        return bannerRepository.getBannerByCondition(bannerSearch);
    }

    /**
     * 批量添加横幅
     * @param banners
     */
    @Override
    public void batchAddBanner(List<Banner> banners){

        bannerRepository.batchAddBanner(banners);
    }
}