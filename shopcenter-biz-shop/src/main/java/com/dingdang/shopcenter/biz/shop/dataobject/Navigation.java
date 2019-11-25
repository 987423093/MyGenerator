package com.dingdang.shopcenter.biz.shop.dataobject;

import java.util.Date;

public class Navigation {

private Long navigationId;

private String navigationName;

private String navigationImage;

private String navigationUrl;

private String navigationDesc;

private Integer navigationSort;

private String remark;

private Integer navigationStatus;

private Long creator;

private Date createDate;

private Long modifier;

private Date modifyDate;

private String state;




public Long getNavigationId () {
return navigationId;
}

public void setNavigationId (Long navigationId) {
this.navigationId = navigationId;
}

public String getNavigationName () {
return navigationName;
}

public void setNavigationName (String navigationName) {
this.navigationName = navigationName;
}

public String getNavigationImage () {
return navigationImage;
}

public void setNavigationImage (String navigationImage) {
this.navigationImage = navigationImage;
}

public String getNavigationUrl () {
return navigationUrl;
}

public void setNavigationUrl (String navigationUrl) {
this.navigationUrl = navigationUrl;
}

public String getNavigationDesc () {
return navigationDesc;
}

public void setNavigationDesc (String navigationDesc) {
this.navigationDesc = navigationDesc;
}

public Integer getNavigationSort () {
return navigationSort;
}

public void setNavigationSort (Integer navigationSort) {
this.navigationSort = navigationSort;
}

public String getRemark () {
return remark;
}

public void setRemark (String remark) {
this.remark = remark;
}

public Integer getNavigationStatus () {
return navigationStatus;
}

public void setNavigationStatus (Integer navigationStatus) {
this.navigationStatus = navigationStatus;
}

public Long getCreator () {
return creator;
}

public void setCreator (Long creator) {
this.creator = creator;
}

public Date getCreateDate () {
return createDate;
}

public void setCreateDate (Date createDate) {
this.createDate = createDate;
}

public Long getModifier () {
return modifier;
}

public void setModifier (Long modifier) {
this.modifier = modifier;
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