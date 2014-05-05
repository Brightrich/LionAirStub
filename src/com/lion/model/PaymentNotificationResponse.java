package com.lion.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PaymentNotificationResponse {

	private String message;
	private String bookingCode;
	private String transactionId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String toStringMulti(String name, String action, String format){    	    	
    	return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append(format+ " " + name, action)
    	.append(format+" transactionId", transactionId)
    	.append(format+" bookingCode", bookingCode)
    	.append(format+" message", message)
    	.toString();    	    	        	    	
    }
	
}
