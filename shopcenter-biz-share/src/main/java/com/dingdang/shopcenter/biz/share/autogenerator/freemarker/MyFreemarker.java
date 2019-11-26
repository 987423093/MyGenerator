package com.dingdang.shopcenter.biz.share.autogenerator.freemarker;

import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.CollectionUtils;
import com.dingdang.commons.utils.StringUtils;
import com.dingdang.shopcenter.biz.share.autogenerator.auto.AutoGenerator;
import com.dingdang.shopcenter.biz.share.autogenerator.auto.IAutoMethodGenerator;
import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.env.MyFreemarkerEnv;
import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.mybatis.DBObjectGenerator;
import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.xml.Dom4JUtils;
import com.dingdang.shopcenter.biz.share.autogenerator.freemarker.xml.XmlEnv;
import com.dingdang.shopcenter.biz.share.autogenerator.utils.GlobalEnv;
import com.dingdang.shopcenter.biz.share.autogenerator.utils.MyObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;

/**
 * @author zhoutao
 * @date 2019/10/14
 * 核心工具类
 */
public class MyFreemarker extends AutoGenerator implements IAutoMethodGenerator {

    /**
     * 对象名称
     */
    private String argName;

    /**
     * 对象类型
     */
    private String argObj;

    /**
     * 对象中文
     */
    private String argCN;

    /**
     * 接口层名称
     */
    private String projectName;

    /**
     * 接口层包名称
     */
    private String packageName;

    /**
     * 必传条件
     */
    private List<MyObject> mustConditions;

    /**
     * 查询条件
     */
    private List<MyObject> searchConditions;

    /**
     * 时间范围条件
     */
    private List<MyObject> dateBetweenConditions;

    /**
     * 模糊查询条件
     */
    private List<MyObject> likeConditions;

    /**
     * 路径环境配置
     */
    private MyFreemarkerEnv myFreemarkerEnv;

    /**
     * 数据库对象生成器
     */
    private DBObjectGenerator dbObjectGenerator = new DBObjectGenerator();

    /**
     * 版本号是否已经记录
     */
    private boolean versionCheck = false;

    /**
     * 历史是否已经记录
     */
    private boolean historyCheck = false;

    /**
     * 默认不开启备份
     */
    private boolean backup = false;

    /**
     * 默认打印开启
     */
    private boolean outPrint = true;

