package com.dingdang.shopcenter.biz.shop.dao;

import com.dingdang.shopcenter.biz.shop.dataobject.Navigation;
import com.dingdang.shopcenter.biz.shop.dataobject.NavigationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavigationMapper {
    int countByExample(NavigationExample example);

    int deleteByExample(NavigationExample example);

    int deleteByPrimaryKey(Long navigationId);

    int insert(Navigation record);

    int insertSelective(Navigation record);

    List<Navigation> selectByExample(NavigationExample example);

    Navigation selectByPrimaryKey(Long navigationId);

    int updateByExampleSelective(@Param("record") Navigation record, @Param("example") NavigationExample example);

    int updateByExample(@Param("record") Navigation record, @Param("example") NavigationExample example);

    int updateByPrimaryKeySelective(Navigation record);

    int updateByPrimaryKey(Navigation record);

    List sumByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")NavigationExample example);

    List countGroupByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")NavigationExample example);

    int insertBatch(@Param("list")List<Navigation> list);

    }