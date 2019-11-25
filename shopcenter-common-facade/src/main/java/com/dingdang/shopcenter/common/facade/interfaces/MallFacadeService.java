package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.MallBean;
import com.dingdang.shopcenter.common.facade.beans.MallSearchBean;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/10/9
 */
public interface MallFacadeService {

    /**
     * 增加商城
     * @param mallBean
     */
    void addMall(MallBean mallBean);

    /**
     * 修改商城
     * @param mallBean
     */
    void modifyMall(MallBean mallBean);

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    MallBean getMallDetail(Long mallId);

    /**
     * 移除商城
     * @param mallId
     */
    void removeMall(Long mallId);

    /**
     * 列出商城
     * @param mallSearchBean
     * @return
     */
    List<MallBean> listMall(MallSearchBean mallSearchBean);

    /**
     * 分页列出商城
     * @param mallSearchBean
     * @return
     */
    PagerListBean<MallBean> listMallByPage(MallSearchBean mallSearchBean, PagerListBean pagerListBean);
}
