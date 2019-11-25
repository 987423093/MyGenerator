package com.dingdang.shopcenter.biz.share.autogenerator.freemarker.mybatis;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * @author zhoutao
 * @date 2019/10/18
 * @description 自定义变量映射
 */
public class DBObjectJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public DBObjectJavaTypeResolver(){
        super();
        super.typeMap.put(-6, new JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
