package com.mytechra.spring.playground.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		Docket api = new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.mytechra.spring.playground.rest"))
		.paths(PathSelectors.any()).build();	
		api.securitySchemes(Collections.singletonList(securityScheme()));
		return api;
		
	}

	private SecurityScheme securityScheme() {
		// TODO Auto-generated method stub
		return new BasicAuth("basicAuth");
	}
}
