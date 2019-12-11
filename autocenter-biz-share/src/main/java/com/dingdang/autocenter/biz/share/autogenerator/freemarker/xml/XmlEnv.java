package com.dingdang.autocenter.biz.share.autogenerator.freemarker.xml;

import com.dingdang.autocenter.biz.share.autogenerator.utils.GlobalEnv;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.env.MyFreemarkerGlobalEnv;

/**
 * @author zhoutao
 * @date 2019/10/21
 * @description xml环境配置类
 */
public class XmlEnv {

    /**
     * 自定义注释文件路径
     */
    private String commentGeneratorFilePath;

    /**
     * 自定义字段映射文件路径
     */
    private String javaTypeResolverFilePath;

    /**
     * 自定义字段数据库连接
     */
    private String connectionURL;

    /**
     * 生成dataObject目标文件路径
     */
    private String targetPackage;

    /**
     * 生成dataObject目标项目路径
     */
    private String targetProject;

    /**
     * 要获取的xml文件路径
     */
    private String myBatisXmlPath;

    /**
     * 用户名
     */
    private final String username = GlobalEnv.getUsername();

    /**
     * 密码
     */
    private final String password = GlobalEnv.getPassword();

    /**
     * 连接方式
     */
    private final String driverClass = GlobalEnv.getDriverClass();

    /**
     * 连接地址前缀
     */
    private final String preConnectionURL = GlobalEnv.getPreConnectionURL();

    /**
     * 构造方法
     * @param myFreemarkerGlobalEnv
     */
    public XmlEnv(MyFreemarkerGlobalEnv myFreemarkerGlobalEnv){

        this.initFilePath(myFreemarkerGlobalEnv);
    }

    /**
     * 初始化路径
     * @param myFreemarkerGlobalEnv
     */
    private void initFilePath(MyFreemarkerGlobalEnv myFreemarkerGlobalEnv){

        String packagePath = myFreemarkerGlobalEnv.getPackagePath();
        int index = packagePath.indexOf("src\\main\\java");
        packagePath = packagePath.substring(index + "src\\main\\java".length());
        packagePath = packagePath.replace("\\", ".");
        packagePath = packagePath.substring(1);
        this.commentGeneratorFilePath = packagePath + ".autogenerator.freemarker.mybatis.DBObjectCommentGenerator";
        this.javaTypeResolverFilePath = packagePath + ".autogenerator.freemarker.mybatis.DBObjectJavaTypeResolver";
        this.connectionURL = preConnectionURL + GlobalEnv.getCompany() + "_" + myFreemarkerGlobalEnv.getItemCenter();
        this.targetPackage = "com." + GlobalEnv.getCompany() + "." + myFreemarkerGlobalEnv.getItemCenter() + ".biz." + myFreemarkerGlobalEnv.getItem()+ ".dataobject";
        this.targetProject = myFreemarkerGlobalEnv.getItemCenter() + "-biz-" + myFreemarkerGlobalEnv.getItem()+ "\\src\\main\\java";
        this.myBatisXmlPath = myFreemarkerGlobalEnv.getBasePath() + myFreemarkerGlobalEnv.getResourcePath() + "\\generatorConfig.xml";
    }

    public String getCommentGeneratorFilePath() {
        return commentGeneratorFilePath;
    }

    public String getJavaTypeResolverFilePath() {
        return javaTypeResolverFilePath;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public String getMyBatisXmlPath() {
        return myBatisXmlPath;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getPreConnectionURL() {
        return preConnectionURL;
    }
}
