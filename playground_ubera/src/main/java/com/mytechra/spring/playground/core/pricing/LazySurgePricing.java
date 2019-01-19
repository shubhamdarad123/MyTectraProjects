package com.mytechra.spring.playground.core.pricing;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Price;
import com.mytechra.spring.playground.model.Price.UnitCharge;

@Component
@Qualifier("lazy-surge")
@Lazy
public class LazySurgePricing  implements Pricing{

	@PostConstruct
	public void init() {
		System.out.println("Lazy Surge Pricing...");
	}
	
	@Override
	public Price price(Cab cab) throws Exception {
		Price price = new Price();
		int cabPrice = cab.getPricingPerHour();
		
		UnitCharge baseFare = new  UnitCharge(cabPrice, "BF", "Base Fair");
		UnitCharge surgeFare = new  UnitCharge((int)(cabPrice * 0.6), "Surge Price", "Surge Pricing");

		UnitCharge sc = new  UnitCharge((int)(cabPrice * 0.4), "SC", "Serive Charge");
		price.addUnitCharges(baseFare);
		price.addUnitCharges(surgeFare);

		price.addUnitCharges(sc);

		return price;
		

	}

}
