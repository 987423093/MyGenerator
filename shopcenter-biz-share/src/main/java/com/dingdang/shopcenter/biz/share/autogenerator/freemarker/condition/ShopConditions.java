package com.dingdang.shopcenter.biz.share.autogenerator.freemarker.condition;

import com.dingdang.shopcenter.biz.share.autogenerator.utils.MyObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoutao's template
 * @date 2019/10/31
 */
@Data
public class ShopConditions {

    /**
     * 店铺id
     */
    public static MyObject shopId = new MyObject("shopId", "Long", "店铺id", "店铺id");

    /**
     * 店铺名称
     */
    public static MyObject shopName = new MyObject("shopName", "String", "店铺名称", "店铺名称");

    /**
     * 店铺类型 1.优选店铺 2.其他
     */
    public static MyObject shopType = new MyObject("shopType", "Integer", "店铺类型 1.优选店铺 2.其他", "店铺类型");

    /**
     * 店铺logo
     */
    public static MyObject shopLogo = new MyObject("shopLogo", "String", "店铺logo", "店铺logo");

    /**
     * 启用状态（0:未启用，1:已启用）
     */
    public static MyObject enableStatus = new MyObject("enableStatus", "Integer", "启用状态（0:未启用，1:已启用）", "启用状态");

    /**
     * 商户编号
     */
    public static MyObject merchantNo = new MyObject("merchantNo", "String", "商户编号", "商户编号");

    /**
     * 创建人
     */
    public static MyObject creator = new MyObject("creator", "Long", "创建人", "创建人");

    /**
     * 创建时间
     */
    public static MyObject createDate = new MyObject("createDate", "Date", "创建时间", "创建时间");

    /**
     * 修改人
     */
    public static MyObject modifier = new MyObject("modifier", "Long", "修改人", "修改人");

    /**
     * 修改时间
     */
    public static MyObject modifyDate = new MyObject("modifyDate", "Date", "修改时间", "修改时间");
}