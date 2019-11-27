package com.dingdang.shopcenter.web;

import com.dingdang.commons.web.server.util.TokenUtils;
import com.dingdang.shopcenter.common.facade.beans.BannerBean;
import com.dingdang.shopcenter.common.facade.interfaces.BannerFacadeService;
import com.dingdang.shopcenter.common.utils.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author zhoutao
 * @date 2019/9/11
 */
public class TokenUtilsTests extends AbstractFacadeServiceTests {

    @Autowired
    private BannerFacadeService bannerFacadeService;

    @Test
    public void getToken(){

        BannerBean bannerBean = bannerFacadeService.getBannerDetail(2L);
        System.out.println(bannerBean);
        System.out.println(TokenUtils.encryptToken(1L, ""));
    }

    @Test
    public void test(){

        BigDecimal bigDecimal = null;
        bigDecimal = Optionals.orDefault(bigDecimal);
        System.out.println(bigDecimal);
    }

}
