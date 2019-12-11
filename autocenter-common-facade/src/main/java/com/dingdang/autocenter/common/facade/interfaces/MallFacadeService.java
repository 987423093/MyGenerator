package com.dingdang.autocenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.autocenter.common.facade.beans.MallBean;
import com.dingdang.autocenter.common.facade.beans.MallSearchBean;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
public interface MallFacadeService {

    /**
     * 增加商城
     * @param mallBean
     * @return
     */
    MallBean addMall(MallBean mallBean);

    /**
     * 修改商城
     * @param mallBean
     * @return
     */
    MallBean modifyMall(MallBean mallBean);

    /**
     * 移除商城
     * @param mallId
     */
    void removeMall(Long mallId);

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    MallBean getMallDetail(Long mallId);

    /**
     * 列出商城
     * @param mallSearchBean
     * @return
     */
    List<MallBean> listMall(MallSearchBean mallSearchBean);

    /**
     * 分页列出商城
     * @param mallSearchBean
     * @param pagerListBean
     * @return
     */
    PagerListBean<MallBean> listMallByPage(MallSearchBean mallSearchBean, PagerListBean pagerListBean);

    /**
     * 根据条件得到商城
     * @param mallSearchBean
     * @return
     */
    MallBean getMallByCondition(MallSearchBean mallSearchBean);

    /**
     * 批量添加商城
     * @param mallBeans
     */
    void batchAddMall(List<MallBean> mallBeans);
}