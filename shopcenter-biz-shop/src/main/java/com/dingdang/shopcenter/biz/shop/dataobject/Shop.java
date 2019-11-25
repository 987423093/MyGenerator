package com.dingdang.shopcenter.biz.shop.dataobject;

import java.util.Date;

public class Shop {

private Long shopId;

private String shopName;

private Integer shopType;

private String shopLogo;

private Integer enableStatus;

private String merchantNo;

private Long creator;

private Date createDate;

private Long modifier;

private Date modifyDate;

private String state;




public Long getShopId () {
return shopId;
}

public void setShopId (Long shopId) {
this.shopId = shopId;
}

public String getShopName () {
return shopName;
}

public void setShopName (String shopName) {
this.shopName = shopName;
}

public Integer getShopType () {
return shopType;
}

public void setShopType (Integer shopType) {
this.shopType = shopType;
}

public String getShopLogo () {
return shopLogo;
}

public void setShopLogo (String shopLogo) {
this.shopLogo = shopLogo;
}

public Integer getEnableStatus () {
return enableStatus;
}

public void setEnableStatus (Integer enableStatus) {
this.enableStatus = enableStatus;
}

public String getMerchantNo () {
return merchantNo;
}

public void setMerchantNo (String merchantNo) {
this.merchantNo = merchantNo;
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