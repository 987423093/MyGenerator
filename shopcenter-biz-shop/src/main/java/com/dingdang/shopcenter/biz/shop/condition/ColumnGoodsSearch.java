package com.dingdang.shopcenter.biz.shop.condition;

import lombok.Data;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Data
public class ColumnGoodsSearch {
    /**
     * 栏目ID
     */
    private Long columnId;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 商品ID集合
     */
    private List<Long> goodsIdList;
}
