package com.mytechra.spring.playground.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class UberaSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailService;
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		System.out.println("security config starteed");
	try {
		http.userDetailsService(userDetailService)
		.authorizeRequests()
		.antMatchers("/swagger-ui.html")
		.anonymous()
	.and()
		.authorizeRequests()
		.antMatchers("/*")
		.authenticated()
	.and()
		.httpBasic()
	.and()
		.csrf().disable();
		System.out.println("security config finished");
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
		
		//System.out.println("intitial configuration for spring security is completed");
    	//auth.userDetailsService(userDetailService);
    }
    
    
	
}
