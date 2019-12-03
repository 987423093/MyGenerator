package com.dingdang.autocenter.biz.share.autogenerator.freemarker.condition;

import com.dingdang.autocenter.biz.share.autogenerator.freemarker.domain.MyObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Data
public class MallConditions {

    /**
     * 商城id
     */
    public static MyObject mallId = new MyObject("mallId", "Long", "商城id", "商城id");

    /**
     * 商城名称
     */
    public static MyObject mallName = new MyObject("mallName", "String", "商城名称", "商城名称");

    /**
     * 创建人用户id
     */
    public static MyObject creator = new MyObject("creator", "Long", "创建人用户id", "创建人用户id");

    /**
     * 创建时间
     */
    public static MyObject createDate = new MyObject("createDate", "Date", "创建时间", "创建时间");

    /**
     * 修改时间
     */
    public static MyObject modifier = new MyObject("modifier", "Long", "修改时间", "修改时间");

    /**
     * 修改时间
     */
    public static MyObject modifyDate = new MyObject("modifyDate", "Date", "修改时间", "修改时间");
}