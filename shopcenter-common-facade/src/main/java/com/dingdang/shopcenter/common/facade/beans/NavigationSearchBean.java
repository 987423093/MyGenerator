package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @author zhoutao's template
*/
@Data
public class NavigationSearchBean implements Serializable {
    /**
     * 状态
     */
    private Integer navigationStatus;
    /**
     * 快捷导航名称
     */
    private String navigationName;
    /**
     * 导航ID集合
     */
    private List<Long> navigationIdList;
}
