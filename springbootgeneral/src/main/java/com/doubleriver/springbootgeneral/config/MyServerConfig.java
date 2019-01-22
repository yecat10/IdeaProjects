package com.doubleriver.springbootgeneral.config;

import com.doubleriver.springbootgeneral.filter.MyFilter;
import com.doubleriver.springbootgeneral.listener.MyListener;
import com.doubleriver.springbootgeneral.servlet.MyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author ronye
 * @Created 2018/12/31 - 10:09 PM
 */

@Configuration
public class MyServerConfig {
    Logger logger = LoggerFactory.getLogger ( this.getClass () );
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){//servlet
        ServletRegistrationBean<MyServlet> servletRegistrationBean = new ServletRegistrationBean (new MyServlet (),"/myServlet" );
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){//filter
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean ();
        filterRegistrationBean.setFilter (new MyFilter ());
        filterRegistrationBean.setUrlPatterns ( Arrays.asList("/hello","/myServlet") );
        logger.info (filterRegistrationBean.getUrlPatterns ().toString ());
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){//listener
        ServletListenerRegistrationBean<MyListener> listenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<> (new MyListener ());
        return listenerServletListenerRegistrationBean;
    }

    //配置嵌入式servlet容器
    // 通过WebServerFactoryCustomizer来自定义嵌入式servlet容器的参数,与主配置文件的设定会冲突
//    @Bean
//    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
//
//        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){
//
//            @Override//嵌入式web容器工厂
//            public void customize (ConfigurableWebServerFactory factory) {
//                factory.setPort ( 8083 );
//                factory.setAddress (  );
//                factory.setCompression (  );
//                factory.setErrorPages (  );
//                factory.setHttp2 (  );
//                factory.setServerHeader (  );
//                factory.setSsl (  );
//                factory.setSslStoreProvider (  );
//            }
//        };
//    }



}
