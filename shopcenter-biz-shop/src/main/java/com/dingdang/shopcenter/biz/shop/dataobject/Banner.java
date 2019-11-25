package com.dingdang.shopcenter.biz.shop.dataobject;

import java.util.Date;

public class Banner {

private Long bannerId;

private String bannerName;

private String bannerUrl;

private String bannerImage;

private Long mallId;

private Long creator;

private Date createDate;

private Long modifier;

private Date modifyDate;

private String state;




public Long getBannerId () {
return bannerId;
}

public void setBannerId (Long bannerId) {
this.bannerId = bannerId;
}

public String getBannerName () {
return bannerName;
}

public void setBannerName (String bannerName) {
this.bannerName = bannerName;
}

public String getBannerUrl () {
return bannerUrl;
}

public void setBannerUrl (String bannerUrl) {
this.bannerUrl = bannerUrl;
}

public String getBannerImage () {
return bannerImage;
}

public void setBannerImage (String bannerImage) {
this.bannerImage = bannerImage;
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