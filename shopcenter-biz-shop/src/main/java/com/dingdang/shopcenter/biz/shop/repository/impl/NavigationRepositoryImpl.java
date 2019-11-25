package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.NavigationSearch;
import com.dingdang.shopcenter.biz.shop.dao.NavigationMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.Navigation;
import com.dingdang.shopcenter.biz.shop.dataobject.NavigationExample;
import com.dingdang.shopcenter.biz.shop.repository.NavigationRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Repository
public class NavigationRepositoryImpl implements NavigationRepository {

    @Autowired
    private NavigationMapper navigationMapper;

    /**
     * 增加快捷导航
     * @param navigation
     */
    @Override
    public void addNavigation(Navigation navigation){

        Assert.notNull(navigation, "navigation must not be null !");
        Assert.notNull(navigation.getNavigationName(), "navigationName must not be null !");
        //默认启用
        navigation.setNavigationStatus(1);
        Optionals.setDefaultInsert(navigation);
        navigationMapper.insert(navigation);
    }

    /**
     * 修改快捷导航
     * @param navigation
     */
    @Override
    public void modifyNavigation(Navigation navigation){

        Assert.notNull(navigation, "navigation must not be null !");
        Assert.notNull(navigation.getNavigationId(), "navigation.getNavigationId() must not be null !");
        Optionals.setDefaultModify(navigation);
        navigationMapper.updateByPrimaryKeySelective(navigation);
    }

    /**
    * 移除快捷导航
    * @param navigationId
    */
    @Override
    public void removeNavigation(Long navigationId){

        Assert.notNull(navigationId, "navigationId must not be null !");
        Navigation navigation = new Navigation();
        navigation.setNavigationId(navigationId);
        navigation.setState(StateEnum.NOT_USE.getCode());
        navigationMapper.updateByPrimaryKeySelective(navigation);
    }

    /**
     * 得到快捷导航详情
     * @param navigationId
     */
    @Override
    public Navigation getNavigationDetail(Long navigationId){

        Assert.notNull(navigationId, "navigationId must not be null !");
        Navigation navigation = navigationMapper.selectByPrimaryKey(navigationId);
        return (Navigation) Optionals.getDefaultDetail(navigation);
    }

    /**
     * 列出快捷导航
     * @param navigationSearch
     */
    @Override
    public List<Navigation> listNavigation(NavigationSearch navigationSearch){

        NavigationExample navigationExample = new NavigationExample();
        navigationExample.setOrderByClause("navigationSort DESC,CreateDate DESC");
        this.setCondition(navigationExample, navigationSearch);
        return navigationMapper.selectByExample(navigationExample);
    }

    /**
     * 分页列出快捷导航
     * @param navigationSearch
     * @param pagerListBean
     */
    @Override
    public PagerListBean<Navigation> listNavigationByPage(NavigationSearch navigationSearch, PagerListBean pagerListBean){

        NavigationExample example = new NavigationExample();
        this.setCondition(example, navigationSearch);
        example.setOrderByClause("navigationSort DESC,CreateDate DESC Limit " + pagerListBean.getOffset() + "," + pagerListBean.getLimit());
        pagerListBean.setTotal((long) navigationMapper.countByExample(example));
        pagerListBean.setItems(navigationMapper.selectByExample(example));
        return pagerListBean;
    }

    /**
     * 根据条件得到快捷导航
     * @param navigationSearch
     */
    @Override
    public Navigation getNavigationByCondition(NavigationSearch navigationSearch){

        NavigationExample navigationExample = new NavigationExample();
        this.setCondition(navigationExample, navigationSearch);
        List<Navigation> navigations = navigationMapper.selectByExample(navigationExample);
        if (CollectionUtils.isNotEmpty(navigations)){
            return navigations.get(0);
        }
        return null;
    }

    /**
     * 设置条件
     * @param example
     * @param navigationSearch
     */
    private void setCondition(NavigationExample example, NavigationSearch navigationSearch){

        NavigationExample.Criteria criteria = example.createCriteria().andStateEqualTo(StateEnum.USE.getCode());
        if (navigationSearch != null) {
            if(navigationSearch.getNavigationStatus() != null){
                criteria.andNavigationStatusEqualTo(navigationSearch.getNavigationStatus());
            }
            if(StringUtils.isNotBlank(navigationSearch.getNavigationName())){
                criteria.andNavigationNameLike("%"+ navigationSearch.getNavigationName() +"%");
            }
            if(CollectionUtils.isNotEmpty(navigationSearch.getNavigationIdList())){
                criteria.andNavigationIdIn(navigationSearch.getNavigationIdList());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}