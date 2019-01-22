package com.doubleriver.springbootgeneral.component;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @Author ronye
 * @Created 2018/12/10 - 7:22 PM
 */
/**
* 自定义视图解析器
* */
public class MyViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) {
        //……
        return null;
    }
}
