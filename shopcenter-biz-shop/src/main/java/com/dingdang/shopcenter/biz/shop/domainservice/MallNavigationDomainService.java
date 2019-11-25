package com.dingdang.shopcenter.biz.shop.domainservice;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.MallNavigationSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigation;

import java.util.List;

/**
* @author zhoutao's template
*/
public interface MallNavigationDomainService {

    /**
     * 增加商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    void addMallNavigation(Long mallId,List<Long> navigationIdList);

    /**
     * 修改商城快捷导航
     * @param mallNavigation
     */
    void modifyMallNavigation(MallNavigation mallNavigation);

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
    MallNavigation getMallNavigationDetail(Long mallNavigationId);

    /**
     * 列出商城快捷导航
     * @param mallNavigationSearch
     */
    List<MallNavigation> listMallNavigation(MallNavigationSearch mallNavigationSearch);

    /**
     * 分页列出商城快捷导航
     * @param mallNavigationSearch
     * @param pagerListBean
     */
    PagerListBean<MallNavigation> listMallNavigationByPage(MallNavigationSearch mallNavigationSearch, PagerListBean pagerListBean);

    /**
     * 根据条件得到商城快捷导航
     * @param mallNavigationSearch
     */
    MallNavigation getMallNavigationByCondition(MallNavigationSearch mallNavigationSearch);
}