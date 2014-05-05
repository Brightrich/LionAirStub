package com.lion.model;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BookingResponse extends Transaction{
	private String baseFare;
	private String additionalFees;

	public String getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(String baseFare) {
		this.baseFare = baseFare;
	}
	public String getAdditionalFees() {
		return additionalFees;
	}
	public void setAdditionalFees(String additionalFees) {
		this.additionalFees = additionalFees;
	}
	
	public String toStringMulti(String name, String action, String format){    	    	
    	return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).appendSuper(super.toStringMulti(name, action, format))
    	.append(format+" baseFare ", baseFare)
    	.append(format+" additionalFees ", additionalFees)
    	.toString();
    }
	
}
