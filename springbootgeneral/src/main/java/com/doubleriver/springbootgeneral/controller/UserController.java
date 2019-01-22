package com.doubleriver.springbootgeneral.controller;

import com.doubleriver.springbootgeneral.bean.User;
import com.doubleriver.springbootgeneral.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ronye
 * @Created 2019/1/12 - 10:03 PM
 * 使用spring jpa来进行数据管理
 */

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/u/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findById ( id ).get ();
        return user;
    }

    @GetMapping("/u")
    public User addUser(User user){
        User saver = userRepository.save ( user );
        return saver;
    }
}
