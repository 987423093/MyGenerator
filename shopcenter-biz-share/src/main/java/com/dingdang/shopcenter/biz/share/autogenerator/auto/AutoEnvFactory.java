package com.dingdang.shopcenter.biz.share.autogenerator.auto;

import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.env.MyFreemarkerEnv;
import com.dingdang.shopcenter.biz.share.autogenerator.utils.FilePathTool;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public class AutoEnvFactory implements IAutoEnvFactory {

    /**
     * 得到环境默认
     */
    @Override
    public IAutoEnv getDefaultEnv() {

        return new MyFreemarkerEnv(FilePathTool.getDefaultFilePath());
    }
}
