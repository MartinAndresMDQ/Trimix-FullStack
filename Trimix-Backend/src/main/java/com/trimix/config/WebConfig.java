package com.trimix.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.trimix.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
		registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://localhost:3002", "*")
				.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH").allowedHeaders("*")
				.exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Methods",
						"Access-Control-Allow-Headers", "Access-Control-Max-Age", "Access-Control-Request-Headers",
						"Access-Control-Request-Method")
				.allowCredentials(true);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

}
