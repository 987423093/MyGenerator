package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.shopcenter.biz.shop.condition.ColumnGoodsSearch;
import com.dingdang.shopcenter.biz.shop.dao.ColumnGoodsMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoods;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoodsExample;
import com.dingdang.shopcenter.biz.shop.repository.ColumnGoodsRepository;
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
public class ColumnGoodsRepositoryImpl implements ColumnGoodsRepository {
    @Autowired
    private ColumnGoodsMapper columnGoodsMapper;

    /**
     * 添加栏目商品关联
     * @param columnGoodsList
     * @return
     */
    @Override
    public void addColumnGood(List<ColumnGoods> columnGoodsList) {
        if(CollectionUtils.isNotEmpty(columnGoodsList)){
            columnGoodsMapper.insertBatch(columnGoodsList);
        }
    }

    /**
     * 删除栏目商品关联
     * @param columnId
     * @param goodsId
     */
    @Override
    public void deleteColumnGood(Long columnId,Long goodsId) {
        Assert.notNull(columnId,"columnId is not null");
        Assert.notNull(goodsId,"goodsId is not null");

        ColumnGoodsExample example = new ColumnGoodsExample();
        example.createCriteria().andStateEqualTo(StateEnum.USE.getCode())
                .andColumnIdEqualTo(columnId)
                .andGoodsIdEqualTo(goodsId);

        ColumnGoods columnGoods = new ColumnGoods();
        columnGoods.setModifyDate(new Date());
        columnGoods.setState(StateEnum.NOT_USE.getCode());

        columnGoodsMapper.updateByExampleSelective(columnGoods,example);
    }

    /**
     * 获取栏目商品关联列表
     * @param columnGoodsSearch
     * @return
     */
    @Override
    public List<ColumnGoods> listColumnGood(ColumnGoodsSearch columnGoodsSearch) {
        ColumnGoodsExample example = new ColumnGoodsExample();
        search(example,columnGoodsSearch);
        return columnGoodsMapper.selectByExample(example);
    }

    /**
     * 分页获取栏目商品关联列表
     * @param columnGoodsSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<ColumnGoods> listColumnGoodByPage(ColumnGoodsSearch columnGoodsSearch, PagerListBean pagerListBean) {
        ColumnGoodsExample example = new ColumnGoodsExample();
        search(example,columnGoodsSearch);
        example.setOrderByClause("SortNum DESC,CreateDate DESC Limit " + pagerListBean.getOffset() + "," + pagerListBean.getLimit());
        pagerListBean.setTotal((long) columnGoodsMapper.countByExample(example));
        pagerListBean.setItems(columnGoodsMapper.selectByExample(example));
        return pagerListBean;
    }

    /**
     * 批量删除
     * @param deleteGoodsIds
     * @param columnId
     */
    @Override
    public void batchDelete(List<Long> deleteGoodsIds, Long columnId) {

        ColumnGoods columnGoods = new ColumnGoods();
        columnGoods.setModifyDate(new Date());
        columnGoods.setState(StateEnum.NOT_USE.getCode());

        ColumnGoodsExample columnGoodsExample = new ColumnGoodsExample();
        ColumnGoodsExample.Criteria criteria = columnGoodsExample.createCriteria();
        criteria.andStateEqualTo(StateEnum.USE.getCode())
                .andColumnIdEqualTo(columnId)
                .andGoodsIdIn(deleteGoodsIds);
        columnGoodsMapper.updateByExampleSelective(columnGoods, columnGoodsExample);
    }

    /**
     * 修改
     * @param modifyGoods
     */
    @Override
    public void modifyColumnGoods(ColumnGoods modifyGoods) {

        Assert.notNull(modifyGoods, "modifyGoods must not be null !");
        Assert.notNull(modifyGoods.getColumnGoodsId(), "modifyGoods.getColumnGoodsId() must not be null !");
        columnGoodsMapper.updateByPrimaryKeySelective(modifyGoods);
    }

    private void search(ColumnGoodsExample example, ColumnGoodsSearch columnGoodsSearch){
        ColumnGoodsExample.Criteria criteria = example.createCriteria().andStateEqualTo(StateEnum.USE.getCode());
        if(columnGoodsSearch != null){
            if(columnGoodsSearch.getGoodsId() != null){
                criteria.andGoodsIdEqualTo(columnGoodsSearch.getGoodsId());
            }
            if(columnGoodsSearch.getColumnId() != null){
                criteria.andColumnIdEqualTo(columnGoodsSearch.getColumnId());
            }
            if(CollectionUtils.isNotEmpty(columnGoodsSearch.getGoodsIdList())){
                criteria.andGoodsIdIn(columnGoodsSearch.getGoodsIdList());
            }
        }
    }
}
