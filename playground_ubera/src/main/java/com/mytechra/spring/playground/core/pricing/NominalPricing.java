package com.mytechra.spring.playground.core.pricing;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Price;
import com.mytechra.spring.playground.model.Price.UnitCharge;
@Primary
@Component
public class NominalPricing  implements Pricing{
 
	@PostConstruct
	public void init() {
		System.out.println("Nomial Pricing...");
	}
	
	@Override
	public Price price(Cab cab) throws Exception {
		Price price = new Price();
		int cabPrice = cab.getPricingPerHour();
		
		UnitCharge baseFare = new  UnitCharge(cabPrice, "BF", "Base Fair");
		UnitCharge sc = new  UnitCharge((int)(cabPrice * 0.4), "SC", "Serive Charge");
		price.addUnitCharges(baseFare);
		price.addUnitCharges(sc);

		return price;
		

	}

}
