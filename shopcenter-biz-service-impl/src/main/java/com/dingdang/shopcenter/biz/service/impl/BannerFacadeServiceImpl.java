package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;
import com.dingdang.shopcenter.biz.shop.domainservice.BannerDomainService;
import com.dingdang.shopcenter.common.facade.beans.BannerBean;
import com.dingdang.shopcenter.common.facade.beans.BannerSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.BannerFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Service
public class BannerFacadeServiceImpl implements BannerFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(BannerFacadeServiceImpl.class);

    @Autowired
    private BannerDomainService bannerDomainService;

    /**
     * 增加banner
     * @param bannerBean
     */
    @Override
    public void addBanner(BannerBean bannerBean) {

        if (bannerBean == null){
            logger.error("Fail to addBanner ! bannerBean must not be null !");
            throw new ServiceException(-1, "bannerBean 不能为空");
        }
        if (bannerBean.getMallId() == null){
            logger.error("Fail to addBanner ! bannerBean.getMallId() must not be null !");
            throw new ServiceException(-1, "bannerBean.getMallId() 不能为空");
        }

        Banner banner = new Banner();
        BeanUtils.copyProperties2(banner, bannerBean);
        bannerDomainService.addBanner(banner);
    }

    /**
     * 修改banner
     * @param bannerBean
     */
    @Override
    public void modifyBanner(BannerBean bannerBean) {

        if (bannerBean == null){
            logger.error("Fail to modifyBanner ! bannerBean must not be null !");
            throw new ServiceException(-1, "bannerBean 不能为空");
        }
        if (bannerBean.getBannerId() == null){
            logger.error("Fail to modifyBanner ! bannerBean.getBannerId() must not be null !");
            throw new ServiceException(-1, "bannerBean.getBannerId() 不能为空");
        }
        Banner banner = new Banner();
        BeanUtils.copyProperties2(banner, bannerBean);
        bannerDomainService.modifyBanner(banner);
    }

    /**
     * 得到banner详情
     * @param bannerId
     * @return
     */
    @Override
    public BannerBean getBannerDetail(Long bannerId) {

        if (bannerId == null){
            logger.error("Fail to getBannerDetail ! bannerId must not be null !");
            throw new ServiceException(-1, "bannerId 不能为空");
        }
        Banner banner = bannerDomainService.getBannerDetail(bannerId);
        if (banner != null) {
            BannerBean bannerBean = new BannerBean();
            BeanUtils.copyProperties2(bannerBean, banner);
            return bannerBean;
        }
        return null;
    }

    /**
     * 移除banner
     * @param bannerId
     */
    @Override
    public void removeBanner(Long bannerId) {

        if (bannerId == null){
            logger.error("Fail to removeBanner ! bannerId must not be null !");
            throw new ServiceException(-1, "bannerId 不能为空");
        }
        bannerDomainService.removeBanner(bannerId);
    }

    /**
     * 列出banner
     * @param bannerSearchBean
     * @return
     */
    @Override
    public List<BannerBean> listBanner(BannerSearchBean bannerSearchBean) {

        BannerSearch bannerSearch = new BannerSearch();
        if (bannerSearchBean != null) {
            BeanUtils.copyProperties2(bannerSearch, bannerSearchBean);
        }
        return BeanUtils.copyList(BannerBean.class, bannerDomainService.listBanner(bannerSearch));
    }

    /**
     * 分页列出banner
     * @param bannerSearchBean
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<BannerBean> listBannerByPage(BannerSearchBean bannerSearchBean, PagerListBean pagerListBean) {

        BannerSearch bannerSearch = new BannerSearch();
        if (bannerSearchBean != null) {
            BeanUtils.copyProperties2(bannerSearch, bannerSearchBean);
        }
        PagerListBean<Banner> list = bannerDomainService.listBannerByPage(bannerSearch, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(BannerBean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }
}
