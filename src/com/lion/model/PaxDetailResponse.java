package com.lion.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PaxDetailResponse {

	private String message;
	private String paymentCode;
	private String transactionId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
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
    	.append(format+" paymentCode", paymentCode)
    	.append(format+" message", message)
    	.toString();    	    	        	    	
    }
	
}
