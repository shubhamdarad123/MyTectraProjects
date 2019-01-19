package com.mytechra.spring.playground.core.pricing;

import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Price;

public interface Pricing {
	
	Price price(Cab cab) throws Exception;
}