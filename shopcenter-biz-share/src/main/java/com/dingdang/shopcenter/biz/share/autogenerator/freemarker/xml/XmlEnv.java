package com.dingdang.shopcenter.biz.share.autogenerator.freemarker.xml;

import com.dingdang.shopcenter.biz.share.autogenerator.utils.GlobalEnv;
import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.env.MyFreemarkerEnv;

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
     * @param myFreemarkerEnv
     */
    public XmlEnv(MyFreemarkerEnv myFreemarkerEnv){

        this.initFilePath(myFreemarkerEnv);
    }

    /**
     * 初始化路径
     * @param myFreemarkerEnv
     */
    private void initFilePath(MyFreemarkerEnv myFreemarkerEnv){

        String packagePath = myFreemarkerEnv.getPackagePath();
        int index = packagePath.indexOf("src\\main\\java");
        packagePath = packagePath.substring(index + "src\\main\\java".length());
        packagePath = packagePath.replace("\\", ".");
        packagePath = packagePath.substring(1);
        this.commentGeneratorFilePath = packagePath + ".autogenerator.freemarker.mybatis.DBObjectCommentGenerator";
        this.javaTypeResolverFilePath = packagePath + ".autogenerator.freemarker.mybatis.DBObjectJavaTypeResolver";
        this.connectionURL = preConnectionURL + GlobalEnv.getCompany() + "_" + myFreemarkerEnv.getItemCenter();
        this.targetPackage = "com." + GlobalEnv.getCompany() + "." + myFreemarkerEnv.getItemCenter() + ".biz." + myFreemarkerEnv.getItem()+ ".dataobject";
        this.targetProject = myFreemarkerEnv.getItemCenter() + "-biz-" + myFreemarkerEnv.getItem()+ "\\src\\main\\java";
        this.myBatisXmlPath = myFreemarkerEnv.getBasePath() + myFreemarkerEnv.getResourcePath() + "\\generatorConfig.xml";
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
