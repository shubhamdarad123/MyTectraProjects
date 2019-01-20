package com.mytechra.spring.playground.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.model.Ride;
import com.mytechra.spring.playground.rest.UberaCabDriverRest.RestError;
import com.mytechra.spring.playground.ui.BookRide;
import com.mytechra.spring.playground.ui.Ubera;

@RestController
public class UberRest implements Ubera {

	@Autowired
	private CabLogistics cabs;
	
	@GetMapping("/list-rides")
	@Override
	public List<Ride> getRides(@RequestParam("location") @NotNull String location) throws Exception {
		return cabs.getRides(location);
	}

	@PostMapping("/book")
	public ResponseEntity<?> bookRide(@RequestBody @RequestPart("application/json") @Validated BookRide ride) throws Exception {
		//bookRideValidation(ride);
		List<Ride> rides = cabs.getRides(ride.getLocation());
	
		Optional<Ride> rideToBeBooked = rides.stream()
		.filter(r -> r.getRideId().equals(ride.getRideId()))
		.findFirst();
		
		if(rideToBeBooked.isPresent()) {
			cabs.bookRide(rideToBeBooked.get());
			return new ResponseEntity<>("sucess",HttpStatus.OK);
		} else {
			RestError error = new RestError();
			error.msg = "Cannot book ride";
			return new ResponseEntity<>(error,HttpStatus.OK);
		}
	} 

	@GetMapping("/bookedride")
	@Override
	public List<Ride> getBookedRides() throws Exception {
		return cabs.getBookedRide();
	}


}
