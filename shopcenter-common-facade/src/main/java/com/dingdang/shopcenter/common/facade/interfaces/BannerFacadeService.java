package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.BannerBean;
import com.dingdang.shopcenter.common.facade.beans.BannerSearchBean;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
public interface BannerFacadeService {

    /**
     * 增加banner
     * @param bannerBean
     */
    void addBanner(BannerBean bannerBean);

    /**
     * 修改banner
     * @param bannerBean
     */
    void modifyBanner(BannerBean bannerBean);

    /**
     * 得到banner详情
     * @param bannerId
     * @return
     */
    BannerBean getBannerDetail(Long bannerId);

    /**
     * 移除banner
     * @param bannerId
     */
    void removeBanner(Long bannerId);

    /**
     * 列出banner
     * @param bannerSearchBean
     * @return
     */
    List<BannerBean> listBanner(BannerSearchBean bannerSearchBean);

    /**
     * 分页列出banner
     * @param bannerSearchBean
     * @return
     */
    PagerListBean<BannerBean> listBannerByPage(BannerSearchBean bannerSearchBean, PagerListBean pagerListBean);
}
