package com.dingdang.autocenter.biz.share.autogenerator.freemarker;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.dingdang.autocenter.biz.share.autogenerator.auto.IAutoMethodGenerator;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.env.MyFreemarkerGlobalEnv;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.env.MyFreemarkerLocalEnv;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.mybatis.DBObjectGenerator;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.xml.Dom4JUtils;
import com.dingdang.autocenter.biz.share.autogenerator.freemarker.xml.XmlEnv;
import com.dingdang.autocenter.biz.share.autogenerator.utils.GlobalEnv;
import com.dingdang.autocenter.biz.share.autogenerator.utils.StringFormatUtils;
import com.dingdang.commons.exceptions.ServiceException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import mybatis.generator.service.MyMapperCodeGenerator;

import java.io.*;
import java.util.*;

/**
 * @author zhoutao
 * @date 2019/10/14
 * 核心工具类
 */
public class MyFreemarkerMethodGenerator implements IAutoMethodGenerator {
    
    /**
     * 条件对象
     */
    private MyFreemarkerConditions myFreemarkerConditions;

    /**
     * 路径环境配置
     */
    private MyFreemarkerGlobalEnv myFreemarkerGlobalEnv;

    /**
     * 当前表环境路径
     */
    private MyFreemarkerLocalEnv myFreemarkerLocalEnv;

    /**
     * 数据库对象生成器
     */
    private DBObjectGenerator dbObjectGenerator;

    /**
     * 数据库Mybatis生成器
     */
    private MyMapperCodeGenerator myMapperCodeGenerator;

    /**
     * 版本号是否已经记录
     */
    private boolean versionCheck;

    /**
     * 历史是否已经记录
     */
    private boolean historyCheck;

    /**
     * 默认不开启备份
     */
    private boolean backup;

    /**
     * 默认打印开启
     */
    private boolean outPrint;

    /**
     * 私有
     */
    private MyFreemarkerMethodGenerator(){

    }

    /**
     * 构造方法
     */
    public MyFreemarkerMethodGenerator(MyFreemarkerGlobalEnv myFreemarkerGlobalEnv) {

        this.dbObjectGenerator = new DBObjectGenerator();
        this.myMapperCodeGenerator = new MyMapperCodeGenerator();
        this.myFreemarkerConditions = new MyFreemarkerConditions();
        this.versionCheck = false;
        this.historyCheck = false;
        this.backup = false;
        this.outPrint = true;
        this.myFreemarkerGlobalEnv = myFreemarkerGlobalEnv;
    }

    /**
     * 获得条件生成器
     */
    @Override
    public MyFreemarkerConditions getConditionGenerator() {

        return this.myFreemarkerConditions;
    }

    /**
     * 是否开启备份
     * @param backup 是否备份 true/false
     */
    @Override
    public void setBackup(boolean backup) {

        this.backup = backup;
    }

    /**
     * 初始化表信息
     * @param tableName 表名称
     * @param argCN 参数中文名称
     */
    @Override
    public MyFreemarkerMethodGenerator initTableObject(String tableName, String argCN) {

        if (StringUtils.isBlank(tableName)) {
            throw new ServiceException(-1, "要生成的文件不能为空");
        }
        if (StringUtils.isBlank(argCN)) {
            throw new ServiceException(-1, "要生成的文件的中文注释不能为空");
        }

        String argName = StringFormatUtils.remoteTablePre(tableName) ;
        String argObj = StringFormatUtils.upperFirst(argName);
        myFreemarkerLocalEnv = new MyFreemarkerLocalEnv(argName, argObj, argCN);
        //生成新的xml和准备mybatis对象
        dbObjectGenerator.initDBGenerator(new Dom4JUtils(tableName, argObj), new XmlEnv(myFreemarkerGlobalEnv));
        return this;
    }

    /**
     * 创建全部文件
     */
    @Override
    public void createAll() {

        this.createDBObject();
        this.createDB();
        this.createCenter();
        this.createServer();
        this.getDubboConfig();
    }

    /**
     * 创建所有中心层
     */
    @Override
    public void createCenter() {

        this.createDBObject();
        this._createFacade();
        this._createDomain();
        this._createRepository();
    }

    /**
     * 创建所有接口层
     */
    @Override
    public void createServer() {

        this.createDBObject();
        this._createIntegration();
        this._createWeb();
    }

