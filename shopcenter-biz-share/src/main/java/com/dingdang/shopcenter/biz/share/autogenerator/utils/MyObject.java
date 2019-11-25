package com.dingdang.shopcenter.biz.share.autogenerator.utils;

import lombok.Data;

/**
 * @author zhoutao
 * @date 2019/10/16
 * @description 自定义变量
 */
@Data
public class MyObject {

    /**
     * 参数英文名称
     */
    private String ename;

    /**
     * 类型
     */
    private String type;

    /**
     * 参数中文名称
     */
    private String cname;

    /**
     * 参数中文名称短语去掉枚举
     */
    private String sname;

    /**
     * 原名称 列表时候使用
     */
    private String oname;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getType() { return type; }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public MyObject(String ename, String type, String cname, String sname) {
        this.ename = ename;
        this.type = type;
        this.cname = cname;
        this.sname = sname;
    }


    public MyObject(String ename, String type, String cname) {
        this.ename = ename;
        this.type = type;
        this.cname = cname;
        if (ename.endsWith("s")){
            this.oname = ename.substring(0, ename.length() - 1);
        }else if (ename.endsWith("List")){
            this.oname = ename.substring(0, ename.length() - 4);
        }else {
            this.oname = ename;
        }
    }
}
