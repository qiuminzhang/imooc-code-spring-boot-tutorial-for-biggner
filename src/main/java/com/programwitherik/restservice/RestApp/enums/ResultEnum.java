package com.programwitherik.restservice.RestApp.enums;

public enum ResultEnum {

    UNKONN_ERROR(-1, "Unkown Error"),
    SUCCESS(0, "success"),
    PRIMARY_SCHOOL(100, "Elementary School"),
    MIDDLE_SCHOOL(101, "Middle School"),
    ;
    private int code;

    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
