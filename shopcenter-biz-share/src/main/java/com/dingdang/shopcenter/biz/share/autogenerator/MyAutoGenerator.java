package com.dingdang.shopcenter.biz.share.autogenerator;

import com.dingdang.shopcenter.biz.share.autogenerator.auto.*;

/**
 * @author zhoutao
 * @date 2019/10/14
 */
public class MyAutoGenerator {

/*
-----------------------------------------------------------------------------------
中心层代码生成工具3.0_zt

【参数介绍】
    1.tableName: 表名
    2.argCN: 中文描述
【方法介绍】
    1.createAll(): 生成所有类,包含了所有的业务层,bean,db,dubboConfig
    2.rollBack(): 回滚最近一次代码
    3.rollBack(version):回滚对应版本号的代码，version见cache下的version文件
【设置条件】
    1.setMustCondition: 设置必填条件
    2.setSearchCondition: 设置可选条件
    3.setLikeCondition: 设置模糊匹配条件与searchCondition互斥
    4.setDateBetweenCondition: 设置时间范围
【辅助功能】
    1.备份 backUp 默认false不开启 setBackUp(true)来开启历史备份，回滚代码
    2.打印过程 outPrint 默认true开启 setOutPrint(false) 来关闭打印
-----------------------------------------------------------------------------------
*/

    /**
     * 执行方法
     * @param args
     */
    public static void main(String[] args) {

        //祖先生成器
        IAutoGenerator autoGenerator = new AutoGenerator(new AutoEnvFactory().getDefaultEnv());
        //方法生成器
        IAutoMethodGenerator autoMethodGenerator = autoGenerator.createDefaultGenerator().initTableObject("t_banner", "横幅");
        //初始化条件对象
        autoMethodGenerator.initConditions();
        //设置条件
        setCondition(autoMethodGenerator);
        autoMethodGenerator.createAll();
    }


    /**
     * 设置可选条件
     * @param autoMethodGenerator
     */
    private static void setCondition(IAutoMethodGenerator autoMethodGenerator){

    }
}
