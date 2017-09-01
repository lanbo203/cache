package com.example.demo.common.model;

/**
 * Created by yexin on 2017/9/1.
 */
public class TransMsg {

    private String key;

    private Object pojo;

    private Class<?> cls;

    private String method;

    private Object params;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getPojo() {
        return pojo;
    }

    public void setPojo(Object pojo) {
        this.pojo = pojo;
    }


    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public TransMsg() {
    }


    public TransMsg(String key, Object pojo, Class<?> cls, String method, Object params) {
        this.key = key;
        this.pojo = pojo;
        this.cls = cls;
        this.method = method;
        this.params = params;
    }

    public TransMsg(String key, Object pojo) {
        this.key = key;
        this.pojo = pojo;
    }

    @Override
    public String toString() {
        return "TransMsg{" +
                "key='" + key + '\'' +
                ", pojo=" + pojo +
                ", cls=" + cls +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}
