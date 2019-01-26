package com.mytechra.spring.playground.core;

import java.util.List;

import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.model.Ride;
import com.mytechra.spring.playground.search.SearchCritera;

public interface CabLogistics {
	
	List<Ride> getRides(SearchCritera critera)throws Exception;
	
	void bookRide(Ride ride)throws Exception;
	
	void registerCab(Cab cab)throws Exception;
	
	public List<Ride> getBookedRide() throws Exception;
	
}
