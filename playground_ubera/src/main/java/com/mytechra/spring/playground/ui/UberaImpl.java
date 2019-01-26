/*package com.mytechra.spring.playground.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Ride;
import com.mytechra.spring.playground.rest.RestMessage;

@Component
public class UberaImpl implements Ubera {

	@Autowired
	private CabLogistics cabs;
	
	

	@Override
	public List<Ride> getRides(String location) throws Exception {
		return cabs.getRides(location);
	}

	@Override
	public RestMessage<String> bookRide(BookRide ride) throws Exception {
		cabs.bookRide(ride);
		return "Success";
		return null;
	}

	@Override
	public List<Ride> getBookedRides() throws Exception {
		return cabs.getBookedRide();
		
	}

}
*/