package com.mytechra.spring.playground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("WEB-INF/templates/",".jsp");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
}
