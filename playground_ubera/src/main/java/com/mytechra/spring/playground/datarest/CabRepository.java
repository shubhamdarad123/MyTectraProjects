package com.mytechra.spring.playground.datarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mytechra.spring.playground.model.Cab;


@RepositoryRestResource(collectionResourceRel = "cabs" , path = "cabs")
public interface CabRepository extends PagingAndSortingRepository<Cab, String> {	
	

}
