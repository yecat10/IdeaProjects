package com.doubleriver.springbootgeneral.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author ronye
 * @Created 2018/12/31 - 10:37 PM
 */
public class MyListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger ( this.getClass () );
    @Override
    public void contextInitialized (ServletContextEvent sce) {
        logger.trace ( "contextInitialized...web应用启动" );
    }

    @Override
    public void contextDestroyed (ServletContextEvent sce) {
        logger.trace ( "contextDestroyed...web应用销毁" );
    }
}
