package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @author zhoutao's template
*/
@Data
public class MallNavigationBean implements Serializable {

    /**
     * 商城快捷导航主键
     */
    private Long mallNavigationId;

    private Long navigationId;

    private Long mallId;

    private Long creator;

    private Date createDate;

    private Long modifier;

    private Date modifyDate;

}
