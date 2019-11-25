package com.dingdang.shopcenter.biz.shop.repository;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.NavigationSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Navigation;

import java.util.List;
/**
 * @author ysh
 * @description
 * @date 2019/10/15
 */
public interface NavigationRepository {

    /**
     * 增加快捷导航
     * @param navigation
     */
    void addNavigation(Navigation navigation);

    /**
     * 修改快捷导航
     * @param navigation
     */
    void modifyNavigation(Navigation navigation);

    /**
     * 移除快捷导航
     * @param navigationId
     */
    void removeNavigation(Long navigationId);

    /**
     * 得到快捷导航详情
     * @param navigationId
     */
    Navigation getNavigationDetail(Long navigationId);

    /**
     * 列出快捷导航
     * @param navigationSearch
     */
    List<Navigation> listNavigation(NavigationSearch navigationSearch);

    /**
     * 分页列出快捷导航
     * @param navigationSearch
     * @param pagerListBean
     */
    PagerListBean<Navigation> listNavigationByPage(NavigationSearch navigationSearch, PagerListBean pagerListBean);

    /**
     * 根据条件得到快捷导航
     * @param navigationSearch
     */
    Navigation getNavigationByCondition(NavigationSearch navigationSearch);
}