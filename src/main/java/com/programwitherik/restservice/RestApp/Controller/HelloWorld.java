package com.programwitherik.restservice.RestApp.Controller;

import com.programwitherik.restservice.RestApp.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // RestController = Controller + ResponseBody . Process http request
@ResponseBody
@RequestMapping(value = "/hello") // Map a class/method to an url
public class HelloWorld {
    @Value("${height}")
    private String height;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

    //
    @Autowired
    private Person person;

    // if no POST/GET are assigned to method, both post/get will request web successfully,
    // but this is not recomanded because of its safety issue.
    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET) // 可以用一个叫postman的东东测试// POST请求
    // RequestMapping可以给整个class或者某个method指定一个url
    // If you want to reach this method, you can concatenate the class url and method
    // url together, that is /hello/say.
    public String say(@PathVariable("id") int id){ // when type url, if type ..../say/23, it'll return id: 23
        return "id: " + id;
    }

//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value= "/say") // short of RequestMapping of GET 推荐
    public String sayID(@RequestParam(value = "id", required=false, defaultValue = "0") int myId){ // return the id that in the parameter format
        // default the id as 0, and the 0 must be a string
        return "myId: " + myId;

    }




    public int height() {
        return person.getHeight();
//        return "index";
    }
}
