package com.dingdang.shopcenter.biz.shop.dataobject;

import java.util.Date;

public class MallNavigation {

private Long mallNavigationId;

private Long navigationId;

private Long mallId;

private Long creator;

private Date createDate;

private Long modifier;

private Date modifyDate;

private String state;




public Long getMallNavigationId () {
return mallNavigationId;
}

public void setMallNavigationId (Long mallNavigationId) {
this.mallNavigationId = mallNavigationId;
}

public Long getNavigationId () {
return navigationId;
}

public void setNavigationId (Long navigationId) {
this.navigationId = navigationId;
}

public Long getMallId () {
return mallId;
}

public void setMallId (Long mallId) {
this.mallId = mallId;
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