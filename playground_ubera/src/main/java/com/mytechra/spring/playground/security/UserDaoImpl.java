package com.mytechra.spring.playground.security;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager manager;

	@Override
	public User getUserByName(String name) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = cQuery.from(User.class);
		cQuery.where(criteriaBuilder.equal(root.get("sUserName"), name));
		cQuery.select(root);

		TypedQuery<User> typedQuery = manager.createQuery(cQuery);
		return typedQuery.getSingleResult();

	}

}
