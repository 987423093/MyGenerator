package com.dingdang.shopcenter.biz.shop.dataobject;

import java.util.Date;

public class ColumnGoods {

private Long columnGoodsId;

private Long columnId;

private Long goodsId;

private Integer sortNum;

private Long creator;

private Long modifier;

private Date createDate;

private Date modifyDate;

private String state;




public Long getColumnGoodsId () {
return columnGoodsId;
}

public void setColumnGoodsId (Long columnGoodsId) {
this.columnGoodsId = columnGoodsId;
}

public Long getColumnId () {
return columnId;
}

public void setColumnId (Long columnId) {
this.columnId = columnId;
}

public Long getGoodsId () {
return goodsId;
}

public void setGoodsId (Long goodsId) {
this.goodsId = goodsId;
}

public Integer getSortNum () {
return sortNum;
}

public void setSortNum (Integer sortNum) {
this.sortNum = sortNum;
}

public Long getCreator () {
return creator;
}

public void setCreator (Long creator) {
this.creator = creator;
}

public Long getModifier () {
return modifier;
}

public void setModifier (Long modifier) {
this.modifier = modifier;
}

public Date getCreateDate () {
return createDate;
}

public void setCreateDate (Date createDate) {
this.createDate = createDate;
}

public Date getModifyDate () {
return modifyDate;
}

public void setModifyDate (Date modifyDate) {
this.modifyDate = modifyDate;
}

public String getState () {
return state;
}

public void setState (String state) {
this.state = state;
}


}