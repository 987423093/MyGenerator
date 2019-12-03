package com.dingdang.autocenter.biz.share.autogenerator.utils;

import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author zhoutao
 * @date 2019/10/22
 * 本地路径工具
 */
public class FilePathTool {

    /**
     * 获得默认环境配置
     * @return
     */
    public static FilePath getDefaultFilePath() {

        //基础路径
        String basePath = getBasePath();
        //包路径
        String packageFilePath = getPackagePath(basePath);
        //资源文件路径
        String resourceFilePath = getResourcePath(basePath);
        //中心层
        String itemCenter = getItemCenter(basePath);
        //特征短语
        String item = getItem(basePath);
        return new FilePath(basePath, packageFilePath, resourceFilePath, itemCenter, item);
    }

    /**
     * 自定义文件路径
     * @param basePath
     * @param itemCenter
     * @param item
     * @return
     */
    public static FilePath getCustomFilePath(String basePath, String itemCenter, String item){

        //基础路径
        basePath = basePath + "\\" + GlobalEnv.getCompanyX() + itemCenter;
        String packageFilePath = getPackagePath(basePath);
        String resourceFilePath = getResourcePath(basePath);

        return new FilePath(basePath, packageFilePath, resourceFilePath, itemCenter, item);
    }

    /**
     * 基础路径
     * @return
     */
    private static String getBasePath() {

        File file = new File(".");
        String filePath;
        //基础路径
        try {
            filePath = file.getCanonicalPath();
        }catch (IOException e){
            throw new ServiceException(-1, "基础路径查询失败！");
        }
        return filePath;
    }

    /**
     * 包路径
     * @param basePath
     * @return
     */
    private static String getPackagePath(String basePath){

        String packageFilePath;

        File beforeFile = new File(FilePathTool.class.getResource("").getPath());
        String beforePath = beforeFile.getPath();
        int tailIndex = beforePath.indexOf("autogenerator");
        packageFilePath = beforePath.substring(0, tailIndex);
        packageFilePath = packageFilePath.substring(basePath.length());
        packageFilePath = packageFilePath.replace("target\\classes", "src\\main\\java");
        return packageFilePath.substring(0, packageFilePath.length() - 1);
    }

    /**
     * 资源文件路径
     * @param basePath
     * @return
     */
    private static String getResourcePath(String basePath){

        String resourceFilePath;

        File beforeFile = new File(FilePathTool.class.getResource("").getPath());
        String beforePath = beforeFile.getPath();
        //资源文件路径
        int resourceIndex = beforePath.indexOf("target\\classes");
        resourceFilePath = beforePath.substring(0, resourceIndex);
        resourceFilePath = resourceFilePath + "src\\main\\resources\\templates";
        resourceFilePath = resourceFilePath.substring(basePath.length());
        return resourceFilePath;
    }

    /**
     * 中心层路径
     * @param basePath
     * @return
     */
    private static String getItemCenter(String basePath){

        String itemCenter = "";

        String[] basePaths = basePath.split("\\\\");
        for (String path : basePaths) {
            if (path.startsWith(GlobalEnv.getCompanyX())){
                itemCenter = path;
            }
        }
        if ("".equals(itemCenter)){
            throw new ServiceException(-1, "找不到对应的环境，请使用手动环境配置");
        }

        if (itemCenter.startsWith(GlobalEnv.getCompanyX())){
            itemCenter = itemCenter.substring(GlobalEnv.getCompanyX().length());
        }
        return itemCenter;
    }

    /**
     * 中心层特征短语
     * @param basePath
     * @return
     */
    private static String getItem(String basePath){

        String item = getItemCenter(basePath);
        if (item.endsWith("center")){
            item = item.substring(0, item.length() - "center".length());
        }

        if (StringUtils.isBlank(item)) {
            throw new ServiceException(-1, "找不到特征短语");
        }
        return item;
    }
}
