package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.shopcenter.biz.shop.condition.MallNavigationSearch;
import com.dingdang.shopcenter.biz.shop.dao.MallNavigationMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigation;
import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigationExample;
import com.dingdang.shopcenter.biz.shop.repository.MallNavigationRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author zhoutao's template
*/
@Repository
public class MallNavigationRepositoryImpl implements MallNavigationRepository {

    @Autowired
    private MallNavigationMapper mallNavigationMapper;

    /**
     * 增加商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    @Override
    public void addMallNavigation(Long mallId,List<Long> navigationIdList){

        Assert.notNull(mallId, "mallId must not be null !");
        if(CollectionUtils.isEmpty(navigationIdList)){
            return;
        }
        ArrayList<MallNavigation> mallNavigations = new ArrayList<>();
        for (Long navigationId : navigationIdList) {
            //存在则不添加
            MallNavigationSearch mallNavigationSearch = new MallNavigationSearch();
            mallNavigationSearch.setMallId(mallId);
            mallNavigationSearch.setNavigationId(navigationId);
            MallNavigation mallNavigationByCondition = getMallNavigationByCondition(mallNavigationSearch);
            if(mallNavigationByCondition != null){
                continue;
            }
            MallNavigation mallNavigation = new MallNavigation();
            mallNavigation.setMallId(mallId);
            mallNavigation.setNavigationId(navigationId);
            Optionals.setDefaultInsert(mallNavigation);
            mallNavigations.add(mallNavigation);
        }
        if(CollectionUtils.isNotEmpty(mallNavigations)){
            mallNavigationMapper.insertBatch(mallNavigations);
        }
    }

    /**
     * 修改商城快捷导航
     * @param mallNavigation
     */
    @Override
    public void modifyMallNavigation(MallNavigation mallNavigation){

        Assert.notNull(mallNavigation, "mallNavigation must not be null !");
        Assert.notNull(mallNavigation.getMallNavigationId(), "mallNavigation.getMallNavigationId() must not be null !");
        Optionals.setDefaultModify(mallNavigation);
        mallNavigationMapper.updateByPrimaryKeySelective(mallNavigation);
    }

    /**
     * 移除商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    @Override
    public void removeMallNavigation(Long mallId,List<Long> navigationIdList){

        Assert.notNull(mallId, "mallId must not be null !");
        if(CollectionUtils.isEmpty(navigationIdList)){
            return;
        }
        MallNavigationExample example = new MallNavigationExample();
        example.createCriteria().andStateEqualTo(StateEnum.USE.getCode())
                .andMallIdEqualTo(mallId)
                .andNavigationIdIn(navigationIdList);
        MallNavigation mallNavigation = new MallNavigation();
        mallNavigation.setState(StateEnum.NOT_USE.getCode());
        mallNavigation.setModifyDate(new Date());

        mallNavigationMapper.updateByExampleSelective(mallNavigation,example);
    }

    /**
     * 得到商城快捷导航详情
     * @param mallNavigationId
     */
    @Override
    public MallNavigation getMallNavigationDetail(Long mallNavigationId){

        Assert.notNull(mallNavigationId, "mallNavigationId must not be null !");
        MallNavigation mallNavigation = mallNavigationMapper.selectByPrimaryKey(mallNavigationId);
        return (MallNavigation) Optionals.getDefaultDetail(mallNavigation);
    }

    /**
     * 列出商城快捷导航
     * @param mallNavigationSearch
     */
    @Override
    public List<MallNavigation> listMallNavigation(MallNavigationSearch mallNavigationSearch){

        MallNavigationExample mallNavigationExample = new MallNavigationExample();
        this.setCondition(mallNavigationExample, mallNavigationSearch);
        return mallNavigationMapper.selectByExample(mallNavigationExample);
    }

    /**
     * 分页列出商城快捷导航
     * @param mallNavigationSearch
     * @param pagerListBean
     */
    @Override
    public PagerListBean<MallNavigation> listMallNavigationByPage(MallNavigationSearch mallNavigationSearch, PagerListBean pagerListBean){

        MallNavigationExample mallNavigationExample = new MallNavigationExample();
        this.setCondition(mallNavigationExample, mallNavigationSearch);
        Optionals.setDefaultOrderBy(mallNavigationExample, pagerListBean);
        pagerListBean.setTotal((long) mallNavigationMapper.countByExample(mallNavigationExample));
        pagerListBean.setItems(mallNavigationMapper.selectByExample(mallNavigationExample));
        return pagerListBean;
    }

    /**
     * 根据条件得到商城快捷导航
     * @param mallNavigationSearch
     */
    @Override
    public MallNavigation getMallNavigationByCondition(MallNavigationSearch mallNavigationSearch){

        MallNavigationExample mallNavigationExample = new MallNavigationExample();
        this.setCondition(mallNavigationExample, mallNavigationSearch);
        List<MallNavigation> mallNavigations = mallNavigationMapper.selectByExample(mallNavigationExample);
        if (CollectionUtils.isNotEmpty(mallNavigations)){
            return mallNavigations.get(0);
        }
        return null;
    }

    /**
     * 设置条件
     * @param mallNavigationExample
     * @param mallNavigationSearch
     */
    private void setCondition(MallNavigationExample mallNavigationExample, MallNavigationSearch mallNavigationSearch){

        MallNavigationExample.Criteria criteria = mallNavigationExample.createCriteria().andStateEqualTo(StateEnum.USE.getCode());
        if (mallNavigationSearch != null) {
            if(mallNavigationSearch.getMallId() != null){
                criteria.andMallIdEqualTo(mallNavigationSearch.getMallId());
            }
            if(mallNavigationSearch.getNavigationId() != null){
                criteria.andNavigationIdEqualTo(mallNavigationSearch.getNavigationId());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}