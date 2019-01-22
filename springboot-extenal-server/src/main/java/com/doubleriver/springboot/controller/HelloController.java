package com.doubleriver.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ronye
 * @Created 2019/1/1 - 2:11 AM
 */

@Controller
public class HelloController {
    @GetMapping("/ext")
    public String hello(Model model){
        System.out.println ("ext..................process............");
        model.addAttribute ( "msg","External tomcat server is used...." );
        return "success";
    }
}
