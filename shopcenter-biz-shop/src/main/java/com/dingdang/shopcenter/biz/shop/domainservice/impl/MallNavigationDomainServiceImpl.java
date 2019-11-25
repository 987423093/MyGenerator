package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.MallNavigationSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigation;
import com.dingdang.shopcenter.biz.shop.domainservice.MallNavigationDomainService;
import com.dingdang.shopcenter.biz.shop.repository.MallNavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhoutao's template
*/
@Service
public class MallNavigationDomainServiceImpl implements MallNavigationDomainService {

    @Autowired
    private MallNavigationRepository mallNavigationRepository;

    /**
     * 增加商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    @Override
    public void addMallNavigation(Long mallId,List<Long> navigationIdList){

        mallNavigationRepository.addMallNavigation(mallId,navigationIdList);
    }

    /**
     * 修改商城快捷导航
     * @param mallNavigation
     */
    @Override
    public void modifyMallNavigation(MallNavigation mallNavigation){

        mallNavigationRepository.modifyMallNavigation(mallNavigation);
    }

    /**
     * 移除商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    @Override
    public void removeMallNavigation(Long mallId,List<Long> navigationIdList){

        mallNavigationRepository.removeMallNavigation(mallId,navigationIdList);
    }

    /**
     * 得到商城快捷导航详情
     * @param mallNavigationId
     */
    @Override
    public MallNavigation getMallNavigationDetail(Long mallNavigationId){

        return mallNavigationRepository.getMallNavigationDetail(mallNavigationId);
    }

    /**
     * 列出商城快捷导航
     * @param mallNavigationSearch
     */
    @Override
    public List<MallNavigation> listMallNavigation(MallNavigationSearch mallNavigationSearch){

        return mallNavigationRepository.listMallNavigation(mallNavigationSearch);
    }

    /**
     * 分页列出商城快捷导航
     * @param mallNavigationSearch
     * @param pagerListBean
     */
    @Override
    public PagerListBean<MallNavigation> listMallNavigationByPage(MallNavigationSearch mallNavigationSearch, PagerListBean pagerListBean){

        return mallNavigationRepository.listMallNavigationByPage(mallNavigationSearch, pagerListBean);
    }

    /**
     * 根据条件得到商城快捷导航
     * @param mallNavigationSearch
     */
    @Override
    public MallNavigation getMallNavigationByCondition(MallNavigationSearch mallNavigationSearch){

        return mallNavigationRepository.getMallNavigationByCondition(mallNavigationSearch);
    }
}