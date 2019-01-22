package com.doubleriver.springbootgeneral.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author ronye
 * @Created 2018/12/31 - 10:18 PM
 */
public class MyFilter implements Filter{
    Logger logger = LoggerFactory.getLogger ( this.getClass ());
    @Override
    public void init (FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.trace ( "filter process..." );
        chain.doFilter (request,response);
    }

    @Override
    public void destroy ( ) {

    }
}
