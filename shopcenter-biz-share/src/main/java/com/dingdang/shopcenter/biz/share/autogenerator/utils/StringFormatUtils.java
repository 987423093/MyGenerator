package com.dingdang.shopcenter.biz.share.autogenerator.utils;

import com.dingdang.commons.exceptions.ServiceException;

/**
 * @author zhoutao
 * @date 2019/11/28
 */
public class StringFormatUtils {

    /**
     * L-U转换
     * @param argName 参数名称
     * @return
     */
    public static String upperFirst(String argName) {

        if (argName == null) {
            throw new ServiceException(-1, "参数错误");
        }
        return argName.substring(0, 1).toUpperCase() + argName.substring(1);
    }

    /**
     * 移除表前缀
     * @param tableName 表名称
     * @return
     */
    public static String remoteTablePre(String tableName) {

        if (tableName.startsWith("t_")) {
            tableName = tableName.substring(2);
        }

        int length = tableName.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
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
