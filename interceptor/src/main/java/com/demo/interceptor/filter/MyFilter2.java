package com.demo.interceptor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter2 implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器2");
    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器开始对请求进行预处理2：");
        HttpServletRequest request    = (HttpServletRequest) servletRequest;
        String             requestUri = request.getRequestURI();
        logger.info("请求的接口为2: {}", requestUri);
        long startTime = System.currentTimeMillis();
        //通过 doFilter 方法实现过滤功能
        filterChain.doFilter(servletRequest, servletResponse);
        // 上面的 doFilter 方法执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        logger.info("该用户的请求已经处理完毕，请求花费的时间为：{}", endTime-startTime);
    }
}
