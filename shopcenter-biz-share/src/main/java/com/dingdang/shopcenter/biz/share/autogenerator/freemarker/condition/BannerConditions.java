package com.dingdang.shopcenter.biz.share.autogenerator.freemarker.condition;

import com.dingdang.shopcenter.biz.share.autogenerator.utils.MyObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoutao's template
 * @date 2019/11/25
 */
@Data
public class BannerConditions {

    /**
     * banner主键
     */
    public static MyObject bannerId = new MyObject("bannerId", "Long", "banner主键", "banner主键");

    /**
     * banner名称
     */
    public static MyObject bannerName = new MyObject("bannerName", "String", "banner名称", "banner名称");

    /**
     * banner地址
     */
    public static MyObject bannerUrl = new MyObject("bannerUrl", "String", "banner地址", "banner地址");

    /**
     * banner图片
     */
    public static MyObject bannerImage = new MyObject("bannerImage", "String", "banner图片", "banner图片");

    /**
     * 商城id
     */
    public static MyObject mallId = new MyObject("mallId", "Long", "商城id", "商城id");

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