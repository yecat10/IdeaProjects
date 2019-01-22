package com.doubleriver.springbootgeneral.repository;

import com.doubleriver.springbootgeneral.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ronye
 * @Created 2019/1/12 - 9:58 PM
 */
//继承JpaRepository来实现对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {

}
