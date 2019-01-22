package com.doubleriver.springbootgeneral.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ronye
 * @Created 2019/1/11 - 2:59 AM
 */

@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){

        return new ConfigurationCustomizer (){

            @Override
            public void customize (org.apache.ibatis.session.Configuration configuration) {
                // 开启驼峰命名法
                configuration.setMapUnderscoreToCamelCase (  true );
            }
        };
    }
}
