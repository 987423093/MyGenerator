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
 * @author zhoutao
 * @date 2019/9/30
 */
@Service
public class BannerDomainServiceImpl implements BannerDomainService {

    @Autowired
    private BannerRepository bannerRepository;

    /**
     * 增加banner
     * @param banner
     */
    @Override
    public void addBanner(Banner banner) {

        bannerRepository.addBanner(banner);
    }

    /**
     * 修改banner
     * @param banner
     */
    @Override
    public void modifyBanner(Banner banner) {

        bannerRepository.modifyBanner(banner);
    }

    /**
     * 得到banner详情
     * @param bannerId
     * @return
     */
    @Override
    public Banner getBannerDetail(Long bannerId) {

        return bannerRepository.getBannerDetail(bannerId);
    }

    /**
     * 移除banner
     * @param bannerId
     */
    @Override
    public void removeBanner(Long bannerId) {

        bannerRepository.removeBanner(bannerId);
    }

    /**
     * 列出banner
     * @param bannerSearch
     * @return
     */
    @Override
    public List<Banner> listBanner(BannerSearch bannerSearch) {

        return bannerRepository.listBanner(bannerSearch);
    }

    /**
     * 分页列出banner
     * @param bannerSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Banner> listBannerByPage(BannerSearch bannerSearch, PagerListBean pagerListBean) {

        return bannerRepository.listBannerByPage(bannerSearch, pagerListBean);
    }
}
