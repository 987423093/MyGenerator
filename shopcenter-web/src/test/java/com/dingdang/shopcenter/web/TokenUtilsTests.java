package com.dingdang.shopcenter.web;

import com.dingdang.commons.web.server.util.TokenUtils;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author zhoutao
 * @date 2019/9/11
 */
public class TokenUtilsTests extends AbstractFacadeServiceTests {

    @Test
    public void getToken(){

        System.out.println(TokenUtils.encryptToken(1L, ""));
    }

    @Test
    public void test(){

        BigDecimal bigDecimal = null;
        bigDecimal = Optionals.orDefault(bigDecimal);
        System.out.println(bigDecimal);
    }

}