    /**
     * 创建数据库层
     */
    @Override
    public void createDB() {

        String path = System.class.getResource("/" + myFreemarkerLocalEnv.getArgObj() + ".properties").getPath();
        myMapperCodeGenerator.genarateSqlMapper(path);
    }

    /**it
     * 得到dubbo配置
     */
    @Override
    public void getDubboConfig() {

        String dubboConfig = "    <!-- "
                + myFreemarkerLocalEnv.getArgCN() + " -->\n"
                + "    <dubbo:service interface=\"com." + GlobalEnv.getCompany() + "." + myFreemarkerGlobalEnv.getItemCenter() + ".common.facade.interfaces." + myFreemarkerLocalEnv.getArgObj() + "FacadeService\"\n"
                + "                   ref=\"" + myFreemarkerLocalEnv.getArgName() + "FacadeServiceImpl\"\n"
                + "                   timeout=\"20000\"/>\n"
                + "    <bean id=\"" + myFreemarkerLocalEnv.getArgName() + "FacadeServiceImpl\" class=\"com." + GlobalEnv.getCompany() + "." + myFreemarkerGlobalEnv.getItemCenter() + ".biz.service.impl." + myFreemarkerLocalEnv.getArgObj() + "FacadeServiceImpl\"/>";
        System.out.println(dubboConfig);
    }

    /**
     * 创建条件对象
     */
    @Override
    public void initConditions() {

        createDBObject();
        beforeCreateFile(myFreemarkerGlobalEnv.getConditionObjectFilePath() + myFreemarkerLocalEnv.getConditionObjectFileName(), myFreemarkerGlobalEnv.getConditionObjectTemplatePath());
    }

    /**
     * 创建文件之前校验
     * @param targetPositionPath 目标文件路径
     * @param templateFilePath 模板文件路径
     */
    private void beforeCreateFile(String targetPositionPath, String templateFilePath){

        if (StringUtils.isBlank(targetPositionPath)){
            throw new ServiceException(-1, "目标文件路径不能为空");
        }
        if (StringUtils.isBlank(templateFilePath)){
            throw new ServiceException(-1, "模板路径不能为空");
        }
        //开启备份
        if (backup){
            this.recordHistory(targetPositionPath);
        }
        //开始打印
        if (outPrint) {
            this.printMessage(targetPositionPath, 1);
        }
        this.createFile(targetPositionPath, templateFilePath);
        //结束打印
        if (outPrint) {
            this.printMessage(targetPositionPath, 2);
        }
    }

