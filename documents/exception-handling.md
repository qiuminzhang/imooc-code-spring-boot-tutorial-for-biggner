## Exception Handling
This document is based on exception handling section of [this imooc cource](https://www.imooc.com/learn/810).

### Problem
The section demonstrates by a problem that get a baby's age and determine. If the girl is younger than 10, return 
"Elementary school", if the girl's age is between 10 and 16, it should return "Midele school". 
These results should be posted on postman instead of IDE console. 

### Workflow

- Set uniform result format.

     If we get the correct result, we'll get a json contains the result data shown on postman, 
     but if we get an error due to codes or network issue, the postman would show a different json. But no matter what result 
     we get, we want them in the same format. So it's **normal** to crate a Result class and unify the result format for a better
     further use.  
     
     If we do so, the post request(addABaby method), for example, will return a Result object instead of a Baby object.
  

- Create ResultUtil(工具类) 

    As addABaby method, a lot of redundant setCode() and setMessage() methods exist, so we can create a *Util Class* called ResultClass to 
    integrate these method and save a lot of work.
    
    The class contains static success() and error() functions to deal with various conditions. 
    See addABaby2() for detail.

- Solve the problem

    The problem has a determination in terms of age. We put this logic into *BabyService* ~getAge(). The teachers metions
    that all logic should be put into Service, instead of controller. 
    

- Unify exception handling

    After creating judgement in ~getAge(), here comes a problem. If we have more conditions, it would be complicated to 
    do as above. So that's why we introduce unifying exception handling. 
    
    We just *throw Exceptions* for the banned conditions like (age < 10) and (age >10 && age <16) and pass the messages. 
    
    Now if we test the error case, the postman would show a error-kind json, but we still want to make the json has the same
    format as correct ones'. 
    
- Catch and get the message in the Exceptions
    
    To deal with the **problem** above, we catch the Exception, get the message from it, 
    then create *ExceptionHandler* to encapsulate the message with code. But we want each kind of exception has its own
    code, but the Exception only takes message when we get error. 
    
- Customize Exception class (BabyException)

    We customize *BabyException* class which extends RuntimeException to make it takes both code and message. 
    **Note** that Spring only rolls back when RuntimeException occurs, but RuntimeException extends Exception, so it's not a problem.
    
    In the ExceptionHandler, determine that if an exception is a BabyException(A new babyException would be created when thrown), 也就是
    说可以根据不同的错误自定义不同的异常类。Then pass the code and msg to the ResultUtil's method.
    
- 统一维护code和message

    Here comes another problem, code couldn't automatically match the message which is unsafe.
    So we create *ResultEnum*.enum to match code and message. Then modify the BabyException args and apply enums. 
    

 
    
     