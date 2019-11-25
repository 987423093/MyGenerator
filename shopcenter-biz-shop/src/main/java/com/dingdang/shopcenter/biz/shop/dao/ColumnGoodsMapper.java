package com.dingdang.shopcenter.biz.shop.dao;

import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoods;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColumnGoodsMapper {
    int countByExample(ColumnGoodsExample example);

    int deleteByExample(ColumnGoodsExample example);

    int deleteByPrimaryKey(Long columnGoodsId);

    int insert(ColumnGoods record);

    int insertSelective(ColumnGoods record);

    List<ColumnGoods> selectByExample(ColumnGoodsExample example);

    ColumnGoods selectByPrimaryKey(Long columnGoodsId);

    int updateByExampleSelective(@Param("record") ColumnGoods record, @Param("example") ColumnGoodsExample example);

    int updateByExample(@Param("record") ColumnGoods record, @Param("example") ColumnGoodsExample example);

    int updateByPrimaryKeySelective(ColumnGoods record);

    int updateByPrimaryKey(ColumnGoods record);

    List sumByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")ColumnGoodsExample example);

    List countGroupByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")ColumnGoodsExample example);

    int insertBatch(@Param("list")List<ColumnGoods> list);

    }