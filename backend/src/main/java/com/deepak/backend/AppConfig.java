package com.deepak.backend;

import com.deepak.backend.Services.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CourseService myService() {
        return new CourseService();
    }
}