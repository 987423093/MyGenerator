package com.dingdang.autocenter.biz.share.autogenerator.freemarker.env;


/**
 * @author zhoutao
 * @date 2019/11/28
 */
public class MyFreemarkerLocalEnv {

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
     * domain接口层代码生成的路径
     */
    private String domainFileName;
    
    /**
     * domainImpl实现层代码生成的路径
     */
    private String domainImplFileName;
    
    /**
     * repository接口层代码生成的路径
     */
    private String repositoryFileName;
    
    /**
     * repositoryImpl实现层代码生成的路径
     */
    private String repositoryImplFileName;
    
    /**
     * facade接口层代码生成的路径
     */
    private String facadeFileName;

    /**
     * facadeImpl实现层代码生成的路径
     */
    private String facadeImplFileName;

    /**
     * bean代码生成的路径
     */
    private String beanFileName;

    /**
     * SearchBean代码生成的路径
     */
    private String searchBeanFileName;

    /**
     * search代码生成的路径
     */
    private String searchFileName;

    /**
     * param代码生成的路径
     */
    private String paramFileName;

    /**
     * searchParamSearch代码生成的路径
     */
    private String searchParamFileName;

    /**
     * result代码生成的路径
     */
    private String resultFileName;

    /**
     * integration代码生成的路径
     */
    private String integrationFileName;

    /**
     * integrationImpl代码生成的路径
     */
    private String integrationImplFileName;

    /**
     * request代码生成的路径
     */
    private String requestFileName;

    /**
     * searchRequest代码生成的路径
     */
    private String searchRequestFileName;

    /**
     * response代码生成的路径
     */
    private String responseFileName;

    /**
     * web代码生成的路径
     */
    private String webFileName;

    /**
     * 条件对象代码生成路径
     */
    private String conditionObjectFileName;

    /**
     * 构造
     */
    public MyFreemarkerLocalEnv(String argName, String argObj, String argCN) {

        this.argName = argName;
        this.argObj = argObj;
        this.argCN = argCN;

        String prePath = "\\" + argObj;

        this.conditionObjectFileName = prePath + "Conditions.java";
        //中心层模板路径
        this.domainFileName = prePath + "DomainService.java";
        this.domainImplFileName = prePath + "DomainServiceImpl.java";
        this.repositoryFileName = prePath + "Repository.java";
        this.repositoryImplFileName = prePath + "RepositoryImpl.java";
        this.facadeFileName = prePath + "FacadeService.java";
        this.facadeImplFileName = prePath + "FacadeServiceImpl.java";
        this.beanFileName = prePath + "Bean.java";
        this.searchBeanFileName = prePath + "SearchBean.java";
        this.searchFileName = prePath + "Search.java";

        //接口层模板路径

        //integration层
        this.paramFileName = prePath + "Param.java";
        this.searchParamFileName = prePath + "SearchParam.java";
        this.resultFileName = prePath + "Result.java";
        this.integrationFileName = prePath + "IntegrationService.java";
        this.integrationImplFileName = prePath + "IntegrationServiceImpl.java";

        //web层
        this.requestFileName = prePath + "Request.java";
        this.searchRequestFileName = prePath + "SearchRequest.java";
        this.responseFileName = prePath + "Response.java";
        this.webFileName = prePath + "WebServer.java";
    }

    public String getDomainFileName() {
        return domainFileName;
    }

    public String getDomainImplFileName() {
        return domainImplFileName;
    }

    public String getRepositoryFileName() {
        return repositoryFileName;
    }

    public String getRepositoryImplFileName() {
        return repositoryImplFileName;
    }

    public String getFacadeFileName() {
        return facadeFileName;
    }

    public String getFacadeImplFileName() {
        return facadeImplFileName;
    }

    public String getBeanFileName() {
        return beanFileName;
    }

    public String getSearchBeanFileName() {
        return searchBeanFileName;
    }

    public String getSearchFileName() {
        return searchFileName;
    }

    public String getParamFileName() {
        return paramFileName;
    }

    public String getSearchParamFileName() {
        return searchParamFileName;
    }

    public String getResultFileName() {
        return resultFileName;
    }

    public String getIntegrationFileName() {
        return integrationFileName;
    }

    public String getIntegrationImplFileName() {
        return integrationImplFileName;
    }

    public String getRequestFileName() {
        return requestFileName;
    }

    public String getSearchRequestFileName() {
        return searchRequestFileName;
    }

    public String getResponseFileName() {
        return responseFileName;
    }

    public String getWebFileName() {
        return webFileName;
    }

    public String getConditionObjectFileName() {
        return conditionObjectFileName;
    }

    public String getArgName() {
        return argName;
    }

    public String getArgObj() {
        return argObj;
    }

    public String getArgCN() {
        return argCN;
    }
}
