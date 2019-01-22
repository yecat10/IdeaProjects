package com.doubleriver.springbootgeneral;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ImportResource("classpath:beans.xml")
// @importResource必须作用在配置类@Configuration，SpringBoot不建议通过ImportResource来处理，而是通过配置类的方法来加载处理
@SpringBootApplication
public class SpringbootgeneralApplication {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {

        SpringApplication.run(SpringbootgeneralApplication.class, args);
    }
}
