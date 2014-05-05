package com.lion.dao;

import com.lion.model.Transaction;


public interface TransactionDao {
	public void saveTransaction(Transaction t);
    public Transaction getTransaction(String transactionId);
    public void updateTransactionFlag(String status, String transactionId);
    public void updateTransactionPaymentCode(String paymentCode, String transactionId);
    public void updateTransactionBookingCode(String bookingCode,String transactionId);
}
