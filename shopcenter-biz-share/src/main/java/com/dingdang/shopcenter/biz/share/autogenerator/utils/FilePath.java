package com.dingdang.shopcenter.biz.share.autogenerator.utils;

import lombok.Data;

/**
 * @author zhoutao
 * @date 2019/10/22
 * @description 本地路径保存对象
 */
@Data
public class FilePath {

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
     * 中心层
     */
    private String itemCenter;

    /**
     * 项目
     */
    private String item;

    /**
     * 构造方法
     * @param basePath
     * @param packagePath
     * @param resourcePath
     * @param itemCenter
     * @param item
     */
    public FilePath(String basePath, String packagePath, String resourcePath, String itemCenter, String item) {
        this.basePath = basePath;
        this.packagePath = packagePath;
        this.resourcePath = resourcePath;
        this.itemCenter = itemCenter;
        this.item = item;
    }
}
