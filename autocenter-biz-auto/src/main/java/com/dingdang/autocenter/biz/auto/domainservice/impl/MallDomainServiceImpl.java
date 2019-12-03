package com.dingdang.autocenter.biz.auto.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.autocenter.biz.auto.condition.MallSearch;
import com.dingdang.autocenter.biz.auto.domainservice.MallDomainService;
import com.dingdang.autocenter.biz.auto.repository.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Service
public class MallDomainServiceImpl implements MallDomainService {

    @Autowired
    private MallRepository mallRepository;

    /**
     * 增加商城
     * @param mall
     * @return
     */
    @Override
    public Mall addMall(Mall mall){

        return mallRepository.addMall(mall);
    }

    /**
     * 修改商城
     * @param mall
     * @return
     */
    @Override
    public Mall modifyMall(Mall mall){

        return mallRepository.modifyMall(mall);
    }

    /**
    * 移除商城
    * @param mallId
    */
    @Override
    public void removeMall(Long mallId){

        mallRepository.removeMall(mallId);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public Mall getMallDetail(Long mallId){

        return mallRepository.getMallDetail(mallId);
    }

    /**
     * 列出商城
     * @param mallSearch
     * @return
     */
    @Override
    public List<Mall> listMall(MallSearch mallSearch){

        return mallRepository.listMall(mallSearch);
    }

    /**
     * 分页列出商城
     * @param mallSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Mall> listMallByPage(MallSearch mallSearch, PagerListBean pagerListBean){

        return mallRepository.listMallByPage(mallSearch, pagerListBean);
    }

    /**
     * 根据条件得到商城
     * @param mallSearch
     * @return
     */
    @Override
    public Mall getMallByCondition(MallSearch mallSearch){

        return mallRepository.getMallByCondition(mallSearch);
    }

    /**
     * 批量添加商城
     * @param malls
     */
    @Override
    public void batchAddMall(List<Mall> malls){

        mallRepository.batchAddMall(malls);
    }
}