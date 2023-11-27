package com.example.plate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.plate.entity.User;
import com.example.plate.rule.CustomInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class ApiConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add interceptors
        registry.addInterceptor(new CustomInterceptor())
                .addPathPatterns("/plate/**") // Apply to specific API paths
                .excludePathPatterns("/plate/public/**"); // Exclude specific paths from the interceptor
    }
}
