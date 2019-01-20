package com.mytechra.spring.playground.ui;

import java.util.List;

import com.mytechra.spring.playground.model.Ride;

public interface Ubera {
	
	public List<Ride> getRides(String location) throws Exception;
	
	public String bookRide(Ride ride) throws Exception;
	
	public List<Ride> getBookedRides() throws Exception;
}
