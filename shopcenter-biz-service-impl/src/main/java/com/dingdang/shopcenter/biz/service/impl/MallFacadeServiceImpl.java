package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.MallSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Mall;
import com.dingdang.shopcenter.biz.shop.domainservice.MallDomainService;
import com.dingdang.shopcenter.common.facade.beans.MallBean;
import com.dingdang.shopcenter.common.facade.beans.MallSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.MallFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoutao
 * @date 2019/10/9
 */
@Service
public class MallFacadeServiceImpl implements MallFacadeService {

    private final transient Logger logger = LoggerFactory.getLogger(MallFacadeServiceImpl.class);

    @Autowired
    private MallDomainService mallDomainService;

    /**
     * 增加商城
     * @param mallBean
     */
    @Override
    public void addMall(MallBean mallBean) {

        if (mallBean == null){
            logger.error("Fail to addMall ! mallBean must not be null !");
            throw new ServiceException(-1, "mallBean 不能为空");
        }
        if (StringUtils.isBlank(mallBean.getMallName())){
            logger.error("Fail to addMall ! mallBean.getMallName() must not be empty !");
            throw new ServiceException(-1, "mallBean.getMallName() 不能为空字符串");
        }
        if (mallBean.getMallType() == null){
            logger.error("Fail to addMall ! mallBean.getMallType() must not be null !");
            throw new ServiceException(-1, "mallBean.getMallType() 不能为空");
        }

        Mall mall = new Mall();
        BeanUtils.copyProperties2(mall, mallBean);
        mallDomainService.addMall(mall);
    }

    /**
     * 修改商城
     * @param mallBean
     */
    @Override
    public void modifyMall(MallBean mallBean) {

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
        mallDomainService.modifyMall(mall);
    }

    /**
     * 得到商城详情
     * @param mallId
     * @return
     */
    @Override
    public MallBean getMallDetail(Long mallId) {

        if (mallId == null){
            logger.error("Fail to getMallDetail ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        Mall mall = mallDomainService.getMallDetail(mallId);
        if (mall != null) {
            MallBean mallBean = new MallBean();
            BeanUtils.copyProperties2(mallBean, mall);
            return mallBean;
        }
        return null;
    }

    /**
     * 移除商城
     * @param mallId
     */
    @Override
    public void removeMall(Long mallId) {

        if (mallId == null){
            logger.error("Fail to removeMall ! mallId must not be null !");
            throw new ServiceException(-1, "mallId 不能为空");
        }
        mallDomainService.removeMall(mallId);
    }

    /**
     * 列出商城
     * @param mallSearchBean
     * @return
     */
    @Override
    public List<MallBean> listMall(MallSearchBean mallSearchBean) {

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
    public PagerListBean<MallBean> listMallByPage(MallSearchBean mallSearchBean, PagerListBean pagerListBean) {

        MallSearch mallSearch = new MallSearch();
        if (mallSearchBean != null) {
            BeanUtils.copyProperties2(mallSearch, mallSearchBean);
        }
        PagerListBean<Mall> list = mallDomainService.listMallByPage(mallSearch, pagerListBean);
        pagerListBean.setItems(BeanUtils.copyList(MallBean.class, list.getItems()));
        pagerListBean.setTotal(list.getTotal());
        return pagerListBean;
    }
}
