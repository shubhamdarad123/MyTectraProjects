package com.mytechra.spring.playground.ui;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookRide {
	@NotNull
	@Pattern(regexp=".+_.+")
	private String rideId;

	public String getRideId() {
		return rideId;
	}
	
	public String getLocation() {
		return rideId.split("_")[1];
	}

	public void setRideId(String rideId) {
		this.rideId = rideId;
	}
}
