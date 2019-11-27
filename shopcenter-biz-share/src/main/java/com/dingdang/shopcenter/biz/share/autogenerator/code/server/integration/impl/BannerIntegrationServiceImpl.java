package com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.BannerIntegrationService;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.param.BannerParam;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.param.BannerSearchParam;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.result.BannerResult;
import com.dingdang.shopcenter.common.facade.beans.BannerBean;
import com.dingdang.shopcenter.common.facade.beans.BannerSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.BannerFacadeService;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao’s template
 * @date 2019/11/27
 */
@Service
public class BannerIntegrationServiceImpl implements BannerIntegrationService {

    @Autowired
    private BannerFacadeService bannerFacadeService;

    /**
     * 新增横幅
     * @param bannerParam
     * @return
     */
    @Override
    public BannerResult addBanner(BannerParam bannerParam) {

        BannerBean bannerBean = new BannerBean();
        BeanUtils.copyProperties2(bannerBean, bannerParam);
        return Optionals.transformBean(bannerFacadeService.addBanner(bannerBean), BannerResult.class);
    }

    /**
     * 修改横幅
     * @param bannerParam
     * @return
     */
    @Override
    public BannerResult modifyBanner(BannerParam bannerParam) {

        BannerBean bannerBean = new BannerBean();
        BeanUtils.copyProperties2(bannerBean, bannerParam);
        return Optionals.transformBean(bannerFacadeService.modifyBanner(bannerBean), BannerResult.class);
    }

    /**
     * 删除横幅
     * @param bannerId
     */
    @Override
    public void removeBanner(Long bannerId) {

        bannerFacadeService.removeBanner(bannerId);
    }

    /**
     * 得到横幅详情
     * @param bannerId
     * @return
     */
    @Override
    public BannerResult getBannerDetail(Long bannerId) {

        return Optionals.transformBean(bannerFacadeService.getBannerDetail(bannerId), BannerResult.class);
    }

    /**
     * 分页列出横幅列表
     * @param bannerSearchParam
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<BannerResult> listBannerByPage(BannerSearchParam bannerSearchParam, PagerListBean pagerListBean) {

        BannerSearchBean bannerSearchBean = new BannerSearchBean();
        if (bannerSearchParam != null) {
            BeanUtils.copyProperties2(bannerSearchBean, bannerSearchParam);
        }
        PagerListBean<BannerBean> list = bannerFacadeService.listBannerByPage(bannerSearchBean, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(BannerResult.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 列出横幅
     * @param bannerSearchParam
     * @return
     */
    @Override
    public List<BannerResult> listBanner(BannerSearchParam bannerSearchParam) {

        BannerSearchBean bannerSearchBean = new BannerSearchBean();
        if (bannerSearchParam != null) {
           BeanUtils.copyProperties2(bannerSearchBean, bannerSearchParam);
        }
        return BeanUtils.copyList(BannerResult.class, bannerFacadeService.listBanner(bannerSearchBean));
    }

    /**
     * 批量添加横幅
     * @param bannerParams
     */
    @Override
    public void batchAddBanner(List<BannerParam> bannerParams){

        bannerFacadeService.batchAddBanner(BeanUtils.copyList(BannerBean.class, bannerParams));
    }
}