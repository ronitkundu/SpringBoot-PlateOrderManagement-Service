package com.example.plate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
	
	@Bean
    public CorsFilter corsFilter() {
		System.out.println("kkkkkkkkkkkkkkk");
		
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Set allowed origin
        config.addAllowedHeader("*"); // Set allowed headers
        config.addAllowedMethod("*"); // Set allowed methods

        source.registerCorsConfiguration("/plate/**", config); // Define the path for which CORS should be configured

        return new CorsFilter(source);
        
    }

}
