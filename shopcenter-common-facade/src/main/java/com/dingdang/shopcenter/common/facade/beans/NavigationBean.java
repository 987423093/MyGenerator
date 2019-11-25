package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @author zhoutao's template
*/
@Data
public class NavigationBean implements Serializable {

    /**
     * 快捷导航主键
     */
    private Long navigationId;
    /**
     * 导航名称
     */
    private String navigationName;
    /**
     * 图片
     */
    private String navigationImage;
    /**
     * 链接
     */
    private String navigationUrl;
    /**
     * 描述
     */
    private String navigationDesc;
    /**
     * 排序值
     */
    private Integer navigationSort;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态 0禁用 1启用
     */
    private Integer navigationStatus;

    private Long creator;

    private Date createDate;

    private Long modifier;

    private Date modifyDate;
}
