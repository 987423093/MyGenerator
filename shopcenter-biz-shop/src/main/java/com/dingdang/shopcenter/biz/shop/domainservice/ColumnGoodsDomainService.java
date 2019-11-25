package com.dingdang.shopcenter.biz.shop.domainservice;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.ColumnGoodsSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoods;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
public interface ColumnGoodsDomainService {
    /**
     * 添加栏目商品关联
     * @param columnGoodsList
     * @return
     */
    void addColumnGood(List<ColumnGoods> columnGoodsList);

    /**
     * 删除栏目商品
     * @param columnId
     * @param goodsId
     */
    void deleteColumnGood(Long columnId,Long goodsId);

    /**
     * 获取栏目商品关联列表
     * @param columnGoodsSearch
     * @return
     */
    List<ColumnGoods> listColumnGood(ColumnGoodsSearch columnGoodsSearch);

    /**
     * 分页获取栏目商品关联列表
     * @param columnGoodsSearch
     * @param pagerListBean
     * @return
     */
    PagerListBean<ColumnGoods> listColumnGoodByPage(ColumnGoodsSearch columnGoodsSearch, PagerListBean pagerListBean);

    /**
     * 批量删除
     * @param deleteGoodsIds
     * @param columnId
     */
    void batchDelete(List<Long> deleteGoodsIds, Long columnId);

    /**
     * 修改
     * @param modifyGoods
     */
    void modifyColumnGoods(ColumnGoods modifyGoods);
}
