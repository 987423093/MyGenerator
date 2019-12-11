package com.dingdang.autocenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Data
public class MallSearchBean implements Serializable {

    /**
     * 商城名称
     */
    private String mallName;
}