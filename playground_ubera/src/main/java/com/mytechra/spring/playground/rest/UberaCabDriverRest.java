package com.mytechra.spring.playground.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.rest.RestMessage.Status;
import com.mytechra.spring.playground.ui.UberaCabs;

@RestController
public class UberaCabDriverRest implements UberaCabs {

	@Autowired
	private CabLogistics cabs;
	

	@PostMapping("/register")
	@Override
	public RestMessage<String> registerCab(@RequestBody @RequestPart("application/json") @Validated Cab cab) throws Exception {
		cabs.registerCab(cab);
		return new RestMessage<String>(Status.SUCESSS, "Cab Reg succesfull");
		/*RestError error = validate(cab);
		if(error == null) {
			cabs.registerCab(cab);
			return new ResponseEntity<>("sucess",HttpStatus.OK);
		} else {
			return new ResponseEntity<>(error,HttpStatus.OK);
		}*/
		
	}



	/*private RestError validate(Cab cab) {
		if(cab.getCabNo() == null || cab.getCabNo().isEmpty()) {
			RestError error = new RestError();
			error.msg = "Can No is empty";
			return error; 
		}
		return null;
		
		
	}*/


}
