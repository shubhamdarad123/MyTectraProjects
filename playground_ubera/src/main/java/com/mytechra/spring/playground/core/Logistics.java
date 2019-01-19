package com.mytechra.spring.playground.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.core.cabpool.CabPool;
import com.mytechra.spring.playground.core.pricing.Pricing;
import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Ride;

//@Component
public class Logistics implements CabLogistics {

/*	@Autowired*/
	private CabPool cabs;
	
/*	@Autowired
	@Qualifier("surge")*/
	private Pricing pricing;
	
	
	//Constructor Autowiring, Recomanded
	@Autowired
	public Logistics(CabPool cabs ,@Qualifier("lazy-surge") @Lazy Pricing pricing ){
		this.cabs = cabs;
		this.pricing = pricing;
	}
	
	private List<Ride> ridesBooked = new ArrayList<>();
	
	@Override
	public List<Ride> getRides(String location) throws Exception {
		System.out.println("Getting Rides....");
		List<Ride> rides = new ArrayList<>();
		List<Cab> cabList = cabs.listCabs(location);
		 for(Cab cab : cabList) {
			Ride ride = new Ride();
			ride.setRideId(cab.getCabNo() + '_' + location);
			ride.setCabDetails(cab);
			ride.setPrice(pricing.price(cab));
			rides.add(ride);
		}
		return rides;
	}

	@Override
	public void bookRide(Ride ride) throws Exception {
		ridesBooked.add(ride);
	}

	@Override
	public void registerCab(Cab cab) throws Exception {
		cabs.addCab(cab);
	}

}
