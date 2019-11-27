package com.dingdang.shopcenter.biz.share.autogenerator.code.server.web;

import com.dingdang.commons.annotations.Param;
import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.BannerIntegrationService;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.param.BannerParam;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.param.BannerSearchParam;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.integration.result.BannerResult;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.web.request.BannerRequest;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.web.request.BannerSearchRequest;
import com.dingdang.shopcenter.biz.share.autogenerator.code.server.web.response.BannerResponse;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author zhoutao’s template
 * @date 2019/11/27
 */
@Service("banner")
public class BannerWebServer {

    private final transient Logger logger = LoggerFactory.getLogger(BannerWebServer.class);

    @Autowired
    private BannerIntegrationService bannerIntegrationService;

    /**
     * 新增横幅
     * @param bannerRequest
     * @return
     */
    public BannerResponse addBanner(@Param(name = "userId", type = Long.class) Long userId,
                                          @Param(name = "bannerRequest", type = BannerRequest.class) BannerRequest bannerRequest) {

        if (bannerRequest == null){
            logger.error("Fail to addBanner ! bannerRequest must not be null !");
            throw new ServiceException(-1, "bannerRequest 不能为空");
        }
        BannerParam bannerParam = new BannerParam();
        BeanUtils.copyProperties2(bannerParam, bannerRequest);
        bannerParam.setCreator(userId);
        return Optionals.transformBean(bannerIntegrationService.addBanner(bannerParam), BannerResponse.class);
    }

    /**
     * 修改横幅
     * @param bannerRequest
     * @return
     */
    public BannerResponse modifyBanner(@Param(name = "userId", type = Long.class) Long userId,
                                             @Param(name = "bannerRequest", type = BannerRequest.class) BannerRequest bannerRequest) {

        if (bannerRequest == null){
            logger.error("Fail to modifyBanner ! bannerRequest must not be null !");
            throw new ServiceException(-1, "bannerRequest 不能为空");
        }
        if (bannerRequest.getBannerId() == null){
            logger.error("Fail to modifyBanner ! bannerRequest.getBannerId() must not be null !");
            throw new ServiceException(-1, "bannerRequest.getBannerId() 不能为空");
        }
        BannerParam bannerParam = new BannerParam();
        BeanUtils.copyProperties2(bannerParam, bannerRequest);
        bannerParam.setModifier(userId);
        return Optionals.transformBean(bannerIntegrationService.modifyBanner(bannerParam), BannerResponse.class);
    }

    /**
     * 删除横幅
     * @param bannerId
     */
    public void removeBanner(@Param(name = "bannerId", type = Long.class) Long bannerId) {

        if (bannerId == null){
            logger.error("Fail to removeBanner ! bannerId must not be null !");
            throw new ServiceException(-1, "bannerId 不能为空");
        }
        bannerIntegrationService.removeBanner(bannerId);
    }

    /**
     * 得到横幅详情
     * @param bannerId
     * @return
     */
    public BannerResponse getBannerDetail(@Param(name = "bannerId", type = Long.class) Long bannerId) {

        if (bannerId == null){
            logger.error("Fail to getBannerDetail ! bannerId must not be null !");
            throw new ServiceException(-1, "bannerId 不能为空");
        }
        return Optionals.transformBean(bannerIntegrationService.getBannerDetail(bannerId), BannerResponse.class);
    }

    /**
     * 分页列出横幅列表
     * @param bannerSearchRequest
     * @param pagerListBean
     * @return
     */
    public PagerListBean<BannerResponse> listBannerByPage(@Param(name = "bannerSearchRequest", type = BannerSearchRequest.class) BannerSearchRequest bannerSearchRequest,
                                                                @Param(name = "pagerListBean", type = PagerListBean.class) PagerListBean pagerListBean) {

        BannerSearchParam bannerSearchParam = new BannerSearchParam();
        if (bannerSearchRequest != null) {
            BeanUtils.copyProperties2(bannerSearchParam, bannerSearchRequest);
        }
        PagerListBean<BannerResult> list = bannerIntegrationService.listBannerByPage(bannerSearchParam, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(BannerResponse.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 列出横幅
     * @param bannerSearchRequest
     * @return
     */
    public List<BannerResponse> listBanner(@Param(name = "bannerSearchRequest", type = BannerSearchRequest.class) BannerSearchRequest bannerSearchRequest) {

        BannerSearchParam bannerSearchParam = new BannerSearchParam();
        if (bannerSearchRequest != null) {
            BeanUtils.copyProperties2(bannerSearchParam, bannerSearchRequest);
        }
        return BeanUtils.copyList(BannerResponse.class, bannerIntegrationService.listBanner(bannerSearchParam));
    }
}