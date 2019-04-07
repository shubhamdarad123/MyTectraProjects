package com.mytechra.spring.playground.core.cabpoolDatabase;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mytechra.spring.playground.model.Cab;
@Component
@Primary
public class CabsDAOHibernate implements ICabsDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void save(Cab cab) {
		// TODO Auto-generated method stub
		System.out.println("add cab");
		entityManager.persist(cab);
		
	}

	@Override
	public List<Cab> findAll(String location) {
		// HQL WAY
		System.out.println("query started");
		TypedQuery<Cab> query =  entityManager.createQuery("FROM Cab c where c.location = ?1", Cab.class);
		System.out.println("query created");
		query.setParameter(1,location);
		System.out.println("query parameter set");
		return query.getResultList();
	}

	@Override
	public List<Cab> findAll() {
		// HQL WAY
		System.out.println("query started");
		TypedQuery<Cab> query =  entityManager.createQuery("FROM Cab c", Cab.class);
		System.out.println("query created");
		return query.getResultList();
	}
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void deleteCab(Cab cab) {
		// TODO Auto-generated method stub
		System.out.println("reached in delete Cab function of hibenate");
		entityManager.remove(entityManager.find(Cab.class, cab.getCabNo()));

	}

}
