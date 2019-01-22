package com.doubleriver.springbootgeneral.controller;

import com.doubleriver.springbootgeneral.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ronye
 * @Created 2018/12/29 - 4:03 AM
 */

@ControllerAdvice
public class MyExceptionHandler {

    /*没有自适应效果，浏览器返回html，客户端返回json*/
//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    public Map<String, Object> handleException(Exception e){
//
//        Map<String,Object> map = new HashMap<> (  );
//        map.put ( "code","user.notexist" );
//        map.put ( "message",e.getMessage () );
//
//        return map;
//
//    }
    /*转发到/error请求进行自适应处理，但不能带出定制数据 code*/
//    @ExceptionHandler(UserNotExistException.class)
//    public String handleException (Exception e, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<> ();
//        //传入我们自己定制的错误状态码，否则不会进入错误定制页面
//        request.setAttribute ( "javax.servlet.error.status_code",400 );//BasicErrorController
//        map.put ( "code", "user.notexist" );
//        map.put ( "message", "用户出错了");
//        request.setAttribute ( "ext" ,map);
//        return "forward:/error";
//    }

    /*将我们的定制数据携带出去*/
    @ExceptionHandler(UserNotExistException.class)
    public String handleException (Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<> ();
        //传入我们自己定制的错误状态码，否则不会进入错误定制页面
        request.setAttribute ( "javax.servlet.error.status_code", 500 );//BasicErrorController
        map.put ( "code", "user.notexist" );
        map.put ( "message", "用户出错了");
        request.setAttribute ( "ext" ,map);
        return "forward:/error";
    }
}
