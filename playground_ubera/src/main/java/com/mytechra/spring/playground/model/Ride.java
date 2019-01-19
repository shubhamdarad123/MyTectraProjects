package com.mytechra.spring.playground.model;

public class Ride {
	
	private String rideId;
	
	private Cab cabDetails;
	
	private Price price;
	
	public String getRideId() {
		return rideId;
	}

	public void setRideId(String rideId) {
		this.rideId = rideId;
	}

	public Cab getCabDetails() {
		return cabDetails;
	}

	public void setCabDetails(Cab cabDetails) {
		this.cabDetails = cabDetails;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Ride [rideId=%s, cabDetails=%s, price=%s]", rideId, cabDetails.getCabNo(), price.totalPrice());
	}
	

}
