package com.dingdang.shopcenter.biz.shop.domainservice.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.biz.shop.condition.ColumnSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Column;
import com.dingdang.shopcenter.biz.shop.domainservice.ColumnDomainService;
import com.dingdang.shopcenter.biz.shop.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Service
public class ColumnDomainServiceImpl implements ColumnDomainService {
    @Autowired
    private ColumnRepository columnRepository;

    /**
     * 新增栏目
     * @param column
     * @return
     */
    @Override
    public Column addColumn(Column column) {
        return columnRepository.addColumn(column);
    }

    /**
     * 删除栏目
     * @param columnId
     */
    @Override
    public void deleteColumn(Long columnId) {
        columnRepository.deleteColumn(columnId);
    }

    /**
     * 修改栏目
     * @param column
     * @return
     */
    @Override
    public Column modifyColumn(Column column) {
        return columnRepository.modifyColumn(column);
    }

    /**
     * 获取栏目详情
     * @param columnId
     * @return
     */
    @Override
    public Column getColumnDetail(Long columnId) {
        return columnRepository.getColumnDetail(columnId);
    }

    /**
     * 获取栏目列表
     * @param columnSearch
     * @return
     */
    @Override
    public List<Column> listColumn(ColumnSearch columnSearch) {
        return columnRepository.listColumn(columnSearch);
    }

    /**
     * 分页获取栏目列表
     * @param columnSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Column> listColumnByPage(ColumnSearch columnSearch, PagerListBean pagerListBean) {
        return columnRepository.listColumnByPage(columnSearch,pagerListBean);
    }
}
