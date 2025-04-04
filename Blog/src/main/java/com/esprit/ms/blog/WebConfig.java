package com.esprit.ms.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/Blogs/**")  // Correct path to match your Spring Boot controller
                .allowedOrigins("http://localhost:4200")  // Allow requests from Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
