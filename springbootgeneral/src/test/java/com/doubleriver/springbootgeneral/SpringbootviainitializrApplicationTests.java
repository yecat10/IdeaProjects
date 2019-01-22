package com.doubleriver.springbootgeneral;

import com.doubleriver.springbootgeneral.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootviainitializrApplicationTests {

    Logger logger = LoggerFactory.getLogger ( this.getClass () );

//  配置文件通过注入
    @Autowired
    Person person;
    @Test
    public void contextLoads() {
        System.out.println(person);

    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabase(){
        //Springboot2.0 + 默认使用 hikari数据源 class com.zaxxer.hikari.HikariDataSource
        Connection connection = null;
        try  {
            connection = dataSource.getConnection ();
            logger.trace ( "项目配置使用的数据源: " + dataSource.getClass () );
            logger.trace ( connection.toString () );
        }catch (SQLException e){
            logger.trace ( "SQLException" );
        }
        try {
            connection.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
    }
}


    @Autowired
    ApplicationContext  ioc ;//注入Spring容器
    @Test
    public void testHelloService(){
        boolean ifContain = ioc.containsBean("helloService");
        System.out.println("是否已经导入spring配置类: " + ifContain);

        ifContain = ioc.containsBean("helloService02");
        System.out.println("是否已经导入spring配置类02: " + ifContain);
    }

    @Test
    public void testLogging(){
        logger.trace("这是info日志……");
        logger.debug("这是info日志……");
        logger.info("这是info日志……");
        logger.warn("这是info日志……");
        logger.error("这是error日志……");


    }

}
