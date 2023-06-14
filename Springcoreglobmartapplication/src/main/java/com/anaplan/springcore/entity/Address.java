package com.anaplan.springcore.entity;

public class Address {
	private String city;
    private String state;
    private int pincode;
    private Loan laon;
	
    
    public Address(String city, String state, int pincode, Loan laon) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.laon = laon;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public Loan getLaon() {
		return laon;
	}


	public void setLaon(Loan laon) {
		this.laon = laon;
	}
    
    
   

    
}
