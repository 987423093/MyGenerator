package com.dingdang.shopcenter.common.facade.interfaces;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.shopcenter.common.facade.beans.ColumnBean;
import com.dingdang.shopcenter.common.facade.beans.ColumnSearchBean;

import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
public interface ColumnFacadeService {
    /**
     * 新增栏目
     * @param columnBean
     * @return
     */
    ColumnBean addColumn(ColumnBean columnBean);

    /**
     * 删除栏目
     * @param columnId
     * @return
     */
    void deleteColumn(Long columnId);

    /**
     * 修改栏目
     * @param columnBean
     * @return
     */
    ColumnBean modifyColumn(ColumnBean columnBean);

    /**
     * 获取栏目详情
     * @param columnId
     * @return
     */
    ColumnBean getColumnDetail(Long columnId);

    /**
     * 获取栏目列表
     * @param columnSearchBean
     * @return
     */
    List<ColumnBean> listColumn(ColumnSearchBean columnSearchBean);

    /**
     * 分页获取栏目列表
     * @param columnSearchBean
     * @param pagerListBean
     * @return
     */
    PagerListBean<ColumnBean> listColumnByPage(ColumnSearchBean columnSearchBean, PagerListBean pagerListBean);
}
