

package com.doubleriver.springbootgeneral.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ronye
 * @Created 2019/1/10 - 7:22 PM
 */

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource (  );
    }

    //配置Druid监控

    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean ( new StatViewServlet (), "/druid/*" );

        Map<String,String> initParams = new HashMap<> ();
        initParams.put ( "loginUsername","admin" );
        initParams.put ( "loginPassword","123456" );
        initParams.put ( "allow","" );//允许所有地址访问
        //initParams.put ( "deny","" );//拒绝本机IP地址（192.168.1.101）访问
        servletRegistrationBean.setInitParameters ( initParams );
        return servletRegistrationBean;
    }

    //2.配置Druid web监控的过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean ( new WebStatFilter ());

        Map<String,String> initParams = new HashMap<> ();
        initParams.put ( "exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters ( initParams );
        bean.setUrlPatterns ( Arrays.asList ("/*") );

        return bean;
    }
}

