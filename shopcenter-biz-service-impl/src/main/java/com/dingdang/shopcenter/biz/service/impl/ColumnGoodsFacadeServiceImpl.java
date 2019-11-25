package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.shopcenter.biz.shop.condition.ColumnGoodsSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.ColumnGoods;
import com.dingdang.shopcenter.biz.shop.domainservice.ColumnGoodsDomainService;
import com.dingdang.shopcenter.common.facade.beans.ColumnGoodsBean;
import com.dingdang.shopcenter.common.facade.beans.ColumnGoodsSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.ColumnGoodsFacadeService;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Service
public class ColumnGoodsFacadeServiceImpl implements ColumnGoodsFacadeService {
    private static final Logger logger = LoggerFactory.getLogger(ColumnGoodsFacadeServiceImpl.class);
    @Autowired
    private ColumnGoodsDomainService columnGoodsDomainService;

    /**
     * 添加栏目商品关联
     * @param columnGoodsList
     * @return
     */
    @Override
    public void addColumnGood(Long columnId,List<ColumnGoodsBean> columnGoodsList) {
        if(columnId == null){
            logger.error("Fail to addColumnGood,columnId is null");
            throw new ServiceException(-1,"columnId 不能为空");
        }
        ArrayList<ColumnGoodsBean> columnGoodsBeans = new ArrayList<>();
        for (ColumnGoodsBean columnGoodsBean : columnGoodsList) {
            if(columnGoodsBean.getGoodsId() == null){
                logger.error("Fail to addColumnGood,goodsId is null");
                throw new ServiceException(-1,"goodsId 不能为空");
            }
            //已存在关联则不添加
            ColumnGoodsSearch columnGoodsSearch = new ColumnGoodsSearch();
            columnGoodsSearch.setGoodsId(columnGoodsBean.getGoodsId());
            columnGoodsSearch.setColumnId(columnId);
            List<ColumnGoods> columnGoods = columnGoodsDomainService.listColumnGood(columnGoodsSearch);
            if(CollectionUtils.isNotEmpty(columnGoods)){
                continue;
            }

            columnGoodsBean.setColumnId(columnId);
            Optionals.setDefaultInsert(columnGoodsBean);
            columnGoodsBeans.add(columnGoodsBean);
        }
        if(CollectionUtils.isNotEmpty(columnGoodsBeans)){
            columnGoodsDomainService.addColumnGood(BeanUtils.copyList(ColumnGoods.class,columnGoodsBeans));
        }
    }

    /**
     * 删除栏目商品
     * @param columnId
     * @param goodsId
     */
    @Override
    public void deleteColumnGood(Long columnId, Long goodsId) {
        if(columnId == null){
            logger.error("Fail to deleteColumnGood,columnId is null");
            throw new ServiceException(-1,"columnId 不能为空");
        }
        if(goodsId == null){
            logger.error("Fail to deleteColumnGood,goodsId is null");
            throw new ServiceException(-1,"goodsId 不能为空");
        }
        columnGoodsDomainService.deleteColumnGood(columnId,goodsId);
    }

    /**
     * 获取栏目商品关联列表
     * @param columnGoodsSearchBean
     * @return
     */
    @Override
    public List<ColumnGoodsBean> listColumnGood(ColumnGoodsSearchBean columnGoodsSearchBean) {
        ColumnGoodsSearch columnGoodsSearch = new ColumnGoodsSearch();
        if (columnGoodsSearchBean != null){
            BeanUtils.copyProperties2(columnGoodsSearch,columnGoodsSearchBean);
        }
        List<ColumnGoods> columnGoods = columnGoodsDomainService.listColumnGood(columnGoodsSearch);
        return BeanUtils.copyList(ColumnGoodsBean.class,columnGoods);
    }

