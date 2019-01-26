package com.mytechra.spring.playground.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

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
import com.mytechra.spring.playground.model.Ride;
import com.mytechra.spring.playground.rest.RestMessage.Status;
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
	public RestMessage<String> bookRide(@RequestBody @RequestPart("application/json") @Validated BookRide ride)
			throws Exception {
		// bookRideValidation(ride);
		List<Ride> rides = cabs.getRides(ride.getLocation());

		Optional<Ride> rideToBeBooked = rides.stream().filter(r -> r.getRideId().equals(ride.getRideId())).findFirst();

		if (rideToBeBooked.isPresent()) {
			cabs.bookRide(rideToBeBooked.get());
		} else {
			throw new Exception("Connot Book");
		}
		return new RestMessage<String>(Status.SUCESSS, "Booked Succesfully");

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
