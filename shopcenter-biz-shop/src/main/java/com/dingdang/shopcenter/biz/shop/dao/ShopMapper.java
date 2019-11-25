package com.dingdang.shopcenter.biz.shop.dao;

import com.dingdang.shopcenter.biz.shop.dataobject.Shop;
import com.dingdang.shopcenter.biz.shop.dataobject.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    int countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(Long shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(Long shopId);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List sumByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")ShopExample example);

    List countGroupByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")ShopExample example);

    int insertBatch(@Param("list")List<Shop> list);

    }