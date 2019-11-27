package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author zhoutao
 * @date 2019/11/27
 */
@Data
public class BannerBean implements Serializable {

    /**
     * banner主键
     */
    private Long bannerId;

    /**
     * banner名称
     */
    private String bannerName;

    /**
     * banner地址
     */
    private String bannerUrl;

    /**
     * banner图片
     */
    private String bannerImage;

    /**
     * 商城id
     */
    private Long mallId;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private Date modifyDate;
}