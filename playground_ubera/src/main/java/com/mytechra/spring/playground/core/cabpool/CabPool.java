package com.mytechra.spring.playground.core.cabpool;

import java.util.List;

import com.mytechra.spring.playground.model.Cab;

public interface CabPool {
	
	void addCab(Cab cab) throws Exception;
	
	List<Cab> listCabs(String location) throws Exception;
	
	void deleteCab(Cab cab) throws Exception;

}
