package com.dingdang.autocenter.biz.share.autogenerator.code.server.web.request;

import lombok.Data;
import com.dingdang.commons.web.server.bean.RequestJsonBody;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author zhoutao
 * @date 2019/12/03
 */
@Data
public class MallSearchRequest extends RequestJsonBody {

    /**
     * 商城名称
     */
    private String mallName;
}