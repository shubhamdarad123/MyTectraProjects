package com.mytechra.spring.playground.core.cabpoolDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.model.Cab;
@Component
public class CabExtractor implements RowMapper<Cab> {

	@Override
	public Cab mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cab cab = new Cab();
		cab.setCabNo(rs.getString("cabNumber"));
		cab.setType(rs.getString("tyoe"));
		cab.setLocation(rs.getString("location"));
		cab.setPricingPerHour(rs.getInt("pricingPerHour"));
		
		return cab;
	}

	
}
