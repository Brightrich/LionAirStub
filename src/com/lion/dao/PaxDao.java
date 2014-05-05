package com.lion.dao;

import java.util.List;

import com.lion.model.Pax;

public interface PaxDao {
	public void savePax(Pax[] listPax);
    public List<Pax> getPaxByTransactionId(String transactionId);    
}
