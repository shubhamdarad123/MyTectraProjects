package com.mytechra.spring.playground.ui;

import org.springframework.http.ResponseEntity;

import com.mytechra.spring.playground.model.Cab;


//This is API for drivers

public interface UberaCabs {
	
	public ResponseEntity<?> registerCab(Cab cab) throws Exception;
}