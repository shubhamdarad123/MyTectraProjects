package com.mytechra.spring.playground.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Ride;
import com.mytechra.spring.playground.rest.RestMessage.Status;
import com.mytechra.spring.playground.search.SearchCritera;
import com.mytechra.spring.playground.ui.BookRide;
import com.mytechra.spring.playground.ui.Ubera;

@RestController
public class UberRest implements Ubera {

	@Autowired
	private CabLogistics cabs;
	
	@PostConstruct
	public void init() throws Exception {
		Cab cab = new Cab();
		cab.setCabNo("34456");
		cab.setLocation("bengaluru");
		cab.setType("innova");
		cab.setPricingPerHour(100);
		
		cabs.registerCab(cab);
		
		Cab cab2 = new Cab();
		cab2.setCabNo("34457");
		cab2.setLocation("bengaluru");
		cab2.setType("innova2");
		cab2.setPricingPerHour(105);
		
		cabs.registerCab(cab2);
		
		Cab cab3 = new Cab();
		cab3.setCabNo("34446");
		cab3.setLocation("mysore");
		cab3.setType("innova2");
		cab3.setPricingPerHour(105);
		
		cabs.registerCab(cab3);
		
	}

	@GetMapping("/list-rides")
	@Override
	public List<Ride> getRides(@RequestParam("search") String search) throws Exception {
		SearchCritera criteria = SearchCritera.build(search);
		System.out.println(criteria);
		return cabs.getRides(criteria);
	}

	@PostMapping("/book")
	public RestMessage<String> bookRide(@RequestBody @RequestPart("application/json") @Validated BookRide ride)
			throws Exception {
		// bookRideValidation(ride);
		/*List<Ride> rides = cabs.getRides(ride.getLocation());

		Optional<Ride> rideToBeBooked = rides.stream().filter(r -> r.getRideId().equals(ride.getRideId())).findFirst();

		if (rideToBeBooked.isPresent()) {
			cabs.bookRide(rideToBeBooked.get());
		} else {
			throw new Exception("Connot Book");
		}
		return new RestMessage<String>(Status.SUCESSS, "Booked Succesfully");*/
		
		return null;

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public RestMessage<String> handleException(Exception ex) {
		return new RestMessage<String>(Status.ERROR, ex.getMessage());

	}

	@GetMapping("/bookedride")
	@Override
	public List<Ride> getBookedRides() throws Exception {
		return cabs.getBookedRide();
	}

}
