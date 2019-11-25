package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.NavigationSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Navigation;
import com.dingdang.shopcenter.biz.shop.domainservice.NavigationDomainService;
import com.dingdang.shopcenter.common.facade.beans.NavigationBean;
import com.dingdang.shopcenter.common.facade.beans.NavigationSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.NavigationFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @author zhoutao's template
*/
@Service
public class NavigationFacadeServiceImpl implements NavigationFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(NavigationFacadeServiceImpl.class);

    @Autowired
    private NavigationDomainService navigationDomainService;

    /**
     * 增加快捷导航
     * @param navigationBean
     */
    @Override
    public void addNavigation(NavigationBean navigationBean){

        if (navigationBean == null){
            logger.error("Fail to addNavigation ! navigationBean must not be null !");
            throw new ServiceException(-1, "navigationBean 不能为空");
        }
        if(StringUtils.isBlank(navigationBean.getNavigationName())){
            logger.error("Fail to addNavigation,NavigationName is null");
            throw new ServiceException(-1,"导航名称不能为空");
        }
        NavigationSearch navigationSearch = new NavigationSearch();
        navigationSearch.setNavigationName(navigationBean.getNavigationName());
        Navigation navigationByCondition = navigationDomainService.getNavigationByCondition(navigationSearch);
        if(navigationByCondition != null){
            logger.error("Fail to addNavigation,navigationByCondition is null");
            throw new ServiceException(-1,"该导航名称已存在!");
        }

        Navigation navigation = new Navigation();
        BeanUtils.copyProperties2(navigation, navigationBean);
        navigationDomainService.addNavigation(navigation);
    }

    /**
     * 修改快捷导航
     * @param navigationBean
     */
    @Override
    public void modifyNavigation(NavigationBean navigationBean){

        if (navigationBean == null){
             logger.error("Fail to modifyNavigation ! navigationBean must not be null !");
             throw new ServiceException(-1, "navigationBean 不能为空");
        }
        if (navigationBean.getNavigationId() == null){
            logger.error("Fail to modifyNavigation ! navigationBean.getNavigationId() must not be null !");
            throw new ServiceException(-1, "navigationBean.getNavigationId() 不能为空");
        }

        Navigation navigation = new Navigation();
        BeanUtils.copyProperties2(navigation, navigationBean);
        navigationDomainService.modifyNavigation(navigation);
    }

    /**
    * 移除快捷导航
    * @param navigationId
    */
    @Override
    public void removeNavigation(Long navigationId){

        navigationDomainService.removeNavigation(navigationId);
    }

    /**
     * 得到快捷导航详情
     * @param navigationId
     */
    @Override
    public NavigationBean getNavigationDetail(Long navigationId){

        if (navigationId == null){
            logger.error("Fail to getNavigationDetail ! navigationId must not be null !");
            throw new ServiceException(-1, "navigationId 不能为空");
        }

        Navigation navigation = navigationDomainService.getNavigationDetail(navigationId);
        if (navigation != null) {
            NavigationBean navigationBean = new NavigationBean();
            BeanUtils.copyProperties2(navigationBean, navigation);
            return navigationBean;
        }
        return null;
    }

    /**
     * 列出快捷导航
     * @param navigationSearchBean
     */
    @Override
    public List<NavigationBean> listNavigation(NavigationSearchBean navigationSearchBean){

        NavigationSearch navigationSearch = new NavigationSearch();
        if (navigationSearchBean != null) {
            BeanUtils.copyProperties2(navigationSearch, navigationSearchBean);
        }
        return BeanUtils.copyList(NavigationBean.class, navigationDomainService.listNavigation(navigationSearch));
    }

    /**
     * 分页列出快捷导航
     * @param navigationSearchBean
     * @param pagerListBean
     */
    @Override
    public PagerListBean<NavigationBean> listNavigationByPage(NavigationSearchBean navigationSearchBean, PagerListBean pagerListBean){

        NavigationSearch navigationSearch = new NavigationSearch();
        if (navigationSearchBean != null) {
            BeanUtils.copyProperties2(navigationSearch, navigationSearchBean);
        }
        PagerListBean<Navigation> list = navigationDomainService.listNavigationByPage(navigationSearch, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(NavigationBean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 根据条件得到快捷导航
     * @param navigationSearchBean
     */
    @Override
    public NavigationBean getNavigationByCondition(NavigationSearchBean navigationSearchBean){

        NavigationSearch navigationSearch = new NavigationSearch();
        if (navigationSearchBean != null) {
            BeanUtils.copyProperties2(navigationSearch, navigationSearchBean);
        }
        Navigation navigation = navigationDomainService.getNavigationByCondition(navigationSearch);
        if (navigation != null){
            NavigationBean navigationBean = new NavigationBean();
            BeanUtils.copyProperties2(navigationBean, navigation);
            return navigationBean;
        }
        return null;
    }
}