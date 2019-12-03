package com.dingdang.autocenter.biz.auto.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.autocenter.biz.auto.condition.MallSearch;
import com.dingdang.autocenter.biz.auto.dao.MallMapper;
import com.dingdang.autocenter.biz.auto.repository.MallRepository;
import com.dingdang.autocenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Repository
public class MallRepositoryImpl implements MallRepository {

    @Autowired
    private MallMapper mallMapper;

    /**
     * 增加商城
     * @param mall
     * @return
     */
    @Override
    public Mall addMall(Mall mall){

        Assert.notNull(mall, "mall must not be null !");
        Assert.notNull(mall.getMallName(), "mallName must not be null !");
        Optionals.setDefaultInsert(mall);
        mallMapper.insert(mall);
        return mall;
    }

    /**
     * 修改商城
     * @param mall
     * @return
     */
    @Override
    public Mall modifyMall(Mall mall){

        Assert.notNull(mall, "mall must not be null !");
        Assert.notNull(mall.getMallId(), "mall.getMallId() must not be null !");
        Optionals.setDefaultModify(mall);
        mallMapper.updateByPrimaryKeySelective(mall);
        return mall;
    }

    /**
     * 移除商城
     * @param mallId
     */
    @Override
    public void removeMall(Long mallId){

        Assert.notNull(mallId, "mallId must not be null !");
        Mall mall = new Mall();
        mall.setMallId(mallId);
        mall.setState(StateEnum.NOT_USE.getCode());
        mallMapper.updateByPrimaryKeySelective(mall);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public Mall getMallDetail(Long mallId){

        Assert.notNull(mallId, "mallId must not be null !");
        Mall mall = mallMapper.selectByPrimaryKey(mallId);
        return (Mall) Optionals.getDefaultDetail(mall);
    }

    /**
     * 列出商城
     * @param mallSearch
     * @return
     */
    @Override
    public List<Mall> listMall(MallSearch mallSearch){

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
    public PagerListBean<Mall> listMallByPage(MallSearch mallSearch, PagerListBean pagerListBean){

        MallExample mallExample = new MallExample();
        this.setCondition(mallExample, mallSearch);
        Optionals.setDefaultOrderBy(mallExample, pagerListBean);
        pagerListBean.setTotal((long) mallMapper.countByExample(mallExample));
        pagerListBean.setItems(mallMapper.selectByExample(mallExample));
        return pagerListBean;
    }

    /**
     * 根据条件得到商城
     * @param mallSearch
     * @return
     */
    @Override
    public Mall getMallByCondition(MallSearch mallSearch){

        MallExample mallExample = new MallExample();
        this.setCondition(mallExample, mallSearch);
        List<Mall> malls = mallMapper.selectByExample(mallExample);
        if (CollectionUtils.isNotEmpty(malls)){
            return malls.get(0);
        }
        return null;
    }

    /**
     * 批量添加商城
     * @param malls
     */
    @Override
    public void batchAddMall(List<Mall> malls){

        for (Mall mall : malls){
            Assert.notNull(mall.getMallName(), "batch mallName must not be null !");
            Optionals.setDefaultInsert(mall);
        }
        mallMapper.insertBatch(malls);
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
            if (StringUtils.isNotBlank(mallSearch.getMallName())){
                criteria.andMallNameEqualTo(mallSearch.getMallName());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}