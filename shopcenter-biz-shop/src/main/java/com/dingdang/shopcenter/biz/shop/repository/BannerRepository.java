package com.dingdang.shopcenter.biz.shop.repository;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
public interface BannerRepository {

    /**
     * 增加横幅
     * @param banner
     * @return
     */
    Banner addBanner(Banner banner);

    /**
     * 修改横幅
     * @param banner
     * @return
     */
    Banner modifyBanner(Banner banner);

    /**
     * 移除横幅
     * @param bannerId
     */
    void removeBanner(Long bannerId);

    /**
     * 得到横幅详情
     * @param bannerId
     * @return
     */
    Banner getBannerDetail(Long bannerId);

    /**
     * 列出横幅
     * @param bannerSearch
     * @return
     */
    List<Banner> listBanner(BannerSearch bannerSearch);

    /**
     * 分页列出横幅
     * @param bannerSearch
     * @param pagerListBean
     * @return
     */
    PagerListBean<Banner> listBannerByPage(BannerSearch bannerSearch, PagerListBean pagerListBean);

    /**
     * 根据条件得到横幅
     * @param bannerSearch
     * @return
     */
    Banner getBannerByCondition(BannerSearch bannerSearch);

    /**
     * 批量添加横幅
     * @param banners
     */
    void batchAddBanner(List<Banner> banners);
}