    /**
     * 分页获取栏目商品关联列表
     * @param columnGoodsSearchBean
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<ColumnGoodsBean> listColumnGoodByPage(ColumnGoodsSearchBean columnGoodsSearchBean, PagerListBean pagerListBean) {
        ColumnGoodsSearch columnGoodsSearch = new ColumnGoodsSearch();
        if (columnGoodsSearchBean != null){
            BeanUtils.copyProperties2(columnGoodsSearch,columnGoodsSearchBean);
        }
        PagerListBean<ColumnGoods> columnGoodsPagerListBean = columnGoodsDomainService.listColumnGoodByPage(columnGoodsSearch, pagerListBean);
        pagerListBean.setTotal(columnGoodsPagerListBean.getTotal());
        pagerListBean.setItems(BeanUtils.copyList(ColumnGoodsBean.class,columnGoodsPagerListBean.getItems()));
        return pagerListBean;
    }

    /**
     * 保存栏目商品
     * @param columnGoodsBeans
     * @param columnId
     */
    @Override
    public void saveColumnGoods(List<ColumnGoodsBean> columnGoodsBeans, Long columnId) {

        if (columnGoodsBeans == null){
            logger.error("Fail to saveColumnGoods ! columnGoodsBeans must not be null !");
            throw new ServiceException(-1, "columnGoodsBeans 不能为空");
        }
        if (columnId == null){
            logger.error("Fail to saveColumnGoods ! columnId must not be null !");
            throw new ServiceException(-1, "columnId 不能为空");
        }

        ColumnGoodsSearch oldSearch = new ColumnGoodsSearch();
        oldSearch.setColumnId(columnId);
        List<ColumnGoods> oldColumnGoods = columnGoodsDomainService.listColumnGood(oldSearch);
        List<Long> oldGoodsIds = CollectionUtils.extractDuplicateProps(oldColumnGoods, "goodsId");
        List<Long> newGoodsIds = CollectionUtils.extractDuplicateProps(columnGoodsBeans, "goodsId");

        //删除部分
        List<Long> deleteGoodsIds = (List<Long>) CollectionUtils.subtract(oldGoodsIds, newGoodsIds);
        if (CollectionUtils.isNotEmpty(deleteGoodsIds)) {
            columnGoodsDomainService.batchDelete(deleteGoodsIds, columnId);
        }

        //添加部分
        List<Long> addGoodsIds = (List<Long>) CollectionUtils.subtract(newGoodsIds, oldGoodsIds);
        List<ColumnGoods> columnGoods = new ArrayList<>();
        Map<Long, ColumnGoodsBean> newAddMap = CollectionUtils.extractConllectionToMap(columnGoodsBeans, "goodsId");
        for (Long goodsId : addGoodsIds) {

            ColumnGoods subColumnGoods = new ColumnGoods();
            subColumnGoods.setColumnId(columnId);
            subColumnGoods.setGoodsId(goodsId);
            subColumnGoods.setSortNum(newAddMap.get(goodsId).getSortNum());
            Optionals.setDefaultInsert(subColumnGoods);
            columnGoods.add(subColumnGoods);
        }

        //修改部分
        List<Long> modifyGoodsIds = (List<Long>) CollectionUtils.retainAll(newGoodsIds, oldGoodsIds);
        if (CollectionUtils.isNotEmpty(modifyGoodsIds)){

            Map<Long, ColumnGoods> oldMap = CollectionUtils.extractConllectionToMap(oldColumnGoods, "goodsId");
            Map<Long, ColumnGoods> newMap = CollectionUtils.extractConllectionToMap(BeanUtils.copyList(ColumnGoods.class, columnGoodsBeans), "goodsId");
            for (Long modifyGoodsId : modifyGoodsIds) {
                ColumnGoods oldGoods = oldMap.get(modifyGoodsId);
                ColumnGoods newGoods = newMap.get(modifyGoodsId);
                if (oldGoods != null && newGoods != null && !Objects.equals(oldGoods.getSortNum(), newGoods.getSortNum())){
                    ColumnGoods modifyGoods = new ColumnGoods();
                    modifyGoods.setSortNum(newGoods.getSortNum());
                    modifyGoods.setColumnGoodsId(oldGoods.getColumnGoodsId());
                    columnGoodsDomainService.modifyColumnGoods(modifyGoods);
                }
            }
        }

        if (CollectionUtils.isNotEmpty(columnGoods)){
            columnGoodsDomainService.addColumnGood(columnGoods);
        }
    }
}
