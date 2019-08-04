package com.programwitherik.restservice.RestApp.utils;

import com.programwitherik.restservice.RestApp.Domain.Result;
/** utils叫工具类。这里的ResultUtil帮忙解决重复代码，因为又可能会做很多异常处理。*/
public class ResultUtil {
    /**
     * Result when the response is correct
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * Successful case like Delete doesn't return object like Add and Post, so this
     * method deals with this kind.
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * Result when error occurs
     * @param code customized error code
     * @param msg customized error message
     * @return
     */
    public static Result error(int code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
