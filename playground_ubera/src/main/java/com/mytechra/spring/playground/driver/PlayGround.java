package com.mytechra.spring.playground.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages= {"com.mytechra.spring.playground"})
//optional
@EntityScan(basePackages = {"com.mytechra.spring.playground"})
@EnableWebMvc
//optional
@EnableJpaRepositories("com.mytechra.spring.playground")
//@ImportResource("classpath:beans.xml")

public class PlayGround {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(PlayGround.class, args);
		/*System.out.println("Application Configure Successfully");
		//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		
		Ubera ubera = ctx.getBean(Ubera.class);
		
		List<Ride> rides = ubera.getRides("bengaluru");
		
		rides.forEach(System.out::println);*/
		
	}

}
