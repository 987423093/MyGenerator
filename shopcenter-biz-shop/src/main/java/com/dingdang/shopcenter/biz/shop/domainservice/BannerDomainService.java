package com.dingdang.shopcenter.biz.shop.domainservice;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
public interface BannerDomainService {

    /**
     * 增加banner
     * @param banner
     */
    void addBanner(Banner banner);

    /**
     * 修改banner
     * @param banner
     */
    void modifyBanner(Banner banner);

    /**
     * 得到banner详情
     * @param bannerId
     * @return
     */
    Banner getBannerDetail(Long bannerId);

    /**
     * 移除banner
     * @param bannerId
     */
    void removeBanner(Long bannerId);

    /**
     * 列出banner
     * @param bannerSearch
     * @return
     */
    List<Banner> listBanner(BannerSearch bannerSearch);

    /**
     * 分页列出banner
     * @param bannerSearch
     * @param pagerListBean
     * @return
     */
    PagerListBean<Banner> listBannerByPage(BannerSearch bannerSearch, PagerListBean pagerListBean);
}
