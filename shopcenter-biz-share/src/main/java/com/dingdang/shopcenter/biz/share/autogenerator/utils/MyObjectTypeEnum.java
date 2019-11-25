package com.dingdang.shopcenter.biz.share.autogenerator.utils;

import lombok.Getter;

@Getter
public enum MyObjectTypeEnum {

    /**
     * 长整形列表
     */
    LONG_LIST("List<Long>"),
    /**
     * 整形列表
     */
    INTEGER_LIST("List<Integer>"),
    /**
     * 字符串列表
     */
    STRING_LIST("List<String>"),
    /**
     * 时间范围
     */
    DATE("Date");

    private String value;

    MyObjectTypeEnum(String value) {
        this.value = value;
    }
}
