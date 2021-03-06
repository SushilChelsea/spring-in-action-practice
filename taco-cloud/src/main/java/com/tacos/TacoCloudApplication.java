package com.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TacoCloudApplication implements WebMvcConfigurer { 

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}
	 
	/** useful when forwarding to view with out any validation and modal object , only for GET request **/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hello").setViewName("hello");
	}
	
}
