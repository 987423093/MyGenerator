package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.ColumnGoodsBean;
import com.dingdang.shopcenter.common.facade.beans.ColumnGoodsSearchBean;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
public interface ColumnGoodsFacadeService {
    /**
     * 添加栏目商品关联
     * @param columnGoodsList
     * @return
     */
    void addColumnGood(Long columnId,List<ColumnGoodsBean> columnGoodsList);

    /**
     * 删除栏目商品
     * @param columnId
     * @param goodsId
     */
    void deleteColumnGood(Long columnId,Long goodsId);

    /**
     * 获取栏目商品关联列表
     * @param columnGoodsSearchBean
     * @return
     */
    List<ColumnGoodsBean> listColumnGood(ColumnGoodsSearchBean columnGoodsSearchBean);

    /**
     * 分页获取栏目商品关联列表
     * @param columnGoodsSearchBean
     * @param pagerListBean
     * @return
     */
    PagerListBean<ColumnGoodsBean> listColumnGoodByPage(ColumnGoodsSearchBean columnGoodsSearchBean, PagerListBean pagerListBean);

    /**
     * 保存栏目商品
     * @param columnGoodsBeans
     * @param columnId
     */
    void saveColumnGoods(List<ColumnGoodsBean> columnGoodsBeans, Long columnId);
}
