package com.programwitherik.restservice.RestApp.Domain;

/**
 * http请求返回的最外层对象（结果），用来统一结果的格式，
 * no matter correct result or error, they have the same format
 */
public class Result<T> {

    /** error code, 0 means correct result */
    private int code;

    /** notification */
    private String msg;

    /** specific info */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
