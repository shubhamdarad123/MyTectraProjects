package com.mytechra.spring.playground.hibernate.mappings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="employees" , path ="employees")
public interface EmployeeRest extends CrudRepository<Employee, Integer> {

}
