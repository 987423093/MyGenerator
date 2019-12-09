package com.dingdang.autocenter.web.server.mall.request;

import com.dingdang.commons.web.server.bean.RequestJsonBody;
import lombok.Data;

import java.io.Serializable;

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