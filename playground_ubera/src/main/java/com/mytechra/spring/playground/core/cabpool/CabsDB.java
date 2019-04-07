package com.mytechra.spring.playground.core.cabpool;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.core.cabpool.CabPool;
import com.mytechra.spring.playground.core.cabpoolDatabase.ICabsDAO;
import com.mytechra.spring.playground.model.Cab;

@Component
@Primary
public class CabsDB implements CabPool{

	@Autowired
	ICabsDAO cabsDAO;
	
	public ICabsDAO getCabsDAO() {
		return cabsDAO;
	}

	public void setCabsDAO(ICabsDAO cabsDAO) {
		this.cabsDAO = cabsDAO;
	}


	@Override
	public void addCab(Cab cab) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in cabdb");
		cabsDAO.save(cab);
		
	}

	@Override
	public List<Cab> listCabs(String location) throws Exception {
		return cabsDAO.findAll(location);
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCab(Cab cab) throws Exception {
		// TODO Auto-generated method stub
		cabsDAO.deleteCab(cab);
		
	}

	@Override
	public List<Cab> listCabs() throws Exception {
		// TODO Auto-generated method stub
		return cabsDAO.findAll();
	}

}
