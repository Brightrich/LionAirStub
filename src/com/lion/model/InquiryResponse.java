package com.lion.model;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class InquiryResponse extends Inquiry{
	private Schedule[] outboundSchedules;
	private Schedule[] returnSchedules;
	public Schedule[] getOutboundSchedules() {
		return outboundSchedules;
	}
	public void setOutboundSchedules(Schedule[] outboundSchedules) {
		this.outboundSchedules = outboundSchedules;
	}
	public Schedule[] getReturnSchedules() {
		return returnSchedules;
	}
	public void setReturnSchedules(Schedule[] returnSchedules) {
		this.returnSchedules = returnSchedules;
	}

	
	public String toStringMulti(String name, String action, String format){    	    	
    	return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).appendSuper(super.toStringMulti(name, action, format))
    	.append(format+" outboundSchedules ", Arrays.toString(outboundSchedules))
    	.append(format+" outboundSchedules ", Arrays.toString(outboundSchedules))
    	.toString();
    }
	
}
