package com.dingdang.shopcenter.biz.share.autogenerator.freemarker.mybatis;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.Properties;

/**
 * @author zhoutao
 * @date 2019/10/16
 * @description 自定义注释
 */
public class DBObjectCommentGenerator implements CommentGenerator {

    private Properties properties;
    private boolean suppressAllComments;

    public DBObjectCommentGenerator() {
        super();
        properties = new Properties();
        suppressAllComments = false;
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    /**
     * 设置字段注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

        if (!suppressAllComments) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }
    }
// mybatis-generator-1.3.5 才支持类注释
//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//
//        if (!suppressAllComments){
//            topLevelClass.addJavaDocLine("/**");
//            topLevelClass.addJavaDocLine(" * @author "  + author);
//            topLevelClass.addJavaDocLine(" * @Date " + DateUtils.parse(new Date(), "yyyy/MM/dd"));
//            topLevelClass.addJavaDocLine(" */");
//        }
//    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        if (suppressAllComments) {
            return;
        }
        return;
    }

    @Override
    public void addComment(XmlElement xmlElement) {
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
    }

    /**
     * 判断传入参数是否为true
     * @param property
     * @return
     */
    private boolean isTrue(String property) {
        if("true".equals(property)){
            return true;
        }
        return false;
    }
}
