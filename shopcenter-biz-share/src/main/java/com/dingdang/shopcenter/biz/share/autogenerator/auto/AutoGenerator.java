package com.dingdang.shopcenter.biz.share.autogenerator.auto;

import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.MyFreemarker;
import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.env.MyFreemarkerEnv;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public class AutoGenerator implements IAutoGenerator{

    /**
     * 默认方法freemaker
     */
    private String method;

    /**
     * 环境
     */
    private IAutoEnv autoEnv;

    /**
     * 构造方法
     * @param autoEnv
     */
    public AutoGenerator(IAutoEnv autoEnv) {
        this.autoEnv = autoEnv;
    }

    /**
     * 默认方法调用器
     * @return
     */
    @Override
    public IAutoMethodGenerator createDefaultGenerator() {

        return new MyFreemarker((MyFreemarkerEnv) autoEnv);
    }
}
