package com.mytechra.spring.playground.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.mytechra.spring.playground.core.Logistics;
import com.mytechra.spring.playground.core.cabpool.Cabs;
import com.mytechra.spring.playground.core.pricing.Pricing;
@Configuration
public class Config {
	
	@Bean
	public Logistics cabLG(Cabs pool , @Qualifier("lazy-surge")@Lazy Pricing pricing) {
		return new Logistics(pool, pricing);
	}

}
 