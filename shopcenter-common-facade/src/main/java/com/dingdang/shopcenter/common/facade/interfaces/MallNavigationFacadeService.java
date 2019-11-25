package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.shopcenter.common.facade.beans.MallNavigationBean;
import com.dingdang.shopcenter.common.facade.beans.MallNavigationSearchBean;

import java.util.List;

/**
* @author zhoutao's template
*/
public interface MallNavigationFacadeService {

    /**
     * 增加商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    void addMallNavigation(Long mallId,List<Long> navigationIdList);

    /**
     * 修改商城快捷导航
     * @param mallNavigationBean
     */
    void modifyMallNavigation(MallNavigationBean mallNavigationBean);

    /**
     * 移除商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    void removeMallNavigation(Long mallId,List<Long> navigationIdList);

    /**
     * 得到商城快捷导航详情
     * @param mallNavigationId
     */
    MallNavigationBean getMallNavigationDetail(Long mallNavigationId);

    /**
     * 列出商城快捷导航
     * @param mallNavigationSearchBean
     */
    List<MallNavigationBean> listMallNavigation(MallNavigationSearchBean mallNavigationSearchBean);

    /**
     * 根据条件得到商城快捷导航
     * @param mallNavigationSearchBean
     */
    MallNavigationBean getMallNavigationByCondition(MallNavigationSearchBean mallNavigationSearchBean);
}