package com.mytechra.spring.playground.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCritera {

	private static final String delim = ";";

	private List<UberCriteria> criterias = new ArrayList<>();

	private SearchCritera() {
	}

	public static SearchCritera build(String search) throw SCE {
		SearchCritera critera = new SearchCritera();

		String[] values = search.split(delim);
		Arrays.stream(values).forEach(value -> critera.criterias.add(UberCriteria.build(value)));
		return critera;

	}

	public List<UberCriteria> getCriterias() {
		return criterias;
	}

	@Override
	public String toString() {
		return "SearchCritera [criterias=" + criterias + "]";
	}

	
}
