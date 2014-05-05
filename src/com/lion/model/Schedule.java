package com.lion.model;

public class Schedule {

	
	private String flightKey;
	private String flightNumber;
	private String departureTime;
	private String arrivalTime;
	private String price;
	
	public Schedule (String flightKey, String flightNumber, String departureTime, String arrivalTime, String price){
		this.flightKey = flightKey;
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}
	
	public String getFlightKey() {
		return flightKey;
	}
	public void setFlightKey(String flightKey) {
		this.flightKey = flightKey;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
