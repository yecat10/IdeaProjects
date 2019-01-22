package com.doubleriver.springbootgeneral.component;

/**
 * @Author ronye
 * @Created 2018/12/29 - 4:33 AM
 */
//给容器中加入我们自己定义的ErrorAttributes

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","atguigu");//通过自定义ErrorAttributes添加的内容

        Map<String, Object> ext = (Map<String,Object>)requestAttributes.getAttribute ( "ext",0 );
        //通过自定义异常处理类添加的信息
        map.put ( "ext",ext );
        return map;
    }
}
