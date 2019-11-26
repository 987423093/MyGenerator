package com.dingdang.shopcenter.common.utils;

import com.dingdang.commons.basic.PagerListBean;
import com.dingdang.commons.enums.StateEnum;
import com.dingdang.commons.exceptions.ServiceException;
import com.dingdang.commons.utils.BeanUtils;
import com.dingdang.shopcenter.common.utils.enums.ArgTypeEnum;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhoutao
 * @note 为数据库默认值提供的工具类
 * @date 2019/9/30
 */
public class Optionals {

    /**
     * 保证不为空
     * @param obj
     * @return
     */
    public static Object orNull(Object obj){

        return obj == null ? -1L : obj;
    }

    /**
     * String为空时默认值
     * @param obj
     * @return
     */
    public static String orDefault(String obj){

        return (obj == null ? "" : obj);
    }

    /**
     * BigDecimal为空时默认值
     * @param obj
     * @return
     */
    public static BigDecimal orDefault(BigDecimal obj){

        return (obj == null ? BigDecimal.ZERO : obj);
    }

    /**
     * Integer为空时默认值
     * @param obj
     * @return
     */
    public static Integer orDefault(Integer obj){

        return (obj == null ? 0 : obj);
    }

    /**
     * 设置插入数据库默认值
     * @param obj
     */
    public static void setDefaultInsert(Object obj){

        setDefaultLong(obj, "creator");
        setDefaultLong(obj, "modifier");
        setDefaultDate(obj, "createDate");
        setDefaultDate(obj, "modifyDate");
        setDefaultChar(obj, "state");
    }

    /**
     * 设置修改数据库默认值
     * @param obj
     */
    public static void setDefaultModify(Object obj){

        setDefaultDate(obj, "modifyDate");
        setDefaultLong(obj, "modifier");
    }

    /**
     * 设置获得详情默认值
     * @param obj
     * @return
     */
    public static Object getDefaultDetail(Object obj){

        return obj == null ? null : getDefaultChar(obj, "state");
    }

    /**
     * 转换bean
     * @param obj
     * @param clazz
     * @return
     */
    public static Object transformBean(Object obj, Class clazz){

        try {
            Object beanObj = clazz.newInstance();
            if (obj != null) {
                BeanUtils.copyProperties2(beanObj, obj);
                return beanObj;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ServiceException(-1, "bean转换失败");
        }
        return null;
    }

    /**
     * 设置默认排序
     * @param obj
     * @param pagerListBean
     */
    public static void setDefaultOrderBy(Object obj, PagerListBean pagerListBean) {

        Class clazz = obj.getClass();
        try {
            Field argField = clazz.getDeclaredField("orderByClause");
            argField.setAccessible(true);
            argField.set(obj, "CreateDate Desc Limit " + pagerListBean.getOffset() + "," + pagerListBean.getLimit());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            //e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------
    //---------------------------私有方法------------------------------------
    //---------------------------------------------------------------------

    /**
     * 设置长整形默认值
     * @param obj
     * @param argName
     */
    private static void setDefaultLong(Object obj, String argName){

        setDefault(obj, argName, ArgTypeEnum.LONG);
    }

    /**
     * 设置时间类型默认值
     * @param obj
     * @param argName
     */
    private static void setDefaultDate(Object obj, String argName){

        setDefault(obj, argName, ArgTypeEnum.DATE);
    }

    /**
     * 设置字符型默认值
     * @param obj
     * @param argName
     */
    private static void setDefaultChar(Object obj, String argName){

        setDefault(obj, argName, ArgTypeEnum.CHAR);
    }

    /**
     * 设置默认值
     * @param obj
     * @param argName
     * @param argTypeEnum
     */
    private static void setDefault(Object obj, String argName, ArgTypeEnum argTypeEnum){

        Class clazz = obj.getClass();
        try {
            Field argField = clazz.getDeclaredField(argName);
            argField.setAccessible(true);
            Object argValue = null;
            if (ArgTypeEnum.LONG == argTypeEnum){
                argValue = argField.get(obj);
                argValue = argValue == null ? -1L : argValue;
            }else if (ArgTypeEnum.DATE == argTypeEnum){
                argValue = new Date();
            }else if (ArgTypeEnum.CHAR == argTypeEnum){
                argValue = StateEnum.USE.getCode();
            }
            if (argValue != null) {
                argField.set(obj, argValue);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            //e.printStackTrace();
        }
    }

    /**
     * 获得字符型值
     * @param obj
     * @param argName
     * @return
     */
    private static Object getDefaultChar(Object obj, String argName){

        return getDefault(obj, argName, ArgTypeEnum.CHAR);
    }

    /**
     * 得到默认值
     * @param obj
     * @param argName
     * @param argTypeEnum
     * @return
     */
    private static Object getDefault(Object obj, String argName, ArgTypeEnum argTypeEnum){

        Class clazz = obj.getClass();
        try {
            Field argField = clazz.getDeclaredField(argName);
            argField.setAccessible(true);
            if (ArgTypeEnum.CHAR == argTypeEnum){
                Object argValue = argField.get(obj);
                if (StateEnum.USE.getCode().equals(argValue)) {
                    return obj;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            //e.printStackTrace();
        }
        return null;
    }
}
