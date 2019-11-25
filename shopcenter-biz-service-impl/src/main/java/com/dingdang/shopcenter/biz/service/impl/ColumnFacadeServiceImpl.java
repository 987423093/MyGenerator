package com.dingdang.shopcenter.biz.service.impl;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.shop.condition.ColumnSearch;
import com.dingdang.shopcenter.biz.shop.dataobject.Column;
import com.dingdang.shopcenter.biz.shop.domainservice.ColumnDomainService;
import com.dingdang.shopcenter.common.facade.beans.ColumnBean;
import com.dingdang.shopcenter.common.facade.beans.ColumnSearchBean;
import com.dingdang.shopcenter.common.facade.interfaces.ColumnFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Service
public class ColumnFacadeServiceImpl implements ColumnFacadeService {
    private static final Logger logger = LoggerFactory.getLogger(ColumnFacadeServiceImpl.class);
    @Autowired
    private ColumnDomainService columnDomainService;

    /**
     * 新增栏目
     * @param columnBean
     * @return
     */
    @Override
    public ColumnBean addColumn(ColumnBean columnBean) {
        if(columnBean == null){
            logger.error("Fail to addColumn,columnBean is null");
            throw new ServiceException(-1,"新增栏目失败");
        }
        if(StringUtils.isBlank(columnBean.getColumnName())){
            logger.error("Fail to addColumn,ColumnName is null");
            throw new ServiceException(-1,"请填写栏目名称");
        }
        Column column = new Column();
        BeanUtils.copyProperties2(column,columnBean);
        Column returnColumn = columnDomainService.addColumn(column);
        if(returnColumn != null){
            ColumnBean returnColumnBean = new ColumnBean();
            BeanUtils.copyProperties2(returnColumnBean,returnColumn);
            return returnColumnBean;
        }
        return null;
    }

    /**
     * 删除栏目
     * @param columnId
     */
    @Override
    public void deleteColumn(Long columnId) {
        if(columnId == null){
            logger.error("Fail to deleteColumn,columnId is null");
            throw new ServiceException(-1,"删除栏目失败");
        }
        columnDomainService.deleteColumn(columnId);
    }

    /**
     * 修改栏目
     * @param columnBean
     * @return
     */
    @Override
    public ColumnBean modifyColumn(ColumnBean columnBean) {
        if(columnBean == null){
            logger.error("Fail to modifyColumn,columnBean is null");
            throw new ServiceException(-1,"修改栏目失败");
        }
        if(columnBean.getColumnId() == null){
            logger.error("Fail to modifyColumn,columnId is null");
            throw new ServiceException(-1,"columnId 不能为空");
        }
        Column column = new Column();
        BeanUtils.copyProperties2(column,columnBean);
        Column returnColumn = columnDomainService.modifyColumn(column);
        if(returnColumn != null){
            ColumnBean returnColumnBean = new ColumnBean();
            BeanUtils.copyProperties2(returnColumnBean,returnColumn);
            return returnColumnBean;
        }
        return null;
    }

    /**
     * 获取栏目详情
     * @param columnId
     * @return
     */
    @Override
    public ColumnBean getColumnDetail(Long columnId) {
        if(columnId == null){
            return null;
        }
        Column columnDetail = columnDomainService.getColumnDetail(columnId);
        if(columnDetail != null){
            ColumnBean returnColumnBean = new ColumnBean();
            BeanUtils.copyProperties2(returnColumnBean,columnDetail);
            return returnColumnBean;
        }
        return null;
    }

    /**
     * 获取栏目列表
     * @param columnSearchBean
     * @return
     */
    @Override
    public List<ColumnBean> listColumn(ColumnSearchBean columnSearchBean) {
        ColumnSearch columnSearch = new ColumnSearch();
        if(columnSearchBean != null){
            BeanUtils.copyProperties2(columnSearch,columnSearchBean);
        }
        List<Column> columns = columnDomainService.listColumn(columnSearch);
        return BeanUtils.copyList(ColumnBean.class,columns);
    }

    /**
     * 分页获取栏目列表
     * @param columnSearchBean
     * @param pagerListBean
     * @return
     */
    @Override
    public PagerListBean<ColumnBean> listColumnByPage(ColumnSearchBean columnSearchBean, PagerListBean pagerListBean) {
        ColumnSearch columnSearch = new ColumnSearch();
        if(columnSearchBean != null){
            BeanUtils.copyProperties2(columnSearch,columnSearchBean);
        }
        PagerListBean<Column> columnPagerListBean = columnDomainService.listColumnByPage(columnSearch, pagerListBean);
        pagerListBean.setTotal(columnPagerListBean.getTotal());
        pagerListBean.setItems(BeanUtils.copyList(ColumnBean.class,columnPagerListBean.getItems()));
        return pagerListBean;
    }
}
