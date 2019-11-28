package com.dingdang.shopcenter.biz.share.autogenerator.auto;

import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.domain.MyObject;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
public interface IAutoConditions {

    /**
     * 添加模糊条件
     * @param myObject 模糊条件
     */
    void addLikeCondition(MyObject myObject);

    /**
     * 添加时间范围条件
     * @param myObject 时间条件
     */
    void addDateBetweenCondition(MyObject myObject);

    /**
     * 添加查询条件
     * @param myObject 查询条件
     */
    void addSearchCondition(MyObject myObject);

    /**
     * 添加必填条件
     * @param myObject 必填条件
     */
    void addMustCondition(MyObject myObject);
}
