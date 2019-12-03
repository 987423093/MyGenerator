package com.dingdang.autocenter.biz.share.autogenerator.code.server.integration;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.param.MallSearchParam;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.param.MallParam;
import com.dingdang.autocenter.biz.share.autogenerator.code.server.integration.result.MallResult;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
public interface MallIntegrationService {

    /**
     * 新增商城
     * @param mallParam
     * @return
     */
    MallResult addMall(MallParam mallParam);
    
    /**
     * 修改商城
     * @param mallParam
     * @return
     */
    MallResult modifyMall(MallParam mallParam);
    
    /**
     * 删除商城
     * @param mallId
     */
    void removeMall(Long mallId);
    
    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    MallResult getMallDetail(Long mallId);
    
    /**
     * 分页列出商城列表
     * @param mallSearchParam
     * @param pagerListBean
     * @return
     */
    PagerListBean<MallResult> listMallByPage(MallSearchParam mallSearchParam, PagerListBean pagerListBean);
    
    /**
     * 列出商城
     * @param mallSearchParam
     * @return
     */
    List<MallResult> listMall(MallSearchParam mallSearchParam);

    /**
     * 根据条件得到商城
     * @param mallSearchParam
     * @return
     */
    MallResult getMallByCondition(MallSearchParam mallSearchParam);

    /**
     * 批量添加商城
     * @param mallParams
     */
    void batchAddMall(List<MallParam> mallParams);
}
