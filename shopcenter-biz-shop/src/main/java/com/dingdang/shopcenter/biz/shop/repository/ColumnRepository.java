package com.dingdang.shopcenter.biz.shop.repository;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.ColumnSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Column;

import java.util.List;

/**
 * @author ysh
 * @description 栏目
 * @date 2019/10/11
 */
public interface ColumnRepository {
    /**
     * 新增栏目
     * @param column
     * @return
     */
    Column addColumn(Column column);

    /**
     * 删除栏目
     * @param columnId
     * @return
     */
    void deleteColumn(Long columnId);

    /**
     * 修改栏目
     * @param column
     * @return
     */
    Column modifyColumn(Column column);

    /**
     * 获取栏目详情
     * @param columnId
     * @return
     */
    Column getColumnDetail(Long columnId);

    /**
     * 获取栏目列表
     * @param columnSearch
     * @return
     */
    List<Column> listColumn(ColumnSearch columnSearch);

    /**
     * 分页获取栏目列表
     * @param columnSearch
     * @param pagerListBean
     * @return
     */
    PagerListBean<Column> listColumnByPage(ColumnSearch columnSearch, PagerListBean pagerListBean);
}
