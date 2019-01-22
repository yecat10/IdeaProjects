package com.doubleriver.springbootgeneral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author ronye
 * @Created 2018/12/17 - 12:47 AM
 */
@Controller
public class LoginController {


/*  @GetMapping
    @DeleteMapping
    @PutMapping
    @RequestMapping(value="/user/login", method = RequestMethod.POST)
*/
    @PostMapping(value = "/user/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            // 防止表单重复提交，使用重定向
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
