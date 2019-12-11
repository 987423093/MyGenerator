package com.dingdang.autocenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Data
public class MallBean implements Serializable {

    /**
     * 商城id
     */
    private Long mallId;

    /**
     * 商城名称
     */
    private String mallName;

    /**
     * 创建人用户id
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private Date modifyDate;
}