package com.example.decola.decola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DecolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecolaApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/listar").allowedOrigins("*");
				registry.addMapping("/cadastrar").allowedOrigins("*");
				registry.addMapping("/get").allowedOrigins("*");
				registry.addMapping("/atualizar").allowedOrigins("*");
				registry.addMapping("/remover").allowedOrigins("*");
			}
		};
	}

}
