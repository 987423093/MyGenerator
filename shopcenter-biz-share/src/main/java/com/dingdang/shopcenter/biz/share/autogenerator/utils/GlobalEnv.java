package com.dingdang.shopcenter.biz.share.autogenerator.utils;

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
    private static final String USERNAME = "dingdangdev";

    /**
     * 密码
     */
    private static final String PASSWORD = "kRcTzJTtoW3ZQtt1";

    /**
     * 连接方式
     */
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    /**
     * 连接地址前缀
     */
    private static final String PRE_CONNECTIONURL = "jdbc:mysql://rm-bp1lsjn1hm7a6rsr85o.mysql.rds.aliyuncs.com:3306/";

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
}
