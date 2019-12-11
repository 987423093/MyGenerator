package com.dingdang.autocenter.biz.share.autogenerator.utils;

/**
 * @author zhoutao
 * @date 2019/10/23
 * @description 全局参数
 */
public class GlobalEnv {

    /**
     * 公司
     */
    private static final String COMPANY = "dingdang";

    /**
     * 用户名
     */
    private static final String USERNAME = "root";

    /**
     * 密码
     */
    private static final String PASSWORD = "zhoutao";

    /**
     * 连接方式
     */
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    /**
     * 连接地址前缀
     */
    private static final String PRE_CONNECTIONURL = "jdbc:mysql://122.51.211.176:3306/";

    /**
     * 作者
     */
    private static String author = "zhoutao";

    /**
     * 得到带-的公司
     * @return
     */
    public static String getCompanyX(){

        return COMPANY + "-";
    }

    public static String getCompany() {
        return COMPANY;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getDriverClass() {
        return DRIVER_CLASS;
    }

    public static String getPreConnectionURL() {
        return PRE_CONNECTIONURL;
    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        GlobalEnv.author = author;
    }
}
