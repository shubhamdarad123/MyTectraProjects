package com.mytechra.spring.playground.core.cabpool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.model.Cab;
import com.mytechra.spring.playground.search.SearchCritera;

@Component
public class Cabs implements CabPool {

	private List<Cab> cabs = new ArrayList<>();

	@Override
	public void addCab(Cab cab) throws Exception {
		cabs.add(cab);
	}

	public Cabs() {
		System.out.println("cabs loaded");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteCab(Cab cab) throws Exception {
		Iterator<Cab> iterator = cabs.iterator();
		while (iterator.hasNext()) {
			if (cab.getCabNo().equals(iterator.next().getCabNo())) {
				iterator.remove();
				break;
			}

		}

	}

	@Override
	public List<Cab> listCabs(String location) throws Exception {
		return cabs.stream().filter(cab -> location.equals(cab.getLocation())).collect(Collectors.toList());
	}

}
