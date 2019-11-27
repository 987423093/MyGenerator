package com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.param.BannerSearchParam;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.param.BannerParam;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.result.BannerResult;
import java.util.List;

/**
 * @author zhoutao’s template
 * @date 2019/11/27
 */
public interface BannerIntegrationService {

    /**
     * 新增横幅
     * @param bannerParam
     * @return
     */
    BannerResult addBanner(BannerParam bannerParam);
    
    /**
     * 修改横幅
     * @param bannerParam
     * @return
     */
    BannerResult modifyBanner(BannerParam bannerParam);
    
    /**
     * 删除横幅
     * @param bannerId
     */
    void removeBanner(Long bannerId);
    
    /**
     * 得到横幅详情
     * @param bannerId
     * @return
     */
    BannerResult getBannerDetail(Long bannerId);
    
    /**
     * 分页列出横幅列表
     * @param bannerSearchParam
     * @param pagerListBean
     * @return
     */
    PagerListBean<BannerResult> listBannerByPage(BannerSearchParam bannerSearchParam, PagerListBean pagerListBean);
    
    /**
     * 列出横幅
     * @param bannerSearchParam
     * @return
     */
    List<BannerResult> listBanner(BannerSearchParam bannerSearchParam);

    /**
     * 批量添加横幅
     * @param bannerParams
     */
    void batchAddBanner(List<BannerParam> bannerParams);
}
