package com.lion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lion.dao.PaxDao;
import com.lion.model.Pax;
import com.lion.util.Constant;

public class PaxDaoImpl implements PaxDao {
	
	private JdbcTemplate jdbcTemplate;
	String sql_INSERT = "insert into BOOKING_PAX ("+ Constant.Pax.PAX_FIELDS_QUERY +") "
            + "values (?,?,?,?)";
	
	String sql_SELECT = "select " + Constant.Pax.PAX_FIELDS_QUERY 
            + " from BOOKING_PAX ";
	
	@Override
	public void savePax(Pax[] listPax) {		
		for (Pax pax : listPax) {							
			jdbcTemplate.update(sql_INSERT, new Object[]{
		            pax.getTransactionId(),pax.getTitle(),pax.getPaxName(),pax.getPaxSSN()
		        }, new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
		}
	}

	@Override
	public List<Pax> getPaxByTransactionId(String transactionId) {
		String sql = sql_SELECT+" where "+ Constant.Pax.TRX_ID +" = ? ";        
        
		@SuppressWarnings("unchecked")
		List<Pax> list = jdbcTemplate.query(sql, new Object[] {transactionId}, new PaxRowMapper());
        
        if (list!=null && list.size()>0){
        	
            return list;
        }
        
        return new ArrayList<Pax>();
	}

	/**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
}
class PaxRowMapper implements RowMapper{

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pax p = new Pax();
        p.setPaxName(rs.getString(Constant.Pax.PAX_NAME));
        p.setPaxSSN(rs.getString(Constant.Pax.PAX_SSN));
        p.setTitle(rs.getString(Constant.Pax.TITLE));
        p.setTransactionId(rs.getString(Constant.Pax.TRX_ID));
        return p;
    }				
	
}