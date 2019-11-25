package com.dingdang.shopcenter.biz.shop.dao;

import com.dingdang.shopcenter.biz.shop.dataobject.Mall;
import com.dingdang.shopcenter.biz.shop.dataobject.MallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMapper {
    int countByExample(MallExample example);

    int deleteByExample(MallExample example);

    int deleteByPrimaryKey(Long mallId);

    int insert(Mall record);

    int insertSelective(Mall record);

    List<Mall> selectByExample(MallExample example);

    Mall selectByPrimaryKey(Long mallId);

    int updateByExampleSelective(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByExample(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByPrimaryKeySelective(Mall record);

    int updateByPrimaryKey(Mall record);

    List sumByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")MallExample example);

    List countGroupByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")MallExample example);

    int insertBatch(@Param("list")List<Mall> list);

    }