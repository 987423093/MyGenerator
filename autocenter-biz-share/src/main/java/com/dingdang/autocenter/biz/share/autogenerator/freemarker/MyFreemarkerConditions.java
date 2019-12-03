package com.dingdang.autocenter.biz.share.autogenerator.freemarker;

import com.dingdang.autocenter.biz.share.autogenerator.auto.IAutoConditions;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.domain.MyObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
public class MyFreemarkerConditions implements IAutoConditions {

    /**
     * 必传条件
     */
    private List<MyObject> mustConditions;

    /**
     * 查询条件
     */
    private List<MyObject> searchConditions;

    /**
     * 时间范围条件
     */
    private List<MyObject> dateBetweenConditions;

    /**
     * 模糊查询条件
     */
    private List<MyObject> likeConditions;

    /**
     * 添加必填条件
     * @param mustCondition 必填条件
     */
    @Override
    public void addMustCondition(MyObject mustCondition) {

        if (this.mustConditions == null) {
            this.mustConditions = new ArrayList<>();
        }
        this.mustConditions.add(mustCondition);
    }

    /**
     * 添加查询条件
     * @param searchCondition 查询条件
     */
    @Override
    public void addSearchCondition(MyObject searchCondition) {

        if (this.searchConditions == null) {
            this.searchConditions = new ArrayList<>();
        }
        this.searchConditions.add(searchCondition);
    }

    /**
     * 添加时间范围条件
     * @param dateBetweenCondition 时间条件
     */
    @Override
    public void addDateBetweenCondition(MyObject dateBetweenCondition) {

        if (this.dateBetweenConditions == null){
            this.dateBetweenConditions = new ArrayList<>();
        }
        this.dateBetweenConditions.add(dateBetweenCondition);
    }

    /**
     * 添加模糊查询条件
     * @param likeCondition 模糊查询条件
     */
    @Override
    public void addLikeCondition(MyObject likeCondition) {

        if (this.likeConditions == null) {
            this.likeConditions = new ArrayList<>();
        }
        this.likeConditions.add(likeCondition);
    }

    public List<MyObject> getMustConditions() {
        return mustConditions;
    }

    public List<MyObject> getSearchConditions() {
        return searchConditions;
    }

    public List<MyObject> getDateBetweenConditions() {
        return dateBetweenConditions;
    }

    public List<MyObject> getLikeConditions() {
        return likeConditions;
    }
}
