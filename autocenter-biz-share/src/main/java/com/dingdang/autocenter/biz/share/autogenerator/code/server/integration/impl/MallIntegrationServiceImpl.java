package com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.MallIntegrationService;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.param.MallParam;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.param.MallSearchParam;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.result.MallResult;
import com.dingdang.autocenter.common.facade.beans.MallBean;
import com.dingdang.autocenter.common.facade.beans.MallSearchBean;
import com.dingdang.autocenter.common.facade.interfaces.MallFacadeService;
import com.dingdang.autocenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Service
public class MallIntegrationServiceImpl implements MallIntegrationService {

    @Autowired
    private MallFacadeService mallFacadeService;

    /**
     * 新增商城
     * @param mallParam
     * @return
     */
    @Override
    public MallResult addMall(MallParam mallParam) {

        MallBean mallBean = new MallBean();
        BeanUtils.copyProperties2(mallBean, mallParam);
        return Optionals.transformBean(mallFacadeService.addMall(mallBean), MallResult.class);
    }

    /**
     * 修改商城
     * @param mallParam
     * @return
     */
    @Override
    public MallResult modifyMall(MallParam mallParam) {

        MallBean mallBean = new MallBean();
        BeanUtils.copyProperties2(mallBean, mallParam);
        return Optionals.transformBean(mallFacadeService.modifyMall(mallBean), MallResult.class);
    }

    /**
     * 删除商城
     * @param mallId
     */
    @Override
    public void removeMall(Long mallId) {

        mallFacadeService.removeMall(mallId);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public MallResult getMallDetail(Long mallId) {

        return Optionals.transformBean(mallFacadeService.getMallDetail(mallId), MallResult.class);
    }

    /**
     * 分页列出商城列表
     * @param mallSearchParam
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<MallResult> listMallByPage(MallSearchParam mallSearchParam, PagerListBean pagerListBean) {

        MallSearchBean mallSearchBean = new MallSearchBean();
        if (mallSearchParam != null) {
            BeanUtils.copyProperties2(mallSearchBean, mallSearchParam);
        }
        PagerListBean<MallBean> list = mallFacadeService.listMallByPage(mallSearchBean, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(MallResult.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 列出商城
     * @param mallSearchParam
     * @return
     */
    @Override
    public List<MallResult> listMall(MallSearchParam mallSearchParam) {

        MallSearchBean mallSearchBean = new MallSearchBean();
        if (mallSearchParam != null) {
           BeanUtils.copyProperties2(mallSearchBean, mallSearchParam);
        }
        return BeanUtils.copyList(MallResult.class, mallFacadeService.listMall(mallSearchBean));
    }

    /**
     * 根据条件得到商城
     * @param mallSearchParam
     * @return
     */
    @Override
    public MallResult getMallByCondition(MallSearchParam mallSearchParam){

        MallSearchBean mallSearchBean = new MallSearchBean();
        if (mallSearchParam != null) {
            BeanUtils.copyProperties2(mallSearchBean, mallSearchParam);
        }
        return Optionals.transformBean(mallFacadeService.getMallByCondition(mallSearchBean), MallResult.class);
    }

    /**
     * 批量添加商城
     * @param mallParams
     */
    @Override
    public void batchAddMall(List<MallParam> mallParams){

        mallFacadeService.batchAddMall(BeanUtils.copyList(MallBean.class, mallParams));
    }
}