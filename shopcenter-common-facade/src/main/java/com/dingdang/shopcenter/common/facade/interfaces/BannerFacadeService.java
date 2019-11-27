package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.BannerBean;
import com.dingdang.shopcenter.common.facade.beans.BannerSearchBean;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/11/27
 */
public interface BannerFacadeService {

    /**
     * 增加横幅
     * @param bannerBean
     * @return
     */
    BannerBean addBanner(BannerBean bannerBean);

    /**
     * 修改横幅
     * @param bannerBean
     * @return
     */
    BannerBean modifyBanner(BannerBean bannerBean);

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
    BannerBean getBannerDetail(Long bannerId);

    /**
     * 列出横幅
     * @param bannerSearchBean
     * @return
     */
    List<BannerBean> listBanner(BannerSearchBean bannerSearchBean);

    /**
     * 分页列出横幅
     * @param bannerSearchBean
     * @param pagerListBean
     * @return
     */
    PagerListBean<BannerBean> listBannerByPage(BannerSearchBean bannerSearchBean, PagerListBean pagerListBean);

    /**
     * 根据条件得到横幅
     * @param bannerSearchBean
     * @return
     */
    BannerBean getBannerByCondition(BannerSearchBean bannerSearchBean);

    /**
     * 批量添加横幅
     * @param bannerBeans
     */
    void batchAddBanner(List<BannerBean> bannerBeans);
}