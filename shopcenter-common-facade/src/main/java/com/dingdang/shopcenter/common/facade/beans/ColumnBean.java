package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ColumnBean implements Serializable {

    private Long columnId;

    private String columnName;

    private Integer columnType;

    private Integer enable;

    private Long mallId;

    private String direction;

    private Integer sortNum;

    private String style;

    private Integer number;

    private String columnUrl;

    private String columnImage;

    private Long creator;

    private Long modifier;

    private Date createDate;

    private Date modifyDate;

    private String state;
    /**
     * 栏目商品关联
     */
    List<ColumnGoodsBean> columnGoodsList;

}