package com.mytechra.spring.playground.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.model.Ride;
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
	@Override
	public String bookRide(@RequestBody @RequestPart("application/json") Ride ride) throws Exception {
		cabs.bookRide(ride);
		return "success";
	} 
	
	

}
