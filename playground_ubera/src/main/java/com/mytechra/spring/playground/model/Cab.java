	package com.mytechra.spring.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "cabs")
public class Cab {
	@Id
	@NotNull(message = "Cab Num should not be null")
	@Size(min = 3)
	@Column(name = "cabNumber")
	private String cabNo;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

	@NotNull(message = "type cannot be null")
	@Size(min = 3)
	@Column(name = "tyoe")
	private String type;
	
	@NotNull(message = "location cannot be null")
	@Size(min = 3)
	private String location;

	@NotNull(message = "location cannot be null")
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

	@Override
	public String toString() {
		return "Cab [cabNo=" + cabNo + ", type=" + type + ", location=" + location + ", pricingPerHour="
				+ pricingPerHour + "]";
	}
	
}
