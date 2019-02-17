package com.mytechra.spring.playground.core.cabpoolDatabase;

import java.util.List;

import com.mytechra.spring.playground.model.Cab;

public interface ICabsDAO {

	void save(Cab cab);

	List<Cab> findAll(String location);

	void deleteCab(Cab cab);

}