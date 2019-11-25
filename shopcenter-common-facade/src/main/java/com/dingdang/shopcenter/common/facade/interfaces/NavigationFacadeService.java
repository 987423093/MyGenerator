package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.NavigationBean;
import com.dingdang.shopcenter.common.facade.beans.NavigationSearchBean;

import java.util.List;

/**
* @author zhoutao's template
*/
public interface NavigationFacadeService {

    /**
     * 增加快捷导航
     * @param navigationBean
     */
    void addNavigation(NavigationBean navigationBean);

    /**
     * 修改快捷导航
     * @param navigationBean
     */
    void modifyNavigation(NavigationBean navigationBean);

    /**
     * 移除快捷导航
     * @param navigationId
     */
    void removeNavigation(Long navigationId);

    /**
     * 得到快捷导航详情
     * @param navigationId
     */
    NavigationBean getNavigationDetail(Long navigationId);

    /**
     * 列出快捷导航
     * @param navigationSearchBean
     */
    List<NavigationBean> listNavigation(NavigationSearchBean navigationSearchBean);

    /**
     * 分页列出快捷导航
     * @param navigationSearchBean
     * @param pagerListBean
     */
    PagerListBean<NavigationBean> listNavigationByPage(NavigationSearchBean navigationSearchBean, PagerListBean pagerListBean);

    /**
     * 根据条件得到快捷导航
     * @param navigationSearchBean
     */
    NavigationBean getNavigationByCondition(NavigationSearchBean navigationSearchBean);
}