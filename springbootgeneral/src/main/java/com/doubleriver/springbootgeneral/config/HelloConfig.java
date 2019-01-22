package com.doubleriver.springbootgeneral.config;

import com.doubleriver.springbootgeneral.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ronye
 * @Created 2018/11/19 - 10:56 PM
 */


@Configuration
public class HelloConfig {
    //将方法的返回值添加到容器中，容器中这个组件的id就是方法名
    @Bean
    public HelloService helloService02(){
            return new HelloService();
    }
}
