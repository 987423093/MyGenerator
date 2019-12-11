package com.dingdang.autocenter.biz.share.autogenerator.freemarker.mybatis;

import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.xml.Dom4JUtils;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.xml.XmlEnv;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.domain.MyObject;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhoutao
 * @date 2019/10/16
 * @description db生成器
 */
public class DBObjectGenerator {

    /**
     * 最终使用的生成器
     */
    private MyBatisGenerator myBatisGenerator;

    /**
     * 参数和注释集合类
     */
    private List<MyObject> dbObjects = new ArrayList<>();

    /**
     * 主键对象
     */
    private MyObject primaryObject;

    /**
     * 调用方法
     */
    public DBObjectGenerator process() {

        if (myBatisGenerator == null){
            throw new ServiceException(-1, "请先设置tableName和argCN");
        }
        try {
            myBatisGenerator.generate(null);
        }catch (InterruptedException | IOException | SQLException e) {
            e.printStackTrace();
        }
        this.initDBObjects();
        return this;
    }

    /**
     * 得到db对象列表
     * @return
     */
    public List<MyObject> getDBObjects(){

        return dbObjects;
    }

    /**
     * 返回主键对象
     * @return
     */
    public MyObject getPrimaryObject(){

        return primaryObject;
    }

    /**
     * 初始化dbGenerator
     * @param dom4JUtils
     * @param xmlEnv
     * @throws Exception
     */
    public void initDBGenerator(Dom4JUtils dom4JUtils, XmlEnv xmlEnv){

        //初始化xml
        dom4JUtils.initXmlConfiguration(xmlEnv);
        //生成新的xml
        dom4JUtils.process();

        List<String> warnings = new ArrayList<>();
        //指定 逆向工程配置文件
        File configFile = new File(xmlEnv.getMyBatisXmlPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException | XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(true);
        try {
            myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化db对象
     */
    private void initDBObjects(){

        dbObjects = new ArrayList<>();
        //通过反射得到对应的字段和注释
        try {
            Class clazz = myBatisGenerator.getClass();
            Field field = clazz.getDeclaredField("generatedJavaFiles");
            field.setAccessible(true);
            List<GeneratedJavaFile> generatedJavaFiles = (List<GeneratedJavaFile>) field.get(myBatisGenerator);
            GeneratedJavaFile generatedJavaFile = generatedJavaFiles.get(0);
            CompilationUnit compilationUnit = generatedJavaFile.getCompilationUnit();

            //得到接口中的属性
            TopLevelClass topLevelClass = (TopLevelClass) compilationUnit;
            Class subClazz = topLevelClass.getClass().getSuperclass();
            Field subField = subClazz.getDeclaredField("fields");
            subField.setAccessible(true);

            boolean first = true;
            //封装入myObjects
            List<org.mybatis.generator.api.dom.java.Field> fields = (List<org.mybatis.generator.api.dom.java.Field>) subField.get(topLevelClass);
            for (org.mybatis.generator.api.dom.java.Field fi : fields) {
                String argName = fi.getName();
                List<String> argCNs = fi.getJavaDocLines();
                if (Objects.equals("state", argName)){
                    continue;
                }
                String sname = argCNs.get(1).substring(3);
                StringBuilder sb = new StringBuilder();
                int length = sname.length();
                for(int i = 0; i < length; i++){
                    char c = sname.charAt(i);
                    boolean bool = '(' == c || ' ' == c || (c > '0' && c < '9') || '（' == c || '，' == c || ',' == c;
                    if (bool) {
                        break;
                    }
                    sb.append(c);
                }

                String cname = argCNs.get(1);
                if (cname != null && cname.startsWith(" * ")){
                    cname = cname.substring(3);
                }
                MyObject myObject = new MyObject(argName, fi.getType().getShortName(), cname, sb.toString());
                if (first){
                    primaryObject = myObject;
                    first = false;
                }
                dbObjects.add(myObject);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
