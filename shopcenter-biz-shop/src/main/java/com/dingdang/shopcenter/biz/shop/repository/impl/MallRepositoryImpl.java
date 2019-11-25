package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.MallSearch;
import com.dingdang.shopcenter.biz.shop.dao.MallMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.Mall;
import com.dingdang.shopcenter.biz.shop.dataobject.MallExample;
import com.dingdang.shopcenter.biz.shop.repository.MallRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Repository
public class MallRepositoryImpl implements MallRepository {

    @Autowired
    private MallMapper mallMapper;

    /**
     * 增加商城
     * @param mall
     */
    @Override
    public void addMall(Mall mall) {

        Assert.notNull(mall, "mall must not be null !");
        Assert.notNull(mall.getMallName(), "mall.getMallName() must not be null !");
        Assert.notNull(mall.getMallType(), "mall.getMallType() must not be null !");
        //默认启用
        mall.setEnableStatus(1);
        Optionals.setDefaultInsert(mall);
        mallMapper.insert(mall);
    }

    /**
     * 修改商城
     * @param mall
     */
    @Override
    public void modifyMall(Mall mall) {

        Assert.notNull(mall, "mall must not be null !");
        Assert.notNull(mall.getMallId(), "mall.getMallId() must not be null !");
        Optionals.setDefaultModify(mall);
        mallMapper.updateByPrimaryKeySelective(mall);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public Mall getMallDetail(Long mallId) {

        Assert.notNull(mallId, "mallId must not be null !");
        Mall mall = mallMapper.selectByPrimaryKey(mallId);
        return (Mall) Optionals.getDefaultDetail(mall);
    }

    /**
     * 移除商城
     * @param mallId
     */
    @Override
    public void removeMall(Long mallId) {

        Assert.notNull(mallId, "mallId must not be null !");
        Mall mall = new Mall();
        mall.setMallId(mallId);
        mall.setState(StateEnum.NOT_USE.getCode());
        mallMapper.updateByPrimaryKeySelective(mall);
    }

    /**
     * 列出商城
     * @param mallSearch
     * @return
     */
    @Override
    public List<Mall> listMall(MallSearch mallSearch) {

        MallExample mallExample = new MallExample();
        this.setCondition(mallExample, mallSearch);
        return mallMapper.selectByExample(mallExample);
    }

    /**
     * 分页列出商城
     * @param mallSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Mall> listMallByPage(MallSearch mallSearch, PagerListBean pagerListBean) {

        MallExample mallExample = new MallExample();
        this.setCondition(mallExample, mallSearch);
        Optionals.setDefaultOrderBy(mallExample, pagerListBean);
        pagerListBean.setTotal((long) mallMapper.countByExample(mallExample));
        pagerListBean.setItems(mallMapper.selectByExample(mallExample));
        return pagerListBean;
    }

    /**
     * 设置条件
     * @param mallExample
     * @param mallSearch
     */
    private void setCondition(MallExample mallExample, MallSearch mallSearch){

        MallExample.Criteria criteria = mallExample.createCriteria();
        if (mallSearch != null) {
            //商城名称
            if (StringUtils.isNotBlank(mallSearch.getMallName())) {
                criteria.andMallNameLike("%" + mallSearch.getMallName() + "%");
            }
            //状态0.未启用 1.启用
            if (mallSearch.getEnableStatus() != null) {
                criteria.andEnableStatusEqualTo(mallSearch.getEnableStatus());
            }
            //商城类型
            if (mallSearch.getMallType() != null) {
                criteria.andMallTypeEqualTo(mallSearch.getMallType());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}
