package com.lion.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Inquiry {
	
	private String origin;
	private String destination;
	private String flightType;
	private String departureDate;
	private String returnDate;
	private String airlines;
	private String flightClass;
	private String numOfPax;
	private String outboundTimeRange;
	private String returnTimeRange;
	private String msisdn;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getNumOfPax() {
		return numOfPax;
	}
	public void setNumOfPax(String numOfPax) {
		this.numOfPax = numOfPax;
	}
	public String getOutboundTimeRange() {
		return outboundTimeRange;
	}
	public void setOutboundTimeRange(String outboundTimeRange) {
		this.outboundTimeRange = outboundTimeRange;
	}
	public String getReturnTimeRange() {
		return returnTimeRange;
	}
	public void setReturnTimeRange(String returnTimeRange) {
		this.returnTimeRange = returnTimeRange;
	}
	
	
	
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String toStringMulti(String name, String action, String format){    	    	
    	return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append(format+ " " + name, action)
    	.append(format+" origin", origin)
    	.append(format+" destination", destination)
    	.append(format+" flightType", flightType)
    	.append(format+" departureDate", departureDate)
    	.append(format+" returnDate", returnDate)
    	.append(format+" airlines", airlines)
    	.append(format+" flightClass", flightClass)
    	.append(format+" numOfPax", numOfPax)
    	.append(format+" outboundTimeRange", outboundTimeRange)
    	.append(format+" returnTimeRange", returnTimeRange)   
    	.toString();    	    	
    }
	
	
}
