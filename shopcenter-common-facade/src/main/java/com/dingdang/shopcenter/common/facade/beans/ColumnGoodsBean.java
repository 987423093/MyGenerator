package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ColumnGoodsBean implements Serializable {

    private Long columnGoodsId;

    private Long columnId;

    private Long goodsId;

    private Integer sortNum;

    private Long creator;

    private Long modifier;

    private Date createDate;

    private Date modifyDate;

    private String state;

}