package com.dingdang.autocenter.web;

import com.dingdang.commons.utils.DateUtils;
import com.dingdang.commons.web.server.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Calendar;

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

        Calendar cal = Calendar.getInstance();
        cal.set(2019, 0, 1, 0, 0, 0);
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        System.out.println(DateUtils.parse(cal.getTime(), DateUtils.DATE_TIME_FORMAT));
    }

}
