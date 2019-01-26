package com.mytechra.spring.playground.ui;

import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.rest.RestMessage;


//This is API for drivers

public interface UberaCabs {
	
	public RestMessage<String> registerCab(Cab cab) throws Exception;
}