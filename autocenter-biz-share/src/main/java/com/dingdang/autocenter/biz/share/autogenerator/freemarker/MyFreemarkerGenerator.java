package com.dingdang.autocenter.biz.share.autogenerator.freemarker;

import com.dingdang.autocenter.biz.share.autogenerator.auto.*;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.env.MyFreemarkerGlobalEnv;
import com.dingdang.autocenter.biz.share.autogenerator.utils.FilePathTool;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public class MyFreemarkerGenerator implements IAutoGenerator {

    /**
     * 方法调用器
     * @return
     */
    @Override
    public IAutoMethodGenerator createMethodGenerator() {

        return new MyFreemarkerMethodGenerator(new MyFreemarkerGlobalEnv(FilePathTool.getDefaultFilePath()));
    }

    /**
     * 自定义环境方法调用器
     * @return
     */
    @Override
    public IAutoMethodGenerator createCustomMethodGenerator(String basePath, String itemCenter, String item) {
        return new MyFreemarkerMethodGenerator(new MyFreemarkerGlobalEnv(FilePathTool.getCustomFilePath(basePath, itemCenter, item)));
    }
}
