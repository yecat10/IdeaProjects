package com.doubleriver.springbootgeneral.exception;

/**
 * @Author ronye
 * @Created 2018/12/29 - 2:50 AM
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException ( ) {
        super("用户名不存在");
    }
}