    /**
     * 构造方法
     */
    public MyFreemarker(MyFreemarkerEnv myFreemarkerEnv) {

        super(myFreemarkerEnv);
        this.setMyFreemarkerEnv(myFreemarkerEnv);
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
     * 是否开启打印
     * @param outPrint 是否打印 true/false
     */
    @Override
    public void setOutPrint(boolean outPrint){

        this.outPrint = outPrint;
    }

    /**
     * 设置整体环境
     * @param myFreemarkerEnv 环境对象
     */
    private void setMyFreemarkerEnv(MyFreemarkerEnv myFreemarkerEnv) {

        if (myFreemarkerEnv == null) {
            throw new ServiceException(-1, "找不到环境配置");
        }
        if (StringUtils.isBlank(myFreemarkerEnv.getItem())) {
            throw new ServiceException(-1, "中心层特征短语不能为空");
        }
        if (StringUtils.isBlank(myFreemarkerEnv.getItemCenter())) {
            throw new ServiceException(-1, "中心层名称不能为空");
        }

        myFreemarkerEnv.initEnv();
        this.myFreemarkerEnv = myFreemarkerEnv;
    }

    /**
     * 设置表
     * @param tableName 表名称
     * @param argCN 参数中文名称
     */
    @Override
    public MyFreemarker initTableObject(String tableName, String argCN) {

        if (StringUtils.isBlank(tableName)) {
            throw new ServiceException(-1, "要生成的文件不能为空");
        }
        if (StringUtils.isBlank(argCN)) {
            throw new ServiceException(-1, "要生成的文件的中文注释不能为空");
        }

        this.argName = this.getArgName(tableName);
        this.argCN = argCN;
        this.argObj = argNameToMustObj(argName);

        //生成新的xml和准备mybatis对象
        dbObjectGenerator.initDBGenerator(new Dom4JUtils(tableName, argObj), new XmlEnv(myFreemarkerEnv));
        return this;
    }

    /**
     * 设置接口层参数
     * @param projectName
     * @param packageName
     * @return
     */
    @Override
    public MyFreemarker initWebArgs(String projectName, String packageName){

        this.projectName = projectName;
        this.packageName = packageName;
        return this;
    }

    /**
     * 创建全部文件
     */
    @Override
    public void createAll() {

        this.createDBObject();
        this.createCenter();
        this.createServer();
        this.getDubboConfig();
    }

    /**
     * 创建所有中心层
     */
    @Override
    public void createCenter() {

        this.createBeans();
        this.createClazz();
    }

    /**
     * 创建所有接口层
     */
    @Override
    public void createServer() {

        this.createParam();
        this.createParamSearch();
        this.createResult();
        this.createIntegration();
        this.createIntegrationImpl();
    }

    /**
     * 创建数据库对象
     */
    @Override
    public void createDBObject() {

        if (StringUtils.isBlank(this.argName) || StringUtils.isBlank(this.argCN)){
            throw new ServiceException(-1, "argName and argCN not be null !");
        }
        this.dbObjectGenerator.process();
    }

    /**
     * 创建对象们 1.searchBean 2.bean 3.search
     */
    @Override
    public void createBeans() {

        this.createBean();
        this.createSearchBean();
        this.createSearch();
    }

    /**
     * 创建增删改查的业务类
     */
    @Override
    public void createClazz() {

        this.createDomain();
        this.createDomainImpl();
        this.createFacade();
        this.createFacadeImpl();
        this.createRepository();
        this.createRepositoryImpl();
    }

    /**
     * 创建param
     */
    public void createParam(){

        String filePath = myFreemarkerEnv.getParamFilePath() + "\\" + argObj + "Param.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getParamTemplatePath(), argName, argCN);
    }

    /**
     * 创建paramSearch
     */
    public void createParamSearch(){

        String filePath = myFreemarkerEnv.getSearchParamFilePath() + "\\" + argObj + "SearchParam.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getSearchParamTemplatePath(), argName, argCN);
    }

    /**
     * 创建result
     */
    public void createResult(){

        String filePath = myFreemarkerEnv.getResultFilePath() + "\\" + argObj + "Result.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getResultTemplatePath(), argName, argCN);
    }

    /**
     * 创建integration
     */
    public void createIntegration(){

        String filePath = myFreemarkerEnv.getIntegrationFilePath() + "\\" + argObj + "IntegrationService.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getIntegrationTemplatePath(), argName, argCN);
    }

    /**
     * 创建integrationImpl
     */
    public void createIntegrationImpl(){

        String filePath = myFreemarkerEnv.getIntegrationImplFilePath() + "\\" + argObj + "IntegrationServiceImpl.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getIntegrationImplTemplatePath(), argName, argCN);
    }

    /**
     * 得到dubbo配置
     */
    @Override
    public void getDubboConfig() {

        String dubboConfig = "    <!-- "
                + this.argCN + " -->\n"
                + "    <dubbo:service interface=\"com." + GlobalEnv.getCompany() + "." + this.myFreemarkerEnv.getItemCenter() + ".common.facade.interfaces." + this.argObj + "FacadeService\"\n"
                + "                   ref=\"" + this.argName + "FacadeServiceImpl\"\n"
                + "                   timeout=\"20000\"/>\n"
                + "    <bean id=\"" + this.argName + "FacadeServiceImpl\" class=\"com." + GlobalEnv.getCompany() + "." + this.myFreemarkerEnv.getItemCenter() + ".biz.service.impl." + this.argObj + "FacadeServiceImpl\"/>";
        System.out.println(dubboConfig);
    }

    /**
     * 添加必填条件
     * @param mustCondition 必填条件
     */
    @Override
    public void addMustCondition(MyObject mustCondition) {

        if (this.mustConditions == null) {
            this.mustConditions = new ArrayList<>();
        }
        this.mustConditions.add(mustCondition);
    }

    /**
     * 添加查询条件
     * @param searchCondition 查询条件
     */
    @Override
    public void addSearchCondition(MyObject searchCondition) {

        if (this.searchConditions == null) {
            this.searchConditions = new ArrayList<>();
        }
        this.searchConditions.add(searchCondition);
    }

    /**
     * 添加时间范围条件
     * @param dateBetweenCondition 时间条件
     */
    @Override
    public void addDateBetweenCondition(MyObject dateBetweenCondition) {

        if (this.dateBetweenConditions == null){
            this.dateBetweenConditions = new ArrayList<>();
        }
        this.dateBetweenConditions.add(dateBetweenCondition);
    }

    /**
     * 添加模糊查询条件
     * @param likeCondition 模糊查询条件
     */
    @Override
    public void addLikeCondition(MyObject likeCondition) {

        if (this.likeConditions == null) {
            this.likeConditions = new ArrayList<>();
        }
        this.likeConditions.add(likeCondition);
    }

    /**
     * 创建bean
     */
    @Override
    public void createBean() {

        String filePath = myFreemarkerEnv.getBeanFilePath() + "\\" + argObj + "Bean.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getBeanTemplatePath(), argName, argCN);
    }

    /**
     * 创建SearchBean
     */
    @Override
    public void createSearchBean() {

        String filePath = myFreemarkerEnv.getSearchBeanFilePath() + "\\" + argObj + "SearchBean.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getSearchBeanTemplatePath(), argName, argCN);
    }

    /**
     * 创建Search
     */
    @Override
    public void createSearch() {

        String filePath = myFreemarkerEnv.getSearchFilePath() + "\\" + argObj + "Search.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getSearchTemplatePath(), argName, argCN);
    }

    /**
     * 创建domain层
     */
    @Override
    public void createDomain() {

        String filePath = myFreemarkerEnv.getDomainFilePath() + "\\" + argObj + "DomainService.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getDomainTemplatePath(), argName, argCN);
    }

    /**
     * 创建domainImpl层
     */
    @Override
    public void createDomainImpl() {

        String filePath = myFreemarkerEnv.getDomainImplFilePath() + "\\" + argObj + "DomainServiceImpl.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getDomainImplTemplatePath(), argName, argCN);
    }

    /**
     * 创建repository层
     */
    @Override
    public void createRepository() {

        String filePath = myFreemarkerEnv.getRepositoryFilePath() + "\\" + argObj + "Repository.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getRepositoryTemplatePath(), argName, argCN);
    }

    /**
     * 创建repositoryImpl层
     */
    @Override
    public void createRepositoryImpl() {

        String filePath = myFreemarkerEnv.getRepositoryImplFilePath() + "\\" + argObj + "RepositoryImpl.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getRepositoryImplTemplatePath(), argName, argCN);
    }

    /**
     * 创建facade层
     */
    @Override
    public void createFacade() {

        String filePath = myFreemarkerEnv.getFacadeFilePath() + "\\" + argObj + "FacadeService.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getFacadeTemplatePath(), argName, argCN);
    }

    /**
     * 创建facadeImpl层
     */
    @Override
    public void createFacadeImpl() {

        String filePath = myFreemarkerEnv.getFacadeImplFilePath() + "\\" + argObj + "FacadeServiceImpl.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getFacadeImplTemplatePath(), argName, argCN);
    }

    /**
     * 创建条件对象
     */
    @Override
    public void initConditions() {

        createDBObject();
        String filePath = myFreemarkerEnv.getConditionObjectFilePath() + "\\" + argObj + "Conditions.java";
        beforeCreateFile(filePath, myFreemarkerEnv.getConditionObjectTemplatePath(), argName, argCN);
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

        File historyFile = new File(myFreemarkerEnv.getCachePath() + "\\history.txt");
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
        File versionFile = new File(myFreemarkerEnv.getCachePath() + "\\version.txt");
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

    /**
     * 创建文件之前校验
     * @param targetPositionPath 目标文件路径
     * @param templateFilePath 模板文件路径
     * @param argName 参数名称
     * @param argCN 参数中文名称
     */
    private void beforeCreateFile(String targetPositionPath, String templateFilePath, String argName, String argCN){

        if (StringUtils.isBlank(targetPositionPath)){
            throw new ServiceException(-1, "目标文件路径不能为空");
        }
        if (StringUtils.isBlank(templateFilePath)){
            throw new ServiceException(-1, "模板路径不能为空");
        }
        if (StringUtils.isBlank(argName)){
            throw new ServiceException(-1, "参数名称不能为空");
        }
        if (StringUtils.isBlank(argCN)){
            throw new ServiceException(-1, "参数中文不能为空");
        }

        //开启备份
        if (backup){
            this.recordHistory(targetPositionPath);
        }
        //开始打印
        if (outPrint) {
            this.printMessage(templateFilePath, 1);
        }
        this.createFile(targetPositionPath, templateFilePath, argName, argCN);
        //结束打印
        if (outPrint) {
            this.printMessage(templateFilePath, 2);
        }
    }

    /**
     * 创建文件
     * @param targetPositionPath 目标文件路径
     * @param templateFilePath 模板文件路径
     * @param argName 参数名称
     * @param argCN 参数中文名称
     */
    private void createFile(String targetPositionPath, String templateFilePath, String argName, String argCN) {
        
        Writer out;
        Configuration configuration = new Configuration();
        try {
            //设置模板基础路径
            configuration.setDirectoryForTemplateLoading(new File(myFreemarkerEnv.getTemplatePath()));
            //创建数据模型
            Map<String, Object> dataMap = new HashMap<>(10);
            dataMap.put("argName", argName);
            dataMap.put("argCN", argCN);
            dataMap.put("argCenter", myFreemarkerEnv.getItemCenter());
            dataMap.put("argItem", myFreemarkerEnv.getItem());
            dataMap.put("dateTime", new Date());
            dataMap.put("mustConditions", mustConditions);
            dataMap.put("searchConditions", searchConditions);
            dataMap.put("dateBetweenConditions", dateBetweenConditions);
            dataMap.put("likeConditions", likeConditions);
            dataMap.put("dbObjects", dbObjectGenerator.getDBObjects());
            dataMap.put("primaryObject", dbObjectGenerator.getPrimaryObject());
            dataMap.put("author", GlobalEnv.getAuthor());
            dataMap.put("company", GlobalEnv.getCompany());
            //接口层
            dataMap.put("projectName", projectName);
            dataMap.put("packageName", packageName);
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
     * L-U转换
     * @param argName 参数名称
     * @return
     */
    private static String argNameToMustObj(String argName) {

        if (argName == null) {
            throw new ServiceException(-1, "参数错误");
        }
        return argName.substring(0, 1).toUpperCase() + argName.substring(1);
    }

    /**
     * 打印消息
     * @param path 路径
     * @param type 1.开始 2.结束
     * @return
     */
    private void printMessage(String path, Integer type){

        StringBuilder sb = new StringBuilder("---");
        if (path.contains("FacadeImpl")){
            sb.append("facadeImpl");
        }else if (path.contains("Facade")){
            sb.append("facade");
        }else if (path.contains("RepositoryImpl")){
            sb.append("repositoryImpl");
        }else if (path.contains("Repository")){
            sb.append("repository");
        }else if (path.contains("DomainImpl")){
            sb.append("domainImpl");
        }else if (path.contains("Domain")){
            sb.append("domain");
        }else if (path.contains("SearchBean")){
            sb.append("searchBean");
        }else if (path.contains("SearchParam")) {
            sb.append("searchParam");
        }else if (path.contains("Search")){
            sb.append("search");
        }else if (path.contains("Bean")){
            sb.append("bean");
        }else if (path.contains("Condition")){
            sb.append("condition");
        }else if (path.contains("Param")) {
            sb.append("param");
        }else if (path.contains("Result")) {
            sb.append("result");
        }else if (path.contains("IntegrationImpl")) {
            sb.append("integrationImpl");
        }else if (path.contains("Integration")) {
            sb.append("integration");
        }else {
             sb.append("undefined");
        }
        if (type == 1){
            sb.append("开始创建---");
        }else if (type == 2) {
            sb.append("创建成功---");
        }

        System.out.println(sb.toString());
    }

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

        File dictionary = new File(myFreemarkerEnv.getCachePath() + "\\" + myFreemarkerEnv.getNowDate());
        if (!dictionary.exists() && !dictionary.mkdir()) {
                throw new ServiceException(-1, "创建历史备份文件夹失败");
        }
        //新文件writer
        String newFilePath = (myFreemarkerEnv.getCachePath() + "\\" + myFreemarkerEnv.getNowDate() + "\\" + fileName).replace(".java", ".txt");
        //拷贝文件
        this.copyFile(filePath, newFilePath);

        File versionFile;
        File historyFile;
        try {
            //版本记录
            versionFile = new File(myFreemarkerEnv.getCachePath() + "\\version.txt");
            if (!versionFile.exists() && !versionFile.createNewFile()) {
                throw new ServiceException(-1, "创建要保存的版本历史文件失败");
            }
            //版本文件路径记录
            historyFile = new File(myFreemarkerEnv.getCachePath() + "\\history.txt");
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
                        .append("version:").append(myFreemarkerEnv.getNowDate());
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
                versionBufferWriter.append("version:").append(myFreemarkerEnv.getNowDate()).append("\n");
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
     * 根据表名称得到参数名称
     * @param tableName 表名称
     * @return
     */
    private String getArgName(String tableName) {

        if (tableName.startsWith("t_")) {
            tableName = tableName.substring(2);
        }
        int i = 0;
        int length = tableName.length();
        StringBuilder sb = new StringBuilder();
        for (; i < length; i++) {
            char c = tableName.charAt(i);
            if ('_' == c && (i + 1) < length) {
                char c2 = tableName.charAt(i + 1);
                sb.append((char) (c2 - 'a' + 'A'));
                i += 2;
            }
            sb.append(tableName.charAt(i));
        }
        return sb.toString();
    }
}
