package com.lefu.model.beans;

/**
 * 对外统一返回bean
 * 本地提交代码
 * 从github模拟其他开发人员提交代码
 * Created by shuyan.qi on 2017/4/18.
 */
public class ReturnBean<T> {
    private String code;
    private String msg;
    private T data;

    public ReturnBean() {

    }

    public ReturnBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ReturnBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
