package com.dingdang.shopcenter.biz.shop.condition;

import lombok.Data;

/**
 * @author ysh
 * @description
 * @date 2019/10/11
 */
@Data
public class ColumnSearch {
    /**
     * 栏目名称查询
     */
    private String columnName;
    /**
     * 栏目类型 1自定义 ,2新品时间(时间排序) ,3热兑(销量排序),4热销(点击量)  5七巧板
     */
    private  Integer columnType;
    /**
     * 是否启用   1-启用 0-禁用
     */
    private Integer enable;
    /**
     * 商城ID
     */
    private Long mallId;
}
