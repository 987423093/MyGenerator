package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;
import com.dingdang.shopcenter.biz.shop.domainservice.BannerDomainService;
import com.dingdang.shopcenter.common.facade.beans.BannerBean;
import com.dingdang.shopcenter.common.facade.beans.BannerSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.BannerFacadeService;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
@Service
public class BannerFacadeServiceImpl implements BannerFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(BannerFacadeServiceImpl.class);

    @Autowired
    private BannerDomainService bannerDomainService;

    /**
     * 增加横幅
     * @param bannerBean
     * @return
     */
    @Override
    public BannerBean addBanner(BannerBean bannerBean){

        if (bannerBean == null){
            logger.error("Fail to addBanner ! bannerBean must not be null !");
            throw new ServiceException(-1, "bannerBean 不能为空");
        }
        Banner banner = new Banner();
        BeanUtils.copyProperties2(banner, bannerBean);
        return Optionals.transformBean(bannerDomainService.addBanner(banner), BannerBean.class);
    }

    /**
     * 修改横幅
     * @param bannerBean
     * @return
     */
    @Override
    public BannerBean modifyBanner(BannerBean bannerBean){

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
        return Optionals.transformBean(bannerDomainService.modifyBanner(banner), BannerBean.class);
    }

    /**
     * 移除横幅
     * @param bannerId
     */
    @Override
    public void removeBanner(Long bannerId){

        if (bannerId == null){
            logger.error("Fail to getBannerDetail ! bannerId must not be null !");
            throw new ServiceException(-1, "bannerId 不能为空");
        }
        bannerDomainService.removeBanner(bannerId);
    }

    /**
     * 得到横幅详情
     * @param bannerId
     * @return
     */
    @Override
    public BannerBean getBannerDetail(Long bannerId){

        if (bannerId == null){
            logger.error("Fail to getBannerDetail ! bannerId must not be null !");
            throw new ServiceException(-1, "bannerId 不能为空");
        }
        return Optionals.transformBean(bannerDomainService.getBannerDetail(bannerId), BannerBean.class);
    }

    /**
     * 列出横幅
     * @param bannerSearchBean
     * @return
     */
    @Override
    public List<BannerBean> listBanner(BannerSearchBean bannerSearchBean){

        BannerSearch bannerSearch = new BannerSearch();
        if (bannerSearchBean != null) {
            BeanUtils.copyProperties2(bannerSearch, bannerSearchBean);
        }
        return BeanUtils.copyList(BannerBean.class, bannerDomainService.listBanner(bannerSearch));
    }

    /**
     * 分页列出横幅
     * @param bannerSearchBean
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<BannerBean> listBannerByPage(BannerSearchBean bannerSearchBean, PagerListBean pagerListBean){

        BannerSearch bannerSearch = new BannerSearch();
        if (bannerSearchBean != null) {
            BeanUtils.copyProperties2(bannerSearch, bannerSearchBean);
        }
        PagerListBean<Banner> list = bannerDomainService.listBannerByPage(bannerSearch, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(BannerBean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 根据条件得到横幅
     * @param bannerSearchBean
     * @return
     */
    @Override
    public BannerBean getBannerByCondition(BannerSearchBean bannerSearchBean){

        BannerSearch bannerSearch = new BannerSearch();
        if (bannerSearchBean != null) {
            BeanUtils.copyProperties2(bannerSearch, bannerSearchBean);
        }
        return Optionals.transformBean(bannerDomainService.getBannerByCondition(bannerSearch), BannerBean.class);
    }

    /**
     * 批量添加横幅
     * @param bannerBeans
     */
    @Override
    public void batchAddBanner(List<BannerBean> bannerBeans){

        if (CollectionUtils.isEmpty(bannerBeans)){
            logger.error("Fail to batchAddBanner ! bannerBeans must not be null !");
            throw new ServiceException(-1, "bannerBeans 不能为空");
        }
        bannerDomainService.batchAddBanner(BeanUtils.copyList(Banner.class, bannerBeans));
    }
}