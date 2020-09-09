package com.demo.interceptor.filter.config;

import com.demo.interceptor.filter.MyFilter;
import com.demo.interceptor.filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;
    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<Filter> thirdFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Collections.singletonList("/api/*")));
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean<Filter> setUpMyFilter2() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(myFilter2);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Collections.singletonList("/api/*")));
        return filterRegistrationBean;
    }
}
