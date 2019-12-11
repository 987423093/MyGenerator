package com.dingdang.autocenter.biz.share.autogenerator.code.server.web.request;

import com.dingdang.commons.web.server.bean.RequestJsonBody;
import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Data
public class MallRequest extends RequestJsonBody {

    /**
     * 商城id
     */
    private Long mallId;

    /**
     * 商城名称
     */
    private String mallName;

    /**
     * 创建人用户id
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private Date modifyDate;
}