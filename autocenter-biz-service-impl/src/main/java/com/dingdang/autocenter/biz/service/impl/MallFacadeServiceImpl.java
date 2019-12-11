package com.dingdang.autocenter.biz.service.impl;

import com.dingdang.autocenter.biz.auto.dataobject.Mall;
import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.autocenter.biz.auto.condition.MallSearch;
import com.dingdang.autocenter.biz.auto.domainservice.MallDomainService;
import com.dingdang.autocenter.common.facade.beans.MallBean;
import com.dingdang.autocenter.common.facade.beans.MallSearchBean;
import com.dingdang.autocenter.common.facade.interfaces.MallFacadeService;
import com.dingdang.autocenter.common.utils.Optionals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Service
public class MallFacadeServiceImpl implements MallFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(MallFacadeServiceImpl.class);

    @Autowired
    private MallDomainService mallDomainService;

    /**
     * 增加商城
     * @param mallBean
     * @return
     */
    @Override
    public MallBean addMall(MallBean mallBean){

        if (mallBean == null){
            logger.error("Fail to addMall ! mallBean must not be null !");
            throw new ServiceException(-1, "mallBean 不能为空");
        }
        if (StringUtils.isBlank(mallBean.getMallName())){
            logger.error("Fail to addMall ! mallName must not be empty !");
            throw new ServiceException(-1, "商城名称 不能为空字符串");
        }
        Mall mall = new Mall();
        BeanUtils.copyProperties2(mall, mallBean);
        return Optionals.transformBean(mallDomainService.addMall(mall), MallBean.class);
    }

    /**
     * 修改商城
     * @param mallBean
     * @return
     */
    @Override
    public MallBean modifyMall(MallBean mallBean){

        if (mallBean == null){
             logger.error("Fail to modifyMall ! mallBean must not be null !");
             throw new ServiceException(-1, "mallBean 不能为空");
        }
        if (mallBean.getMallId() == null){
            logger.error("Fail to modifyMall ! mallBean.getMallId() must not be null !");
            throw new ServiceException(-1, "mallBean.getMallId() 不能为空");
        }
        Mall mall = new Mall();
        BeanUtils.copyProperties2(mall, mallBean);
        return Optionals.transformBean(mallDomainService.modifyMall(mall), MallBean.class);
    }

    /**
     * 移除商城
     * @param mallId
     */
    @Override
    public void removeMall(Long mallId){

        if (mallId == null){
            logger.error("Fail to getMallDetail ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        mallDomainService.removeMall(mallId);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public MallBean getMallDetail(Long mallId){

        if (mallId == null){
            logger.error("Fail to getMallDetail ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        return Optionals.transformBean(mallDomainService.getMallDetail(mallId), MallBean.class);
    }

    /**
     * 列出商城
     * @param mallSearchBean
     * @return
     */
    @Override
    public List<MallBean> listMall(MallSearchBean mallSearchBean){

        MallSearch mallSearch = new MallSearch();
        if (mallSearchBean != null) {
            BeanUtils.copyProperties2(mallSearch, mallSearchBean);
        }
        return BeanUtils.copyList(MallBean.class, mallDomainService.listMall(mallSearch));
    }

    /**
     * 分页列出商城
     * @param mallSearchBean
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<MallBean> listMallByPage(MallSearchBean mallSearchBean, PagerListBean pagerListBean){

        MallSearch mallSearch = new MallSearch();
        if (mallSearchBean != null) {
            BeanUtils.copyProperties2(mallSearch, mallSearchBean);
        }
        PagerListBean<Mall> list = mallDomainService.listMallByPage(mallSearch, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(MallBean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }

    /**
     * 根据条件得到商城
     * @param mallSearchBean
     * @return
     */
    @Override
    public MallBean getMallByCondition(MallSearchBean mallSearchBean){

        MallSearch mallSearch = new MallSearch();
        if (mallSearchBean != null) {
            BeanUtils.copyProperties2(mallSearch, mallSearchBean);
        }
        return Optionals.transformBean(mallDomainService.getMallByCondition(mallSearch), MallBean.class);
    }

    /**
     * 批量添加商城
     * @param mallBeans
     */
    @Override
    public void batchAddMall(List<MallBean> mallBeans){

        if (CollectionUtils.isEmpty(mallBeans)){
            logger.error("Fail to batchAddMall ! mallBeans must not be null !");
            throw new ServiceException(-1, "mallBeans 不能为空");
        }
        for (MallBean mallBean : mallBeans){
            if (mallBean.getMallName() == null){
            logger.error("Fail to batAddMall ! batch mallName must not be null or empty!");
                throw new ServiceException(-1, "商城名称 不能为空");
            }
        }
        mallDomainService.batchAddMall(BeanUtils.copyList(Mall.class, mallBeans));
    }
}