package com.raine.demo.common.config;

import com.raine.demo.common.filter.LogCostFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 过滤器配置
 *
 * @author chenjun
 * @date 2019/3/29
 * @since V1.0
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registLogCostFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(logCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public Filter logCostFilter() {
        return new LogCostFilter();
    }

}
