package com.dingdang.autocenter.biz.share.autogenerator.freemarker.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/10/18
 * @description xml生成工具
 */
public class Dom4JUtils {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 文件配置
     */
    private XmlEnv xmlEnv;

    /**
     * 文件document
     */
    private Document document;

    /**
     * element属性table
     */
    private final String table = "table";

    /**
     * element属性commentGenerator
     */
    private final String commentGenerator = "commentGenerator";

    /**
     * element属性javaTypeResolver
     */
    private final String javaTypeResolver = "javaTypeResolver";

    /**
     * element属性connectionURL
     */
    private final String jdbcConnection = "jdbcConnection";

    /**
     * element属性javaModelGenerator
     */
    private final String javaModelGenerator = "javaModelGenerator";

    /**
     * 初始化
     * @param tableName
     * @param objectName
     */
    public Dom4JUtils(String tableName, String objectName) {

        this.tableName = tableName;
        this.objectName = objectName;
    }

    public Dom4JUtils() {
    }

    /**
     * 生成Xml document
     */
    public void initXmlConfiguration(XmlEnv env) {

        xmlEnv = env;
        SAXReader saxReader = new SAXReader();
        try{
            document = saxReader.read(new File(xmlEnv.getMyBatisXmlPath()));
        }catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出目标xml
     */
    public void process() {

        Element root = document.getRootElement();
        //设置xml
        this.calcElement(root);
        //生成xml
        try{
            this.outToXml();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 生成xml
     */
    private void outToXml() throws IOException {

        //指定文件输出的位置
        FileOutputStream out =new FileOutputStream(xmlEnv.getMyBatisXmlPath());
        //指定文本的写出的格式：
        OutputFormat format= OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        //设置缩进
        format.setIndent("    ");
        //创建写出对象
        XMLWriter writer=new XMLWriter(out, format);
        //写出Document对象
        writer.write(document);
        //关闭流
        writer.close();
    }

    /**
     * 迭代子节点
     * @param parentElement
     */
    private void calcElement(Element parentElement) {

        if (parentElement == null){
            return;
        }

        //表
        if (table.equals(parentElement.getName())){
            Attribute tableNameAttribute = parentElement.attribute("tableName");
            tableNameAttribute.setValue(tableName);
            Attribute objectNameAttribute = parentElement.attribute("domainObjectName");
            objectNameAttribute.setValue(objectName);
        }

        //注释
        if(commentGenerator.equals(parentElement.getName())){
            Attribute commentAttribute = parentElement.attribute("type");
            commentAttribute.setValue(xmlEnv.getCommentGeneratorFilePath());
        }

        //类型
        if (javaTypeResolver.equals(parentElement.getName())){
            Attribute typeAttribute = parentElement.attribute("type");
            typeAttribute.setValue(xmlEnv.getJavaTypeResolverFilePath());
        }

        //数据库
        if (jdbcConnection.equals(parentElement.getName())){
            Attribute connectionAttribute = parentElement.attribute("connectionURL");
            connectionAttribute.setValue(xmlEnv.getConnectionURL());
            Attribute userIdAttribute = parentElement.attribute("userId");
            userIdAttribute.setValue(xmlEnv.getUsername());
            Attribute passwordAttribute = parentElement.attribute("password");
            passwordAttribute.setValue(xmlEnv.getPassword());
            Attribute driverClassAttribute = parentElement.attribute("driverClass");
            driverClassAttribute.setValue(xmlEnv.getDriverClass());
        }

        //实体类存放位置
        if (javaModelGenerator.equals(parentElement.getName())){
            Attribute packageAttribute = parentElement.attribute("targetPackage");
            packageAttribute.setValue(xmlEnv.getTargetPackage());
            Attribute projectAttribute = parentElement.attribute("targetProject");
            projectAttribute.setValue(xmlEnv.getTargetProject());
        }

        List elements = parentElement.elements();
        Iterator iter = elements.iterator();
        while (iter.hasNext()) {
            Element element = (Element) iter.next();
            calcElement(element);
        }
    }
}
