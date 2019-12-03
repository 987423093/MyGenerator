package com.dingdang.autocenter.biz.share.autogenerator.auto;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public interface IAutoMethodGenerator {

    /**
     * 获得条件生成器
     * @return
     */
    IAutoConditions getConditionGenerator();

    /**
     * 初始化条件对象
     */
    void initConditions();

    /**
     * 创建全部文件
     */
    void createAll();

    /**
     * 创建所有中心层
     */
    void createCenter();

    /**
     * 创建所有接口层
     */
    void createServer();

    /**
     * 创建数据库层
     */
    void createDB();

    /**
     * 初始化表
     * @param tableName 表名称
     * @param argCN 参数中文名称
     * @return
     */
    IAutoMethodGenerator initTableObject(String tableName, String argCN);

    /**
     * 得到dubbo配置
     * @return
     */
    void getDubboConfig();

    /**
     * 是否开启备份,默认false
     * @param backup true/false
     */
    void setBackup(boolean backup);

    /**
     * 回滚上一次
     */
    void rollBack();

    /**
     * 指定版本号回滚，具体版本号请查阅cache下的version文件
     * @param version
     */
    void rollBack(String version);
}
