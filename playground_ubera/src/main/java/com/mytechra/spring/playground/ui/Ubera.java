package com.mytechra.spring.playground.ui;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mytechra.spring.playground.model.Ride;
import com.mytechra.spring.playground.rest.RestMessage;

//Users
public interface Ubera {
	
	public List<Ride> getRides(String location) throws Exception;
	
	public RestMessage<String> bookRide(BookRide ride) throws Exception;
	
	public List<Ride> getBookedRides() throws Exception;

}