    /**
     * 创建文件
     * @param targetPositionPath 目标文件路径
     * @param templateFilePath 模板文件路径
     */
    private void createFile(String targetPositionPath, String templateFilePath) {
        
        Writer out;
        Configuration configuration = new Configuration();
        try {
            //设置模板基础路径
            configuration.setDirectoryForTemplateLoading(new File(myFreemarkerGlobalEnv.getTemplatePath()));
            //创建数据模型
            Map<String, Object> dataMap = new HashMap<>(10);
            dataMap.put("argName", myFreemarkerLocalEnv.getArgName());
            dataMap.put("argObj", myFreemarkerLocalEnv.getArgObj());
            dataMap.put("argCN", myFreemarkerLocalEnv.getArgCN());
            dataMap.put("argCenter", myFreemarkerGlobalEnv.getItemCenter());
            dataMap.put("argItem", myFreemarkerGlobalEnv.getItem());
            dataMap.put("dateTime", new Date());
            dataMap.put("mustConditions", myFreemarkerConditions.getMustConditions());
            dataMap.put("searchConditions", myFreemarkerConditions.getSearchConditions());
            dataMap.put("dateBetweenConditions", myFreemarkerConditions.getDateBetweenConditions());
            dataMap.put("likeConditions", myFreemarkerConditions.getLikeConditions());
            dataMap.put("dbObjects", dbObjectGenerator.getDBObjects());
            dataMap.put("primaryObject", dbObjectGenerator.getPrimaryObject());
            dataMap.put("author", GlobalEnv.getAuthor());
            dataMap.put("company", GlobalEnv.getCompany());
            //加载模版文件
            Template template = configuration.getTemplate(templateFilePath);
            //生成文件
            File docFile = new File(targetPositionPath);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            template.process(dataMap, out);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印消息
     * @param path 路径
     * @param type 1.开始 2.结束
     * @return
     */
    private void printMessage(String path, Integer type){

        StringBuilder sb = new StringBuilder("---");

        String tempPath = path.substring(0, path.lastIndexOf("."));
        path = tempPath.substring(tempPath.lastIndexOf("\\") + 1);

        sb.append(path);

        if (type == 1){
            sb.append("开始创建---");
        }else if (type == 2) {
            sb.append("创建成功---");
        }
        System.out.println(sb.toString());
    }

    /**
     * 创建数据库对象
     */
    private void createDBObject() {

        this.dbObjectGenerator.process();
    }

    //----------------------集合方法

    /**
     * 创建integration
     */
    private void _createIntegration(){

        this.createParam();
        this.createSearchParam();
        this.createResult();
        this.createIntegration();
        this.createIntegrationImpl();
    }

    /**
     * 创建web
     */
    private void _createWeb(){

        this.createRequest();
        this.createSearchRequest();
        this.createResponse();
        this.createWebServer();
    }

    /**
     * 创建facade
     */
    private void _createFacade(){

        this.createSearchBean();
        this.createBean();
        this.createFacade();
        this.createFacadeImpl();
    }

    /**
     * 创建domain
     */
    private void _createDomain(){

        this.createDomain();
        this.createDomainImpl();
    }

    /**
     * 创建repository
     */
    private void _createRepository(){

        this.createSearch();
        this.createRepository();
        this.createRepositoryImpl();
    }

    //----------------------单方法
    /**
     * 创建param
     */
    private void createParam(){

        beforeCreateFile(myFreemarkerGlobalEnv.getParamFilePath() + myFreemarkerLocalEnv.getParamFileName(), myFreemarkerGlobalEnv.getParamTemplatePath());
    }

    /**
     * 创建paramSearch
     */
    private void createSearchParam(){

        beforeCreateFile(myFreemarkerGlobalEnv.getSearchParamFilePath() + myFreemarkerLocalEnv.getSearchParamFileName(), myFreemarkerGlobalEnv.getSearchParamTemplatePath());
    }

    /**
     * 创建result
     */
    private void createResult(){

        beforeCreateFile(myFreemarkerGlobalEnv.getResultFilePath() + myFreemarkerLocalEnv.getResultFileName(), myFreemarkerGlobalEnv.getResultTemplatePath());
    }

    /**
     * 创建integration
     */
    private void createIntegration(){

        beforeCreateFile(myFreemarkerGlobalEnv.getIntegrationFilePath() + myFreemarkerLocalEnv.getIntegrationFileName(), myFreemarkerGlobalEnv.getIntegrationTemplatePath());
    }

    /**
     * 创建integrationImpl
     */
    private void createIntegrationImpl(){

        beforeCreateFile(myFreemarkerGlobalEnv.getIntegrationImplFilePath() + myFreemarkerLocalEnv.getIntegrationImplFileName(), myFreemarkerGlobalEnv.getIntegrationImplTemplatePath());
    }

    /**
     * 创建request
     */
    private void createRequest(){

        beforeCreateFile(myFreemarkerGlobalEnv.getRequestFilePath() + myFreemarkerLocalEnv.getRequestFileName(), myFreemarkerGlobalEnv.getRequestTemplatePath());
    }

    /**
     * 创建requestSearch
     */
    private void createSearchRequest(){

        beforeCreateFile(myFreemarkerGlobalEnv.getSearchRequestFilePath() + myFreemarkerLocalEnv.getSearchRequestFileName(), myFreemarkerGlobalEnv.getSearchRequestTemplatePath());
    }

    /**
     * 创建response
     */
    private void createResponse(){

        beforeCreateFile(myFreemarkerGlobalEnv.getResponseFilePath() + myFreemarkerLocalEnv.getResponseFileName(), myFreemarkerGlobalEnv.getResponseTemplatePath());
    }

    /**
     * 创建webServer
     */
    private void createWebServer(){

        beforeCreateFile(myFreemarkerGlobalEnv.getWebFilePath() + myFreemarkerLocalEnv.getWebFileName(), myFreemarkerGlobalEnv.getWebTemplatePath());
    }

    /**
     * 创建bean
     */
    private void createBean() {

        beforeCreateFile(myFreemarkerGlobalEnv.getBeanFilePath() + myFreemarkerLocalEnv.getBeanFileName(), myFreemarkerGlobalEnv.getBeanTemplatePath());
    }

    /**
     * 创建SearchBean
     */
    private void createSearchBean() {

        beforeCreateFile(myFreemarkerGlobalEnv.getSearchBeanFilePath() + myFreemarkerLocalEnv.getSearchBeanFileName(), myFreemarkerGlobalEnv.getSearchBeanTemplatePath());
    }

    /**
     * 创建Search
     */
    private void createSearch() {

        beforeCreateFile(myFreemarkerGlobalEnv.getSearchFilePath() + myFreemarkerLocalEnv.getSearchFileName(), myFreemarkerGlobalEnv.getSearchTemplatePath());
    }

    /**
     * 创建domain层
     */
    private void createDomain() {

        beforeCreateFile(myFreemarkerGlobalEnv.getDomainFilePath() + myFreemarkerLocalEnv.getDomainFileName(), myFreemarkerGlobalEnv.getDomainTemplatePath());
    }

    /**
     * 创建domainImpl层
     */
    private void createDomainImpl() {

        beforeCreateFile(myFreemarkerGlobalEnv.getDomainImplFilePath() + myFreemarkerLocalEnv.getDomainImplFileName(), myFreemarkerGlobalEnv.getDomainImplTemplatePath());
    }

    /**
     * 创建repository层
     */
    private void createRepository() {

        beforeCreateFile(myFreemarkerGlobalEnv.getRepositoryFilePath() + myFreemarkerLocalEnv.getRepositoryFileName(), myFreemarkerGlobalEnv.getRepositoryTemplatePath());
    }

    /**
     * 创建repositoryImpl层
     */
    private void createRepositoryImpl() {

        beforeCreateFile(myFreemarkerGlobalEnv.getRepositoryImplFilePath() + myFreemarkerLocalEnv.getRepositoryImplFileName(), myFreemarkerGlobalEnv.getRepositoryImplTemplatePath());
    }

    /**
     * 创建facade层
     */
    private void createFacade() {

        beforeCreateFile(myFreemarkerGlobalEnv.getFacadeFilePath() + myFreemarkerLocalEnv.getFacadeFileName(), myFreemarkerGlobalEnv.getFacadeTemplatePath());
    }

    /**
     * 创建facadeImpl层
     */
    private void createFacadeImpl() {

        beforeCreateFile(myFreemarkerGlobalEnv.getFacadeImplFilePath() + myFreemarkerLocalEnv.getFacadeImplFileName(), myFreemarkerGlobalEnv.getFacadeImplTemplatePath());
    }

    //----------------------扩展功能，回滚

    /**
     * 记录文件历史 todo 多于十个文件夹删除最旧的
     * @param filePath 文件路径
     */
    private void recordHistory(String filePath) {

        File oldFile = new File(filePath);
        //要备份的文件不存在跳过
        if (!oldFile.exists()){
            return;
        }
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);

        File dictionary = new File(myFreemarkerGlobalEnv.getCachePath() + "\\" + myFreemarkerGlobalEnv.getNowDate());
        if (!dictionary.exists() && !dictionary.mkdir()) {
            throw new ServiceException(-1, "创建历史备份文件夹失败");
        }
        //新文件writer
        String newFilePath = (myFreemarkerGlobalEnv.getCachePath() + "\\" + myFreemarkerGlobalEnv.getNowDate() + "\\" + fileName).replace(".java", ".txt");
        //拷贝文件
        this.copyFile(filePath, newFilePath);

        File versionFile;
        File historyFile;
        try {
            //版本记录
            versionFile = new File(myFreemarkerGlobalEnv.getCachePath() + "\\version.txt");
            if (!versionFile.exists() && !versionFile.createNewFile()) {
                throw new ServiceException(-1, "创建要保存的版本历史文件失败");
            }
            //版本文件路径记录
            historyFile = new File(myFreemarkerGlobalEnv.getCachePath() + "\\history.txt");
            if (!historyFile.exists() && !historyFile.createNewFile()) {
                throw new ServiceException(-1, "创建要保存的历史记录文件失败");
            }
        }catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(-1, "版本文件存储失败");
        }

        //history
        try (BufferedWriter  historyBufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(historyFile, true)))) {

            if (!historyCheck) {
                historyBufferWriter.append("\n").append("-------")
                        .append("\n")
                        .append("version:").append(myFreemarkerGlobalEnv.getNowDate());
                historyCheck = true;
            }

            historyBufferWriter.append("\n")
                    .append("fileName:").append(fileName).append("\n")
                    .append("oldFile:").append(filePath).append("\n")
                    .append("newFile:").append(newFilePath);

            historyBufferWriter.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //version
        try (BufferedWriter versionBufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(versionFile, true)))) {

            if (!versionCheck) {
                versionBufferWriter.append("version:").append(myFreemarkerGlobalEnv.getNowDate()).append("\n");
                versionCheck = true;
                versionBufferWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(-1, "历史记录存储失败");
        }
    }

    /**
     * 拷贝文件
     * @param oldFilePath 原文件
     * @param newFilePath 新文件
     */
    private void copyFile(String oldFilePath, String newFilePath){

        //旧文件reader
        File oldFile = new File(oldFilePath);
        if (!oldFile.exists()) {
            throw new ServiceException(-1, "要缓存的文件不存在!");
        }

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        boolean flag = true;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile)));
            File newFile = new File(newFilePath);
            if (!newFile.exists() && !newFile.createNewFile()) {
                throw new ServiceException(-1, "创建新文件失败");
            }
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
            String br ;
            while ((br = bufferedReader.readLine())!= null) {

                if (!flag){
                    bufferedWriter.append("\n");
                }
                flag = false;
                bufferedWriter.append(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 回滚
     */
    @Override
    public void rollBack(){

        rollBack("");
    }

    /**
     * 回滚
     * @param version 版本号
     */
    @Override
    public void rollBack(String version) {

        //要回滚的版本
        version = this.getVersion(version);

        //历史文件路径
        List<String> histories = this.getHistories(version);

        for(int i = 1; i < histories.size(); i += 3){
            String oldFilePath = histories.get(i+1).substring("oldFile:".length());
            String newFilePath = histories.get(i+2).substring("newFile:".length());
            this.copyFile(newFilePath, oldFilePath);
        }
        System.out.println("回滚到" + version + "版本成功");
    }

    /**
     * 根据版本号得到对应历史记录
     * @param version 版本号
     * @return
     */
    private List<String> getHistories(String version){

        File historyFile = new File(myFreemarkerGlobalEnv.getCachePath() + "\\history.txt");
        if (!historyFile.exists()) {
            throw new ServiceException(-1, "找不到要回滚的文件记录!");
        }

        List<String> histories = new ArrayList<>();
        try (BufferedReader historyBufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(historyFile)))){
            boolean recordFlag = false;
            String textLine;
            while ((textLine = historyBufferReader.readLine())!= null) {
                if (!recordFlag && textLine.equals(version)){
                    recordFlag = true;
                }
                if (recordFlag && textLine.startsWith("version") && !textLine.equals(version)){
                    recordFlag = false;
                }
                if (recordFlag && !"-------".equals(textLine)){
                    histories.add(textLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (CollectionUtils.isEmpty(histories)){
            throw new ServiceException(-1, "找不到对应的历史记录!");
        }

        return histories;
    }

    /**
     * 得到历史版本
     * @param version 版本号
     * @return
     */
    private String getVersion(String version){

        //所有的历史版本
        List<String> versions = new ArrayList<>();
        File versionFile = new File(myFreemarkerGlobalEnv.getCachePath() + "\\version.txt");
        if (!versionFile.exists()) {
            throw new ServiceException(-1, "没有历史版本,无法进行回滚");
        }
        try (BufferedReader versionBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(versionFile)))) {
            String textLine;
            while ((textLine = versionBufferedReader.readLine())!= null) {
                versions.add(textLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (CollectionUtils.isEmpty(versions)){
            throw new ServiceException(-1, "没有历史版本,无法进行回滚");
        }

        if (StringUtils.isBlank(version)) {
            version = versions.get(versions.size() - 1);
        }else{
            version = "version:" + version;
            int versionIndex = versions.indexOf(version);
            if (versionIndex == -1){
                throw new ServiceException(-1, "找不到对应的版本,请查看version文件校验版本");
            }
            version = versions.get(versionIndex);
        }

        return version;
    }
}
