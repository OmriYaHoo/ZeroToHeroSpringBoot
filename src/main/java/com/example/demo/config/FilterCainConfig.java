package com.example.demo.config;

import com.example.demo.utils.ApiLogsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterCainConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("apiLogsFilter");
        ApiLogsFilter apiLogsFilter = new ApiLogsFilter();
        registrationBean.setFilter(apiLogsFilter);
        registrationBean.setOrder(5);
        return registrationBean;
    }
}
