package com.dingdang.shopcenter.biz.shop.dao;

import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigation;
import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallNavigationMapper {
    int countByExample(MallNavigationExample example);

    int deleteByExample(MallNavigationExample example);

    int deleteByPrimaryKey(Long mallNavigationId);

    int insert(MallNavigation record);

    int insertSelective(MallNavigation record);

    List<MallNavigation> selectByExample(MallNavigationExample example);

    MallNavigation selectByPrimaryKey(Long mallNavigationId);

    int updateByExampleSelective(@Param("record") MallNavigation record, @Param("example") MallNavigationExample example);

    int updateByExample(@Param("record") MallNavigation record, @Param("example") MallNavigationExample example);

    int updateByPrimaryKeySelective(MallNavigation record);

    int updateByPrimaryKey(MallNavigation record);

    List sumByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")MallNavigationExample example);

    List countGroupByExample(@Param("sumFields")List<String> sumFields,@Param("groupByFields")List<String> groupByFields,@Param("example")MallNavigationExample example);

    int insertBatch(@Param("list")List<MallNavigation> list);

    }