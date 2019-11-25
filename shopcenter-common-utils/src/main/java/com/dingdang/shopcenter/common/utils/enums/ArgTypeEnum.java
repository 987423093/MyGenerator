package com.dingdang.shopcenter.common.utils.enums;

import lombok.Getter;

@Getter
public enum ArgTypeEnum {

    //长整形类型
    LONG(1, "long"),
    //时间类型
    DATE(2, "date"),
    //字符类型
    CHAR(3, "character");

    /**
     * 类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String desc;

    ArgTypeEnum(Integer type, String desc){
        this.type = type;
        this.desc = desc;
    }
}
