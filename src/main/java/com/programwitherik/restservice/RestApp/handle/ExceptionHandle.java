package com.programwitherik.restservice.RestApp.handle;

import com.programwitherik.restservice.RestApp.Domain.Result;
import com.programwitherik.restservice.RestApp.exception.BabyException;
import com.programwitherik.restservice.RestApp.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    // 对于其他异常，不能只返回-1然后输出unknown error，要不然不知道啥错误。
    // 所以可以用logger来记录异常
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    // 这里捕获的是Exception这个class
    @ExceptionHandler(value= Exception.class)

    // ResponseBody enables writing data to the body of the response object
    // Because it will return browser a json, but no RestController before the class,
    // so we need ResponseBody here to help with returning to the browser.
    @ResponseBody
    public Result handel(Exception e){
        if(e instanceof BabyException){
            BabyException babyE = (BabyException)e;
            return ResultUtil.error(babyE.getCode(), babyE.getMessage());
        }else{
            // print exception
            logger.error("System Error {}", e);
            return ResultUtil.error(-1, "Unknown error");
        }
    }

}
