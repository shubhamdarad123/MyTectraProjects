	package com.mytechra.spring.playground.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Cab {

	@NotNull(message = "Cab Num should not be null")
	private String cabNo;
	
	@NotNull
	private String type;
	
	@NotNull
	private String location;
	
	@Range(min = 0 , max = 100)
	private int pricingPerHour;

	public String getCabNo() {
		return cabNo;
	}

	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPricingPerHour() {
		return pricingPerHour;
	}

	public void setPricingPerHour(int pricingPerHour) {
		this.pricingPerHour = pricingPerHour;
	}
	
	
}
