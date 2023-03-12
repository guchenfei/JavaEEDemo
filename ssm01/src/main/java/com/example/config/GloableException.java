package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

//@Configuration
public class GloableException {
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        final SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        final Properties properties = new Properties();
        properties.put("java.lang.ArithmeticException","error.jsp");
        properties.put("java.lang.NullPointerException","fail.jsp");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }
}
