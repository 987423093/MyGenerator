package com.dingdang.shopcenter.biz.shop.dataobject;

import java.util.Date;

public class Column {

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

private String remark;

private Long creator;

private Long modifier;

private Date createDate;

private Date modifyDate;

private String state;




public Long getColumnId () {
return columnId;
}

public void setColumnId (Long columnId) {
this.columnId = columnId;
}

public String getColumnName () {
return columnName;
}

public void setColumnName (String columnName) {
this.columnName = columnName;
}

public Integer getColumnType () {
return columnType;
}

public void setColumnType (Integer columnType) {
this.columnType = columnType;
}

public Integer getEnable () {
return enable;
}

public void setEnable (Integer enable) {
this.enable = enable;
}

public Long getMallId () {
return mallId;
}

public void setMallId (Long mallId) {
this.mallId = mallId;
}

public String getDirection () {
return direction;
}

public void setDirection (String direction) {
this.direction = direction;
}

public Integer getSortNum () {
return sortNum;
}

public void setSortNum (Integer sortNum) {
this.sortNum = sortNum;
}

public String getStyle () {
return style;
}

public void setStyle (String style) {
this.style = style;
}

public Integer getNumber () {
return number;
}

public void setNumber (Integer number) {
this.number = number;
}

public String getColumnUrl () {
return columnUrl;
}

public void setColumnUrl (String columnUrl) {
this.columnUrl = columnUrl;
}

public String getColumnImage () {
return columnImage;
}

public void setColumnImage (String columnImage) {
this.columnImage = columnImage;
}

public String getRemark () {
return remark;
}

public void setRemark (String remark) {
this.remark = remark;
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