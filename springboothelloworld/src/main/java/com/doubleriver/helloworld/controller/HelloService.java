package com.doubleriver.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ronye
 * @Created 2018/11/16 - 2:52 AM
 */
@Controller
public class HelloService {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
      return "Hello World,Spring Boot!";
    }
}
