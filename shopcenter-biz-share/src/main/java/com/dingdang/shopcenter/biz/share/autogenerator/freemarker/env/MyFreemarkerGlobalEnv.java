package com.dingdang.shopcenter.biz.share.autogenerator.freemarker.env;

import com.dingdang.commons.utils.DateUtils;
import com.dingdang.shopcenter.biz.share.autogenerator.utils.FilePath;
import com.dingdang.shopcenter.biz.share.autogenerator.utils.GlobalEnv;

import java.util.Date;

/**
 * @author zhoutao
 * @date 2019/10/14
 * @description 模板环境变量配置类
 */
public class MyFreemarkerGlobalEnv {

    /**
     * 中心层
     */
    private String itemCenter;

    /**
     * 中心层短语
     */
    private String item;

    /**
     * 基础路径
     */
    private String basePath;

    /**
     * 包路径
     */
    private String packagePath;

    /**
     * 资源文件路径
     */
    private String resourcePath;

    /**
     * 基础模板文件夹位置
     */
    private String templatePath;

    /**
     * domain接口层代码生成的路径
     */
    private String domainFilePath;

    /**
     * domain接口层引用的模板
     */
    private String domainTemplatePath;

    /**
     * domainImpl实现层代码生成的路径
     */
    private String domainImplFilePath;

    /**
     * domainImpl实现层引用的模板
     */
    private String domainImplTemplatePath;

    /**
     * repository接口层代码生成的路径
     */
    private String repositoryFilePath;

    /**
     * repository接口层引用的模板
     */
    private String repositoryTemplatePath;

    /**
     * repositoryImpl实现层代码生成的路径
     */
    private String repositoryImplFilePath;

    /**
     * repositoryImpl实现层引用的模板
     */
    private String repositoryImplTemplatePath;

    /**
     * facade接口层代码生成的路径
     */
    private String facadeFilePath;

    /**
     * facade接口层引用的模板
     */
    private String facadeTemplatePath;

    /**
     * facadeImpl实现层代码生成的路径
     */
    private String facadeImplFilePath;

    /**
     * facadeImpl实现层引用的模板
     */
    private String facadeImplTemplatePath;

    /**
     * bean代码生成的路径
     */
    private String beanFilePath;

    /**
     * bean引用的模板
     */
    private String beanTemplatePath;

    /**
     * SearchBean代码生成的路径
     */
    private String searchBeanFilePath;

    /**
     * SearchBean引用的模板
     */
    private String searchBeanTemplatePath;

    /**
     * search代码生成的路径
     */
    private String searchFilePath;

    /**
     * search引用的模板
     */
    private String searchTemplatePath;

    /**
     * param代码生成的路径
     */
    private String paramFilePath;

    /**
     * param引用的模板
     */
    private String paramTemplatePath;

    /**
     * searchParamSearch代码生成的路径
     */
    private String searchParamFilePath;

    /**
     * searchParam引用的模板
     */
    private String searchParamTemplatePath;

    /**
     * result代码生成的路径
     */
    private String resultFilePath;

    /**
     * result引用的模板
     */
    private String resultTemplatePath;

    /**
     * integration代码生成的路径
     */
    private String integrationFilePath;

    /**
     * integration引用的模板
     */
    private String integrationTemplatePath;

    /**
     * integrationImpl代码生成的路径
     */
    private String integrationImplFilePath;

    /**
     * integrationImpl引用的模板
     */
    private String integrationImplTemplatePath;

    /**
     * request代码生成的路径
     */
    private String requestFilePath;

    /**
     * request引用的模板
     */
    private String requestTemplatePath;

    /**
     * searchRequest代码生成的路径
     */
    private String searchRequestFilePath;

    /**
     * searchRequest引用的模板
     */
    private String searchRequestTemplatePath;
    
    /**
     * response代码生成的路径
     */
    private String responseFilePath;

    /**
     * response引用的模板
     */
    private String responseTemplatePath;

    /**
     * web代码生成的路径
     */
    private String webFilePath;

    /**
     * web引用的模板
     */
    private String webTemplatePath;
    
    /**
     * 条件对象代码生成路径
     */
    private String conditionObjectFilePath;

    /**
     * 条件对象引用的模板
     */
    private String conditionObjectTemplatePath;
    
    /**
     * 缓存文件位置
     */
    private String cachePath;

    /**
     * 当前时间
     */
    private String nowDate = DateUtils.getDate(new Date(), "_yyyyMMdd_HH_mm_ss");

    /**
     * 构造
     */
    private MyFreemarkerGlobalEnv(){

    }

