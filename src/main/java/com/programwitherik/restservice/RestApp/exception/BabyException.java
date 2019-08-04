package com.programwitherik.restservice.RestApp.exception;

import com.programwitherik.restservice.RestApp.enums.ResultEnum;

/** Besides the error message, this costomized exception class makes
 *  exception return code as well */

// RuntimeException extends Exception. But Spring only rolls back when runtimeException occurs.
public class BabyException extends RuntimeException{

    private Integer code;

    public BabyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

//    public BabyException(Integer code, String message) {
//        super(message);
//        this.code = code;
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
