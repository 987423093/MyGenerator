package com.dingdang.autocenter.biz.auto.dataobject;

import java.util.Date;

public class Mall {

private Long mallId;

private String mallName;

private Long creator;

private Date createDate;

private Long modifier;

private Date modifyDate;

private String state;




public Long getMallId () {
return mallId;
}

public void setMallId (Long mallId) {
this.mallId = mallId;
}

public String getMallName () {
return mallName;
}

public void setMallName (String mallName) {
this.mallName = mallName;
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