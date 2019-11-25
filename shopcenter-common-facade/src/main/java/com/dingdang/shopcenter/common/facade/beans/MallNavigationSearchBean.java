package com.dingdang.shopcenter.common.facade.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @author zhoutao's template
*/
@Data
public class MallNavigationSearchBean implements Serializable {

    private Long mallId;

    private Long navigationId;
}
