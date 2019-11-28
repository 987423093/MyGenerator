package com.dingdang.shopcenter.biz.share.autogenerator.auto;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public interface IAutoGenerator {

    /**
     * 方法调用器
     * @return
     */
    IAutoMethodGenerator createMethodGenerator();

    /**
     * 自定义环境方法调用器
     * @param basePath
     * @param itemCenter
     * @param item
     * @return
     */
    IAutoMethodGenerator createCustomMethodGenerator(String basePath, String itemCenter, String item);
}
