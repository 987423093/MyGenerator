package com.dingdang.shopcenter.biz.share;

import mybatis.generator.service.MyMapperCodeGenerator;

import java.io.IOException;

/**
 * MyCodeGenerator class
 *
 * @author yangxiaowei
 * @date 2016/10/31
 */
public class MyCodeGenerator {

    public static void main(String[] args) throws IOException {
        String path = System.class.getResource("/Banner.properties").getPath();
        System.out.println(path);
        String[] paths = {path};
        MyMapperCodeGenerator.main(paths);
    }
}


