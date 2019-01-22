package com.doubleriver.springbootgeneral.controller;

import com.doubleriver.springbootgeneral.bean.Person;
import com.doubleriver.springbootgeneral.exception.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/***
 * @Author ronye
 * @Created 2018/11/16 - 9:42 PM
 */

@RestController
//使用thymeleaf时与@RestController冲突？
public class HelloController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user){
        logger.trace("/hello" + "user=" + user);
        if(user.equals ( "aa" )){
            throw new UserNotExistException ();
        }
        return "Hello Spring Boot Initializr";
    }


    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/query")
    @ResponseBody
    public List<Map<String, Object>> queryDatabase(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList ( "select * from department" );
        return list;
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        logger.trace("/success");
        Person person = new Person();
        person.setAge(18);
        person.setName("zhangsan");
        person.setNational("Chinese");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010,0,1);
        person.setBirthday(calendar.getTime());
        map.put("person",person);
        map.put("list",Arrays.asList("001","002","003"));

        return "success";
    }

}