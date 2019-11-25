package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.shopcenter.biz.shop.condition.MallNavigationSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.MallNavigation;
import com.dingdang.shopcenter.biz.shop.domainservice.MallNavigationDomainService;
import com.dingdang.shopcenter.common.facade.beans.MallNavigationBean;
import com.dingdang.shopcenter.common.facade.beans.MallNavigationSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.MallNavigationFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhoutao's template
*/
@Service
public class MallNavigationFacadeServiceImpl implements MallNavigationFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(MallNavigationFacadeServiceImpl.class);

    @Autowired
    private MallNavigationDomainService mallNavigationDomainService;

    /**
     * 增加商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    @Override
    public void addMallNavigation(Long mallId,List<Long> navigationIdList){

        if (mallId == null){
            logger.error("Fail to addMallNavigation ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        if(CollectionUtils.isEmpty(navigationIdList)){
            logger.error("Fail to addMallNavigation ! navigationIdList must not be null !");
            throw new ServiceException(-1, "请至少选择一个导航");
        }

        mallNavigationDomainService.addMallNavigation(mallId,navigationIdList);
    }

    /**
     * 修改商城快捷导航
     * @param mallNavigationBean
     */
    @Override
    public void modifyMallNavigation(MallNavigationBean mallNavigationBean){

        if (mallNavigationBean == null){
             logger.error("Fail to modifyMallNavigation ! mallNavigationBean must not be null !");
             throw new ServiceException(-1, "mallNavigationBean 不能为空");
        }
        if (mallNavigationBean.getMallNavigationId() == null){
            logger.error("Fail to modifyMallNavigation ! mallNavigationBean.getMallNavigationId() must not be null !");
            throw new ServiceException(-1, "mallNavigationBean.getMallNavigationId() 不能为空");
        }

        MallNavigation mallNavigation = new MallNavigation();
        BeanUtils.copyProperties2(mallNavigation, mallNavigationBean);
        mallNavigationDomainService.modifyMallNavigation(mallNavigation);
    }

    /**
     * 移除商城快捷导航
     * @param mallId
     * @param navigationIdList
     */
    @Override
    public void removeMallNavigation(Long mallId,List<Long> navigationIdList){

        mallNavigationDomainService.removeMallNavigation(mallId,navigationIdList);
    }

    /**
     * 得到商城快捷导航详情
     * @param mallNavigationId
     */
    @Override
    public MallNavigationBean getMallNavigationDetail(Long mallNavigationId){

        if (mallNavigationId == null){
            logger.error("Fail to getMallNavigationDetail ! mallNavigationId must not be null !");
            throw new ServiceException(-1, "mallNavigationId 不能为空");
        }

        MallNavigation mallNavigation = mallNavigationDomainService.getMallNavigationDetail(mallNavigationId);
        if (mallNavigation != null) {
            MallNavigationBean mallNavigationBean = new MallNavigationBean();
            BeanUtils.copyProperties2(mallNavigationBean, mallNavigation);
            return mallNavigationBean;
        }
        return null;
    }

    /**
     * 列出商城快捷导航
     * @param mallNavigationSearchBean
     */
    @Override
    public List<MallNavigationBean> listMallNavigation(MallNavigationSearchBean mallNavigationSearchBean){

        MallNavigationSearch mallNavigationSearch = new MallNavigationSearch();
        if (mallNavigationSearchBean != null) {
            BeanUtils.copyProperties2(mallNavigationSearch, mallNavigationSearchBean);
        }
        return BeanUtils.copyList(MallNavigationBean.class, mallNavigationDomainService.listMallNavigation(mallNavigationSearch));
    }

    /**
     * 根据条件得到商城快捷导航
     * @param mallNavigationSearchBean
     */
    @Override
    public MallNavigationBean getMallNavigationByCondition(MallNavigationSearchBean mallNavigationSearchBean){

        MallNavigationSearch mallNavigationSearch = new MallNavigationSearch();
        if (mallNavigationSearchBean != null) {
            BeanUtils.copyProperties2(mallNavigationSearch, mallNavigationSearchBean);
        }
        MallNavigation mallNavigation = mallNavigationDomainService.getMallNavigationByCondition(mallNavigationSearch);
        if (mallNavigation != null){
            MallNavigationBean mallNavigationBean = new MallNavigationBean();
            BeanUtils.copyProperties2(mallNavigationBean, mallNavigation);
            return mallNavigationBean;
        }
        return null;
    }
}