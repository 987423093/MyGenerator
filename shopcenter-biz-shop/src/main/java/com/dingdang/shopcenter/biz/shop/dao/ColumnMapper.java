package com.dingdang.shopcenter.biz.shop.dao;

import com.dingdang.shopcenter.biz.shop.dataobject.Column;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColumnMapper {
    int countByExample(ColumnExample example);

    int deleteByExample(ColumnExample example);

    int deleteByPrimaryKey(Long columnId);

    int insert(Column record);

    int insertSelective(Column record);

    List<Column> selectByExample(ColumnExample example);

    Column selectByPrimaryKey(Long columnId);

    int updateByExampleSelective(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByExample(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);

    List sumByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")ColumnExample example);

    List countGroupByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")ColumnExample example);

    int insertBatch(@Param("list")List<Column> list);

    }