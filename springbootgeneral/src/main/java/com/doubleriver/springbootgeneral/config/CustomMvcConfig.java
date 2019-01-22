package com.doubleriver.springbootgeneral.config;

import com.doubleriver.springbootgeneral.component.LoginHandlerInterceptor;
import com.doubleriver.springbootgeneral.component.MyLocaleResolver;
import com.doubleriver.springbootgeneral.component.MyViewResolver;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @Author ronye
 * @Created 2018/12/12 - 12:14 AM
 */
@Configuration
public class CustomMvcConfig implements WebMvcConfigurer {
//通过继承WebMvcConfigurationSupport类重写对应方法扩展了我们需要的springmvc的功能，同时也保留原有自动配置
    /**
     * ① 配置了视图解析器bean；
     * ② 静态资源访问支持，包括WebJars；
     * ③ 注册了转换器和格式化器；
     * ④ 请求响应信息转换器；
     * ⑤ 注册信息校验解析器–定义错误代码生成规则；
     * ⑥ 静态页面index.html支持(欢迎页)；
     * ⑦ 项目浏览器图标支持；
     * ⑧ 可配置web数据绑定初始化器bean的自动使用。
     * */



    @Bean
    public LocaleResolver localeResolver(){
        //自定义配置区域信息解析器实现根据应用的选择语言进行管理，取代springboot默认根据浏览器进行设置的方式
        return new MyLocaleResolver();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/goSuccess").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }
    @Bean//Bean标签在注解为 @Component 或是 @Configuration的类中的方法上标注
    public ViewResolver customViewResolver(){
        // 调用自定义视图解析器
        return new MyViewResolver();
    }
    @Bean
    public HttpMessageConverters customMessageConverter(){
        //自定义消息转换器
        return new HttpMessageConverters();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //放行登陆页面、根目录、欢迎页
        String[] excludeUrl_1= {"/index.html","/","/user/login"};
        //放行静态资源
        String[] excludeUrl_2= {"/asserts/**","/css/**","/webjars/**"};
        //放行默认全局异常处理
        String[] excludeUrl_3= {"/error"};

        //放行自定义其它请求
        String[] excludeUrl_4= {"/hello","/query"};
        //注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new LoginHandlerInterceptor ());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns(excludeUrl_1);
        ir.excludePathPatterns(excludeUrl_2);
        ir.excludePathPatterns(excludeUrl_3);
        ir.excludePathPatterns(excludeUrl_4);

    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

}
