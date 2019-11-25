package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.MallSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Mall;
import com.dingdang.shopcenter.biz.shop.domainservice.MallDomainService;
import com.dingdang.shopcenter.biz.shop.repository.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Service
public class MallDomainServiceImpl implements MallDomainService {

    @Autowired
    private MallRepository mallRepository;

    /**
     * 增加商城
     * @param mall
     */
    @Override
    public void addMall(Mall mall) {

        mallRepository.addMall(mall);
    }

    /**
     * 修改商城
     * @param mall
     */
    @Override
    public void modifyMall(Mall mall) {

        mallRepository.modifyMall(mall);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public Mall getMallDetail(Long mallId) {

        return mallRepository.getMallDetail(mallId);
    }

    /**
     * 移除商城
     * @param mallId
     */
    @Override
    public void removeMall(Long mallId) {

        mallRepository.removeMall(mallId);
    }

    /**
     * 列出商城
     * @param mallSearch
     * @return
     */
    @Override
    public List<Mall> listMall(MallSearch mallSearch) {

        return mallRepository.listMall(mallSearch);
    }

    /**
     * 分页列出商城
     * @param mallSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Mall> listMallByPage(MallSearch mallSearch, PagerListBean pagerListBean) {

        return mallRepository.listMallByPage(mallSearch, pagerListBean);
    }
}
