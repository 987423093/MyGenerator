package com.dingdang.autocenter.biz.share.autogenerator.code.server.web;

import com.dingdang.commons.annotations.Param;
import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.MallIntegrationService;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.param.MallParam;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.param.MallSearchParam;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.result.MallResult;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.web.request.MallRequest;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.web.request.MallSearchRequest;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.web.response.MallResponse;
import com.dingdang.autocenter.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Service("mall")
public class MallWebServer {

    private final transient Logger logger = LoggerFactory.getLogger(MallWebServer.class);

    @Autowired
    private MallIntegrationService mallIntegrationService;

    /**
     * 新增商城
     * @param mallRequest
     * @return
     */
    public MallResponse addMall(@Param(name = "userId", type = Long.class) Long userId,
                                          @Param(name = "mallRequest", type = MallRequest.class) MallRequest mallRequest) {

        if (mallRequest == null){
            logger.error("Fail to addMall ! mallRequest must not be null !");
            throw new ServiceException(-1, "mallRequest 不能为空");
        }
        if (StringUtils.isBlank(mallRequest.getMallName())){
            logger.error("Fail to addMall ! mallName must not be empty !");
            throw new ServiceException(-1, "商城名称 不能为空字符串");
        }
        MallParam mallParam = new MallParam();
        BeanUtils.copyProperties2(mallParam, mallRequest);
        mallParam.setCreator(userId);
        return Optionals.transformBean(mallIntegrationService.addMall(mallParam), MallResponse.class);
    }

    /**
     * 修改商城
     * @param mallRequest
     * @return
     */
    public MallResponse modifyMall(@Param(name = "userId", type = Long.class) Long userId,
                                             @Param(name = "mallRequest", type = MallRequest.class) MallRequest mallRequest) {

        if (mallRequest == null){
            logger.error("Fail to modifyMall ! mallRequest must not be null !");
            throw new ServiceException(-1, "mallRequest 不能为空");
        }
        if (mallRequest.getMallId() == null){
            logger.error("Fail to modifyMall ! mallRequest.getMallId() must not be null !");
            throw new ServiceException(-1, "mallRequest.getMallId() 不能为空");
        }
        MallParam mallParam = new MallParam();
        BeanUtils.copyProperties2(mallParam, mallRequest);
        mallParam.setModifier(userId);
        return Optionals.transformBean(mallIntegrationService.modifyMall(mallParam), MallResponse.class);
    }

    /**
     * 删除商城
     * @param mallId
     */
    public void removeMall(@Param(name = "mallId", type = Long.class) Long mallId) {

        if (mallId == null){
            logger.error("Fail to removeMall ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        mallIntegrationService.removeMall(mallId);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    public MallResponse getMallDetail(@Param(name = "mallId", type = Long.class) Long mallId) {

        if (mallId == null){
            logger.error("Fail to getMallDetail ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        return Optionals.transformBean(mallIntegrationService.getMallDetail(mallId), MallResponse.class);
    }

    /**
     * 分页列出商城列表
     * @param mallSearchRequest
     * @param pagerListBean
     * @return
     */
    public PagerListBean<MallResponse> listMallByPage(@Param(name = "mallSearchRequest", type = MallSearchRequest.class) MallSearchRequest mallSearchRequest,
                                                                @Param(name = "pagerListBean", type = PagerListBean.class) PagerListBean pagerListBean) {

        MallSearchParam mallSearchParam = new MallSearchParam();
        if (mallSearchRequest != null) {
            BeanUtils.copyProperties2(mallSearchParam, mallSearchRequest);
        }
        PagerListBean<MallResult> list = mallIntegrationService.listMallByPage(mallSearchParam, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(MallResponse.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 列出商城
     * @param mallSearchRequest
     * @return
     */
    public List<MallResponse> listMall(@Param(name = "mallSearchRequest", type = MallSearchRequest.class) MallSearchRequest mallSearchRequest) {

        MallSearchParam mallSearchParam = new MallSearchParam();
        if (mallSearchRequest != null) {
            BeanUtils.copyProperties2(mallSearchParam, mallSearchRequest);
        }
        return BeanUtils.copyList(MallResponse.class, mallIntegrationService.listMall(mallSearchParam));
    }
}