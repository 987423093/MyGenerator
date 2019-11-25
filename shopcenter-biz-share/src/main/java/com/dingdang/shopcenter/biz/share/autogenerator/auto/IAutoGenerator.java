package com.dingdang.shopcenter.biz.share.autogenerator.auto;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public interface IAutoGenerator {

    /**
     * 具体方法调用器
     * @return
     */
    IAutoMethodGenerator createDefaultGenerator();
}
