package com.programwitherik.restservice.RestApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component // 将这个class融入到spring容器中
public class HttpAspect {
    // import org.slf4j.Logger;
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     *  .. in babyList(..) means no matter what parameters in this method, 都会被拦截
     *  log() is executed before the methods in the @Before get executed
     */
    // *拦截所有方法
    @Before("execution(public * com.programwitherik.restservice.RestApp.Controller.BabyController.*(..))")
//    babyList只拦截一种babyList()这一种方法
//    @Before("execution(public * com.programwitherik.restservice.RestApp.Controller.BabyController.babyList(..))")
    public void log(){
        logger.info("111111");
//        System.out.println(1111);
    }

    @After("execution(public * com.programwitherik.restservice.RestApp.Controller.BabyController.*(..))")
    public void logAfter(){
        logger.info("222222");
//        System.out.println(2222);
    }

    //-----------------------short alternative of above-------------------------
    @Pointcut("execution(public * com.programwitherik.restservice.RestApp.Controller.BabyController.addABaby(..))")
    public void logAlt(){
    }

    /**
     * Record HTTP request
     */
    @Before("logAlt()")
    public void doBefore(JoinPoint joinPoint){
        // Acquire url
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        logger.info("url={}", request.getRequestURL());

        // method : post?get?put?
        logger.info("method = {}", request.getMethod());

        // ip
        logger.info("ip = {}", request.getRemoteAddr());

        // class method 类方法
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // parameters
        logger.info("parameters = {}", joinPoint.getArgs());
    }

    @After("logAlt()")
    public void doAfter(){
        System.out.println(4444);
    }

    @AfterReturning(returning = "object", pointcut = "logAlt()")
    public void doAfterReturning(Object object) { // it might return multiple stuff, but they all Objects
        logger.info("response = {}", object.toString());
//        有可能报错，当object出错的时候，会返回一个null的object，会报nullpointer的错误
    }
}
