package com.mytechra.spring.playground.ui;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mytechra.spring.playground.model.Ride;

//Users
public interface Ubera {
	
	public List<Ride> getRides(String location) throws Exception;
	
	public ResponseEntity<?> bookRide(BookRide ride) throws Exception;
	
	public List<Ride> getBookedRides() throws Exception;

}