package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoutao
 * @date 2019/10/9
 */
@Data
public class MallBean implements Serializable {

    /**
     * 商城id主键
     */
    private Long mallId;

    /**
     * 商城名称
     */
    private String mallName;

    /**
     * 商城类型 1.丁当优选 2.其他
     */
    private Integer mallType;

    /**
     * 商城logo
     */
    private String mallLogo;

    /**
     * 是否启用 0.未启用 1.启用
     */
    private Integer enableStatus;

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
