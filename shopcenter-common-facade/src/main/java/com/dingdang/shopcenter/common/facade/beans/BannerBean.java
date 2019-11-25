package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoutao
 * @date 2019/10/9
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
     * 创建id
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改id
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private Date modifyDate;
}
