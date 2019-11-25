package com.dingdang.shopcenter.biz.shop.condition;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ysh
 * @description
 * @date 2019/10/15
 */
@Data
public class NavigationSearch {
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
