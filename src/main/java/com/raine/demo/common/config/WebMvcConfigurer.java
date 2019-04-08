package com.raine.demo.common.config;

import com.raine.demo.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 *
 * @author chenjun
 * @date 2019/3/29
 * @since V1.0
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器 拦截规则
        // 多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public static HandlerInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
}