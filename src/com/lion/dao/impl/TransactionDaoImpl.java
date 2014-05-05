package com.lion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.lion.dao.TransactionDao;
import com.lion.model.Transaction;
import com.lion.util.Constant;

public class TransactionDaoImpl implements TransactionDao {

	
	
	String sql_INSERT = "insert into BOOKING_TRX ("+ Constant.Transaction.TRX_FIELDS_QUERY +") "
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
    
    String sql_SELECT = "select " + Constant.Transaction.TRX_FIELDS_QUERY 
            + " from BOOKING_TRX ";
    
    String sql_UPDATE = "update BOOKING_TRX set "+ Constant.Transaction.FLAG +" = ? where "+ Constant.Transaction.TRX_ID +" = ? ";        
    
    private JdbcTemplate jdbcTemplate;

    public void saveTransaction(Transaction t) {        
    	
    	jdbcTemplate.update(sql_INSERT, new Object[]{
            t.getTransactionId(),
            t.getBookingCode(),
            t.getOutboundFlightNumber(),
            t.getDepartureDate(),
            t.getOutboundDepartureTime(),
            t.getReturnDate(),
            t.getReturnDepartureTime(),
            t.getFlightType(),
            t.getNumOfPax(),
            t.getTotalFare(),
            t.getOrigin(),
            t.getDestination(),
            t.getMsisdn(),
            t.getAirlines(),            
            t.getBookingDate(),
            t.getFlag(),
            t.getPaymentCode(),
            t.getReturnFlightNumber(),
            t.getFlightClass(),
            t.getOutboundArrivalTime(),
            t.getReturnArrivalTime()
        }, new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
        });        
    }
    
   

    public void updateTransactionFlag(String status, String transactionId) {
    	String sql = "update BOOKING_TRX set "+ Constant.Transaction.FLAG + " = ? where "+ Constant.Transaction.TRX_ID +" = ?";
        Object[] param = new Object[]{status, transactionId};
        jdbcTemplate.update(sql, param);        
    }

    public Transaction getTransaction(String transactionId) {
        String sql = sql_SELECT+" where "+ Constant.Transaction.TRX_ID +" = ? ";        
        @SuppressWarnings("unchecked")
		List<Transaction> list = jdbcTemplate.query(sql, new Object[] {transactionId}, new TransactionRowMapper());
        System.out.println("LIST TRX");
        if (list!=null && list.size()>0){
        	System.out.println("LIST TRX " + list);
            return list.get(0);
        }
        System.out.println("LIST NULL");
        return null;
    }   
    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



	@Override
	public void updateTransactionPaymentCode(String paymentCode,
			String transactionId) {
		String sql = "update BOOKING_TRX set "+ Constant.Transaction.PAYMENT_CODE + " = ? where "+ Constant.Transaction.TRX_ID +" = ?";
        Object[] param = new Object[]{paymentCode, transactionId};
        jdbcTemplate.update(sql, param);
		
	}
	
	@Override
	public void updateTransactionBookingCode(String bookingCode,
			String transactionId) {
		String sql = "update BOOKING_TRX set "+ Constant.Transaction.BOOKING_CODE + " = ? where "+ Constant.Transaction.TRX_ID +" = ?";
        Object[] param = new Object[]{bookingCode, transactionId};
        jdbcTemplate.update(sql, param);
		
	}
}
class TransactionRowMapper implements RowMapper{

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction t = new Transaction();
        t.setAirlines(rs.getString(Constant.Transaction.AIRLINES));
        t.setBookingCode(rs.getString(Constant.Transaction.BOOKING_CODE));
        t.setBookingDate(rs.getTimestamp(Constant.Transaction.BOOKING_DATE));
        t.setDepartureDate(rs.getString(Constant.Transaction.DEPARTURE_DATE));
        t.setOutboundDepartureTime(rs.getString(Constant.Transaction.OUTBOUND_DEPARTURE_TIME));
        t.setDestination(rs.getString(Constant.Transaction.DESTINATION));
        t.setFlag(rs.getString(Constant.Transaction.FLAG));
        t.setOutboundFlightNumber(rs.getString(Constant.Transaction.OUTBOUND_FLIGHT_NUMBER));
        t.setFlightType(rs.getString(Constant.Transaction.FLIGHT_TYPE));
        t.setMsisdn(rs.getString(Constant.Transaction.MSISDN));
        t.setNumOfPax(rs.getString(Constant.Transaction.NUM_OF_PAX));
        t.setOrigin(rs.getString(Constant.Transaction.ORIGIN));
        t.setReturnDate(rs.getString(Constant.Transaction.RETURN_DATE));
        t.setReturnDepartureTime(rs.getString(Constant.Transaction.RETURN_DEPARTURE_TIME));
        t.setTotalFare(rs.getString(Constant.Transaction.TOTAL_FARES));
        t.setTransactionId(rs.getString(Constant.Transaction.TRX_ID));   
        t.setPaymentCode(rs.getString(Constant.Transaction.PAYMENT_CODE));
        t.setReturnFlightNumber(rs.getString(Constant.Transaction.RETURN_FLIGHT_NUMBER));
        t.setFlightClass(rs.getString(Constant.Transaction.FLIGHT_CLASS));
        t.setOutboundArrivalTime(rs.getString(Constant.Transaction.OUTBOUND_ARRIVAL_TIME));
        t.setReturnArrivalTime(rs.getString(Constant.Transaction.RETURN_ARRIVAL_TIME));
        return t;
    }				
	
}
