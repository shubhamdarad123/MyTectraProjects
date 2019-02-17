package com.mytechra.spring.playground.core.cabpoolDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mytechra.spring.playground.model.Cab;

@Component
//@Primary
@Qualifier("cabsDAO")
public class CabsDAO implements ICabsDAO {
	@Autowired
	CabExtractor cabExtractor;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_QUERY = "insert into cabs(cabNumber,tyoe,location,pricingPerHour) values (?,?,?,?)";
	private static final String GET_ALL_QUERY = "select * from cabs WHERE LOCATION =";
    private static final String DELETE_QUERY = "DELETE FROM cabs WHERE cabNumber = ? and type = ? and location = ? and pricingPerHour =? ";
	
	/* (non-Javadoc)
	 * @see com.mytechra.spring.playground.core.cabpoolDatabase.ICabsDAO#save(com.mytechra.spring.playground.model.Cab)
	 */
	@Override
	public void save(Cab cab) {
		jdbcTemplate.update(INSERT_QUERY,cab.getCabNo(),cab.getType(),cab.getLocation(),cab.getPricingPerHour());
	}
	
	/* (non-Javadoc)
	 * @see com.mytechra.spring.playground.core.cabpoolDatabase.ICabsDAO#findAll(java.lang.String)
	 */
	@Override
	public List<Cab> findAll(String location){
		String QUERY_LOCATION = GET_ALL_QUERY + "\""+location+"\"";
		return (List<Cab>) jdbcTemplate.query(QUERY_LOCATION,cabExtractor);
	}

	/* (non-Javadoc)
	 * @see com.mytechra.spring.playground.core.cabpoolDatabase.ICabsDAO#deleteCab(com.mytechra.spring.playground.model.Cab)
	 */
	@Override
	public void deleteCab(Cab cab) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_QUERY,cab.getCabNo(),cab.getType(),cab.getLocation(),cab.getPricingPerHour());
	}
	
}
