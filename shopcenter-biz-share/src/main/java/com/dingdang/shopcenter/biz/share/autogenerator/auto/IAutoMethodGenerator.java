package com.dingdang.shopcenter.biz.share.autogenerator.auto;

import com.dingdang.shopcenter.biz.share.autogenerator.utils.MyObject;

/**
 * @author zhoutao
 * @date 2019/10/28
 */
public interface IAutoMethodGenerator {

    /**
     * 初始化表
     * @param tableName 表名称
     * @param argCN 参数中文名称
     * @return
     */
    IAutoMethodGenerator initTableObject(String tableName, String argCN);

    /**
     * 初始化接口层
     * @param projectName
     * @param packageName
     * @return
     */
    IAutoMethodGenerator initWebArgs(String projectName, String packageName);

    /**
     * 添加模糊条件
     * @param myObject 模糊条件
     */
    void addLikeCondition(MyObject myObject);

    /**
     * 添加时间范围条件
     * @param myObject 时间条件
     */
    void addDateBetweenCondition(MyObject myObject);

    /**
     * 添加查询条件
     * @param myObject 查询条件
     */
    void addSearchCondition(MyObject myObject);

    /**
     * 添加必填条件
     * @param myObject 必填条件
     */
    void addMustCondition(MyObject myObject);

    /**
     * 初始化条件对象
     */
    void initConditions();

    /**
     * 创建bean
     */
    void createBean();

    /**
     * 创建search
     */
    void createSearch();

    /**
     * 创建searchBean
     */
    void createSearchBean();

    /**
     * 创建beans
     */
    void createBeans();

    /**
     * 创建repository层
     */
    void createRepository();

    /**
     * 创建repositoryImpl层
     */
    void createRepositoryImpl();

    /**
     * 创建domain层
     */
    void createDomain();

    /**
     * 创建domainImpl层
     */
    void createDomainImpl();

    /**
     * 创建facade层
     */
    void createFacade();

    /**
     * 创建facadeImpl层
     */
    void createFacadeImpl();

    /**
     * 创建全部文件
     */
    void createAll();

    /**
     * 创建数据库对象
     */
    void createDBObject();

    /**
     * 创建增删改查的业务类
     */
    void createClazz();

    /**
     * 创建所有接口层
     */
    void createAllWeb();

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
     * 是否开启打印,默认true
     * @param outPrint true/false
     */
    void setOutPrint(boolean outPrint);

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
