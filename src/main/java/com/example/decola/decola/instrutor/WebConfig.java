package com.example.decola.decola.instrutor;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
    }

}