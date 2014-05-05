package com.lion.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Pax {
	
	private String transactionId;
	private String title;
	private String paxName;
	private String paxSSN;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPaxName() {
		return paxName;
	}
	public void setPaxName(String paxName) {
		this.paxName = paxName;
	}
	public String getPaxSSN() {
		return paxSSN;
	}
	public void setPaxSSN(String paxSSN) {
		this.paxSSN = paxSSN;
	}
	
	public String toStringMulti(String name, String action, String format){    	    	
    	return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append(format+ " " + name, action)
    	.append(format+" transactionId", transactionId)
    	.append(format+" title", title)
    	.append(format+" paxName", paxName)
    	.append(format+" paxSSN", paxSSN)    	
    	.toString();    	    	        	    	
    }
}