    /**
     * 构造
     */
    public MyFreemarkerGlobalEnv(FilePath filePath) {

        String basePath = filePath.getBasePath();
        String itemCenter = filePath.getItemCenter();
        String item = filePath.getItem();
        String packagePath = filePath.getPackagePath();
        String resourcePath = filePath.getResourcePath();

        //全局路径
        this.item = item;
        this.itemCenter = itemCenter;
        this.packagePath = packagePath;
        this.resourcePath = resourcePath;
        this.basePath = basePath;

        //其他环境
        this.templatePath = basePath + resourcePath;
        this.conditionObjectFilePath = basePath + packagePath + "\\autogenerator\\freemarker\\condition";
        this.conditionObjectTemplatePath = "/ConditionObject.ftl";
        this.cachePath = basePath + packagePath + "\\autogenerator\\freemarker\\cache";

        //中心层模板路径
        this.domainFilePath = basePath + "\\" + itemCenter + "-biz-" + item + "\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\" + item + "\\domainService";
        this.domainTemplatePath = "/Domain.ftl";
        this.domainImplFilePath = basePath + "\\" + itemCenter + "-biz-" + item + "\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\" + item + "\\domainService\\impl";
        this.domainImplTemplatePath = "/DomainImpl.ftl";
        this.repositoryFilePath = basePath + "\\" + itemCenter + "-biz-" + item + "\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\" + item + "\\repository";
        this.repositoryTemplatePath = "/Repository.ftl";
        this.repositoryImplFilePath = basePath + "\\" + itemCenter + "-biz-" + item + "\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\" + item + "\\repository\\impl";
        this.repositoryImplTemplatePath = "/RepositoryImpl.ftl";
        this.facadeFilePath = basePath + "\\" + itemCenter + "-common-facade\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\common\\facade\\interfaces";
        this.facadeTemplatePath = "/Facade.ftl";
        this.facadeImplFilePath = basePath + "\\" + itemCenter + "-biz-service-impl\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\service\\impl";
        this.facadeImplTemplatePath = "/FacadeImpl.ftl";
        this.beanFilePath = basePath + "\\" + itemCenter + "-common-facade\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\common\\facade\\beans";
        this.beanTemplatePath = "/Bean.ftl";
        this.searchBeanFilePath = basePath + "\\" + itemCenter + "-common-facade\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\common\\facade\\beans";
        this.searchBeanTemplatePath = "/SearchBean.ftl";
        this.searchFilePath = basePath + "\\" + itemCenter + "-biz-" + item + "\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\" + item + "\\condition";
        this.searchTemplatePath = "/Search.ftl";

        //接口层模板路径

        //integration层
        this.paramFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\integration\\param";
        this.paramTemplatePath = "/Param.ftl";
        this.searchParamFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\integration\\param";
        this.searchParamTemplatePath = "/SearchParam.ftl";
        this.resultFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\integration\\result";
        this.resultTemplatePath = "/Result.ftl";
        this.integrationFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\integration";
        this.integrationTemplatePath = "/Integration.ftl";
        this.integrationImplFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\integration\\impl";
        this.integrationImplTemplatePath = "/IntegrationImpl.ftl";

        //web层
        this.requestFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\web\\request";
        this.requestTemplatePath = "/Request.ftl";
        this.searchRequestFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\web\\request";
        this.searchRequestTemplatePath = "/SearchRequest.ftl";
        this.responseFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\web\\response";
        this.responseTemplatePath = "/Response.ftl";
        this.webFilePath = basePath + "\\" + itemCenter + "-biz-share\\src\\main\\java\\com\\" + GlobalEnv.getCompany() + "\\" + itemCenter + "\\biz\\share\\autogenerator\\code\\server\\web";
        this.webTemplatePath = "/Web.ftl";
    }

    public String getItemCenter() {
        return itemCenter;
    }

    public String getItem() {
        return item;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public String getDomainFilePath() {
        return domainFilePath;
    }

    public String getDomainTemplatePath() {
        return domainTemplatePath;
    }

    public String getDomainImplFilePath() {
        return domainImplFilePath;
    }

    public String getDomainImplTemplatePath() {
        return domainImplTemplatePath;
    }

    public String getRepositoryFilePath() {
        return repositoryFilePath;
    }

    public String getRepositoryTemplatePath() {
        return repositoryTemplatePath;
    }

    public String getRepositoryImplFilePath() {
        return repositoryImplFilePath;
    }

    public String getRepositoryImplTemplatePath() {
        return repositoryImplTemplatePath;
    }

    public String getFacadeFilePath() {
        return facadeFilePath;
    }

    public String getFacadeTemplatePath() {
        return facadeTemplatePath;
    }

    public String getFacadeImplFilePath() {
        return facadeImplFilePath;
    }

    public String getFacadeImplTemplatePath() {
        return facadeImplTemplatePath;
    }

    public String getBeanFilePath() {
        return beanFilePath;
    }

    public String getBeanTemplatePath() {
        return beanTemplatePath;
    }

    public String getSearchBeanFilePath() {
        return searchBeanFilePath;
    }

    public String getSearchBeanTemplatePath() {
        return searchBeanTemplatePath;
    }

    public String getSearchFilePath() {
        return searchFilePath;
    }

    public String getSearchTemplatePath() {
        return searchTemplatePath;
    }

    public String getConditionObjectFilePath() {
        return conditionObjectFilePath;
    }

    public String getConditionObjectTemplatePath() {
        return conditionObjectTemplatePath;
    }

    public String getCachePath() {
        return cachePath;
    }

    public String getNowDate() {
        return nowDate;
    }

    public String getParamFilePath() {
        return paramFilePath;
    }

    public String getParamTemplatePath() {
        return paramTemplatePath;
    }

    public String getSearchParamFilePath() {
        return searchParamFilePath;
    }

    public String getSearchParamTemplatePath() {
        return searchParamTemplatePath;
    }

    public String getResultFilePath() {
        return resultFilePath;
    }

    public String getResultTemplatePath() {
        return resultTemplatePath;
    }

    public String getIntegrationFilePath() {
        return integrationFilePath;
    }

    public String getIntegrationTemplatePath() {
        return integrationTemplatePath;
    }

    public String getIntegrationImplFilePath() {
        return integrationImplFilePath;
    }

    public String getIntegrationImplTemplatePath() {
        return integrationImplTemplatePath;
    }

    public String getRequestFilePath() {
        return requestFilePath;
    }

    public String getRequestTemplatePath() {
        return requestTemplatePath;
    }

    public String getSearchRequestFilePath() {
        return searchRequestFilePath;
    }

    public String getSearchRequestTemplatePath() {
        return searchRequestTemplatePath;
    }

    public String getResponseFilePath() {
        return responseFilePath;
    }

    public String getResponseTemplatePath() {
        return responseTemplatePath;
    }

    public String getWebFilePath() {
        return webFilePath;
    }

    public String getWebTemplatePath() {
        return webTemplatePath;
    }
}
