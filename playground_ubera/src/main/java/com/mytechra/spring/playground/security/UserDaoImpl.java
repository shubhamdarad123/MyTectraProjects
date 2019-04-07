package com.mytechra.spring.playground.security;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager manager;

	@Override
	public User getUserByName(String name) {
		try {
		System.out.println("name is"+name);
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = cQuery.from(User.class);
		cQuery.select(root);	
		cQuery.where(criteriaBuilder.equal(root.get("sUserName"), name));

		TypedQuery<User> typedQuery = manager.createQuery(cQuery);
		System.out.println("query done");
		User user = typedQuery.getSingleResult();
		System.out.println("user is "+user.getUsername());
		System.out.println("password is "+user.getPassword());
		return user;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
