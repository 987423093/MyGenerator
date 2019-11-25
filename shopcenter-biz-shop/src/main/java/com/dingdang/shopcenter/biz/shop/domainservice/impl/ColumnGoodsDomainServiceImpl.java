package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.ColumnGoodsSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoods;
import com.dingdang.shopcenter.biz.shop.domainservice.ColumnGoodsDomainService;
import com.dingdang.shopcenter.biz.shop.repository.ColumnGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Service
public class ColumnGoodsDomainServiceImpl implements ColumnGoodsDomainService {
    @Autowired
    private ColumnGoodsRepository columnGoodsRepository;

    /**
     * 添加栏目商品关联
     * @param columnGoodsList
     * @return
     */
    @Override
    public void addColumnGood(List<ColumnGoods> columnGoodsList) {
        columnGoodsRepository.addColumnGood(columnGoodsList);
    }

    /**
     * 删除栏目商品
     * @param columnId
     * @param goodsId
     */
    @Override
    public void deleteColumnGood(Long columnId, Long goodsId) {
        columnGoodsRepository.deleteColumnGood(columnId,goodsId);
    }

    /**
     * 获取栏目商品关联列表
     * @param columnGoodsSearch
     * @return
     */
    @Override
    public List<ColumnGoods> listColumnGood(ColumnGoodsSearch columnGoodsSearch) {
        return columnGoodsRepository.listColumnGood(columnGoodsSearch);
    }

    /**
     * 分页获取栏目商品关联列表
     * @param columnGoodsSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<ColumnGoods> listColumnGoodByPage(ColumnGoodsSearch columnGoodsSearch, PagerListBean pagerListBean) {
        return columnGoodsRepository.listColumnGoodByPage(columnGoodsSearch,pagerListBean);
    }

    /**
     * 批量删除
     * @param deleteGoodsIds
     * @param columnId
     */
    @Override
    public void batchDelete(List<Long> deleteGoodsIds, Long columnId) {
        columnGoodsRepository.batchDelete(deleteGoodsIds, columnId);
    }

    /**
     * 修改
     * @param modifyGoods
     */
    @Override
    public void modifyColumnGoods(ColumnGoods modifyGoods) {
        columnGoodsRepository.modifyColumnGoods(modifyGoods);
    }
}
