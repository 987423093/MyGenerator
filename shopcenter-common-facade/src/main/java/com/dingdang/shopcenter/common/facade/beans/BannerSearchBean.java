package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
@Data
public class BannerSearchBean implements Serializable {

    /**
     * banner名称
     */
    private String bannerName;
}