package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.ColumnSearch;
import com.dingdang.shopcenter.biz.shop.dao.ColumnMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.Column;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnExample;
import com.dingdang.shopcenter.biz.shop.repository.ColumnRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Repository
public class ColumnRepositoryImpl implements ColumnRepository {
    @Autowired
    private ColumnMapper columnMapper;

    /**
     * 新增栏目
     * @param column
     * @return
     */
    @Override
    public Column addColumn(Column column) {
        Assert.notNull(column,"column is not null");
        Assert.notNull(column.getColumnName(),"columnName is not null");

        //默认启用
        if (column.getEnable() == null) {
            column.setEnable(1);
        }
        if (column.getSortNum() == null) {
            column.setSortNum(0);
        }
        Optionals.setDefaultInsert(column);
        return columnMapper.insert(column) > 0 ? column : null;
    }

    /**
     * 删除栏目
     * @param columnId
     * @return
     */
    @Override
    public void deleteColumn(Long columnId) {
        Assert.notNull(columnId,"column is not null");

        Column column = new Column();
        column.setColumnId(columnId);
        column.setModifyDate(new Date());
        column.setState(StateEnum.NOT_USE.getCode());
        columnMapper.updateByPrimaryKeySelective(column);
    }

    /**
     * 修改栏目
     * @param column
     * @return
     */
    @Override
    public Column modifyColumn(Column column) {
        Assert.notNull(column,"column is not null");
        Assert.notNull(column.getColumnId(),"columnId is not null");

        column.setModifyDate(new Date());
        if(columnMapper.updateByPrimaryKeySelective(column) > 0){
            return columnMapper.selectByPrimaryKey(column.getColumnId());
        }
        return null;
    }

    /**
     * 获取栏目详情
     * @param columnId
     * @return
     */
    @Override
    public Column getColumnDetail(Long columnId) {
        Assert.notNull(columnId,"columnId is not null");
        return columnMapper.selectByPrimaryKey(columnId);
    }

    /**
     * 获取栏目列表
     * @param columnSearch
     * @return
     */
    @Override
    public List<Column> listColumn(ColumnSearch columnSearch) {
        ColumnExample example = new ColumnExample();
        this.search(example,columnSearch);
        example.setOrderByClause("SortNum DESC,CreateDate DESC");
        return columnMapper.selectByExample(example);
    }

    /**
     * 分页获取栏目列表
     * @param columnSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Column> listColumnByPage(ColumnSearch columnSearch, PagerListBean pagerListBean) {
        ColumnExample example = new ColumnExample();
        this.search(example,columnSearch);
        example.setOrderByClause("SortNum DESC,CreateDate DESC Limit " + pagerListBean.getOffset() + "," + pagerListBean.getLimit());
        pagerListBean.setTotal((long) columnMapper.countByExample(example));
        pagerListBean.setItems(columnMapper.selectByExample(example));
        return pagerListBean;
    }

    /**
     * 查询条件
     * @param example
     * @param columnSearch
     */
    private void search(ColumnExample example,ColumnSearch columnSearch){
        ColumnExample.Criteria criteria = example.createCriteria().andStateEqualTo(StateEnum.USE.getCode());
        if(columnSearch != null){
            if(columnSearch.getEnable() != null){
                criteria.andEnableEqualTo(columnSearch.getEnable());
            }
            if(columnSearch.getColumnType() != null){
                criteria.andColumnTypeEqualTo(columnSearch.getColumnType());
            }
            if(StringUtils.isNotBlank(columnSearch.getColumnName())){
                criteria.andColumnNameLike("%"+ columnSearch.getColumnName() +"%");
            }
            if(columnSearch.getMallId() != null){
                criteria.andMallIdEqualTo(columnSearch.getMallId());
            }
        }
    }
}
