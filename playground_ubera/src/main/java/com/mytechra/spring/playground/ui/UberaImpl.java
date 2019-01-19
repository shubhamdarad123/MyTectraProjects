package com.mytechra.spring.playground.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Ride;

@Component
public class UberaImpl implements Ubera {

	@Autowired
	private CabLogistics cabs;
	
	@PostConstruct
	public void init() throws Exception {
		Cab cab = new Cab();
		cab.setCabNo("34456");
		cab.setLocation("bengaluru");
		cab.setType("innova");
		cab.setPricingPerHour(100);
		
		cabs.registerCab(cab);
		
		Cab cab2 = new Cab();
		cab2.setCabNo("34457");
		cab2.setLocation("bengaluru");
		cab2.setType("innova2");
		cab2.setPricingPerHour(105);
		
		cabs.registerCab(cab2);
		
		Cab cab3 = new Cab();
		cab3.setCabNo("34446");
		cab3.setLocation("mysore");
		cab3.setType("innova2");
		cab3.setPricingPerHour(105);
		
		cabs.registerCab(cab3);
		
	}

	@Override
	public List<Ride> getRides(String location) throws Exception {
		return cabs.getRides(location);
	}

	@Override
	public String bookRide(Ride ride) throws Exception {
		cabs.bookRide(ride);
		return "Success";
	}

}
