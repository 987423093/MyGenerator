package com.dingdang.shopcenter.biz.shop.repository.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.utils.Assert;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.BannerSearch;
import com.dingdang.shopcenter.biz.shop.dao.BannerMapper;
import com.dingdang.shopcenter.biz.shop.dataobject.Banner;
import com.dingdang.shopcenter.biz.shop.dataobject.BannerExample;
import com.dingdang.shopcenter.biz.shop.repository.BannerRepository;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/30
 */
@Repository
public class BannerRepositoryImpl implements BannerRepository {

    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 增加banner
     * @param banner
     */
    @Override
    public void addBanner(Banner banner) {

        Assert.notNull(banner, "banner must not be null !");
        Assert.notNull(banner.getMallId(), "banner.getMallId() must not be null !");
        Optionals.setDefaultInsert(banner);
        bannerMapper.insert(banner);
    }

    /**
     * 修改banner
     * @param banner
     */
    @Override
    public void modifyBanner(Banner banner) {

        Assert.notNull(banner, "banner must not be null !");
        Assert.notNull(banner.getBannerId(), "banner.getBannerId() must not be null !");
        Optionals.setDefaultModify(banner);
        bannerMapper.updateByPrimaryKeySelective(banner);
    }

    /**
     * 得到banner详情
     * @param bannerId
     * @return
     */
    @Override
    public Banner getBannerDetail(Long bannerId) {

        Assert.notNull(bannerId, "bannerId must not be null !");
        Banner banner = bannerMapper.selectByPrimaryKey(bannerId);
        return (Banner) Optionals.getDefaultDetail(banner);
    }

    /**
     * 移除banner
     * @param bannerId
     */
    @Override
    public void removeBanner(Long bannerId) {

        Assert.notNull(bannerId, "bannerId must not be null !");
        Banner banner = new Banner();
        banner.setBannerId(bannerId);
        banner.setState(StateEnum.NOT_USE.getCode());
        bannerMapper.updateByPrimaryKeySelective(banner);
    }

    /**
     * 列出banner
     * @param bannerSearch
     * @return
     */
    @Override
    public List<Banner> listBanner(BannerSearch bannerSearch) {

        BannerExample bannerExample = new BannerExample();
        this.setCondition(bannerExample, bannerSearch);
        return bannerMapper.selectByExample(bannerExample);
    }

    /**
     * 分页列出banner
     * @param bannerSearch
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<Banner> listBannerByPage(BannerSearch bannerSearch, PagerListBean pagerListBean) {

        BannerExample bannerExample = new BannerExample();
        this.setCondition(bannerExample, bannerSearch);
        Optionals.setDefaultOrderBy(bannerExample, pagerListBean);
        pagerListBean.setTotal((long) bannerMapper.countByExample(bannerExample));
        pagerListBean.setItems(bannerMapper.selectByExample(bannerExample));
        return pagerListBean;
    }

    /**
     * 设置条件
     * @param bannerExample
     * @param bannerSearch
     */
    private void setCondition(BannerExample bannerExample, BannerSearch bannerSearch){

        BannerExample.Criteria criteria = bannerExample.createCriteria();
        if (bannerSearch != null) {
            //banner名称
            if (StringUtils.isNotBlank(bannerSearch.getBannerName())) {
                criteria.andBannerNameLike("%" + bannerSearch.getBannerName() + "%");
            }
            //商城id
            if (bannerSearch.getMallId() != null) {
                criteria.andMallIdEqualTo(bannerSearch.getMallId());
            }
        }
        criteria.andStateEqualTo(StateEnum.USE.getCode());
    }
}
