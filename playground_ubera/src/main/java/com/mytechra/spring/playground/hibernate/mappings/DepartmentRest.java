package com.mytechra.spring.playground.hibernate.mappings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="departments" , path ="departments")
public interface DepartmentRest extends CrudRepository<Department, Integer> {

}
