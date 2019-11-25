package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ShopSearchBean implements Serializable {

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺类型 1.优选店铺 2.其他
     */
    private Integer shopType;

    /**
     * 店铺logo
     */
    private String shopLogo;

    /**
     * 店铺启用禁用 1.正常 0.禁用
     */
    private Integer enableStatus;

    /**
     * 商家id -1.平台
     */
    private String merchantNo;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 店铺列表
     */
    List<Long> shopIds;
}