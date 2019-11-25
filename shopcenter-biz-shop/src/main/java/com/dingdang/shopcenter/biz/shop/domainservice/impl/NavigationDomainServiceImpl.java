package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.NavigationSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Navigation;
import com.dingdang.shopcenter.biz.shop.domainservice.NavigationDomainService;
import com.dingdang.shopcenter.biz.shop.repository.NavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/15
 */
@Service
public class NavigationDomainServiceImpl implements NavigationDomainService {

    @Autowired
    private NavigationRepository navigationRepository;

    /**
     * 增加快捷导航
     * @param navigation
     */
    @Override
    public void addNavigation(Navigation navigation){

        navigationRepository.addNavigation(navigation);
    }

    /**
     * 修改快捷导航
     * @param navigation
     */
    @Override
    public void modifyNavigation(Navigation navigation){

        navigationRepository.modifyNavigation(navigation);
    }

    /**
    * 移除快捷导航
    * @param navigationId
    */
    @Override
    public void removeNavigation(Long navigationId){

        navigationRepository.removeNavigation(navigationId);
    }

    /**
     * 得到快捷导航详情
     * @param navigationId
     */
    @Override
    public Navigation getNavigationDetail(Long navigationId){

        return navigationRepository.getNavigationDetail(navigationId);
    }

    /**
     * 列出快捷导航
     * @param navigationSearch
     */
    @Override
    public List<Navigation> listNavigation(NavigationSearch navigationSearch){

        return navigationRepository.listNavigation(navigationSearch);
    }

    /**
     * 分页列出快捷导航
     * @param navigationSearch
     * @param pagerListBean
     */
    @Override
    public PagerListBean<Navigation> listNavigationByPage(NavigationSearch navigationSearch, PagerListBean pagerListBean){

        return navigationRepository.listNavigationByPage(navigationSearch, pagerListBean);
    }

    /**
     * 根据条件得到快捷导航
     * @param navigationSearch
     */
    @Override
    public Navigation getNavigationByCondition(NavigationSearch navigationSearch){

        return navigationRepository.getNavigationByCondition(navigationSearch);
    }
}