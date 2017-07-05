package com.way2learnonline.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Address implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	private String addressId;
	private String pinCode;
	private String streetLine1;
	private String streetLine2;
	private String city;
	private String state;
	private String country;
	
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return country;
	}
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getStreetLine1() {
		return streetLine1;
	}
	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}
	public String getStreetLine2() {
		return streetLine2;
	}
	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
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
	public Address() {}
	public Address(String addressId, String pinCode, String streetLine1,
			String streetLine2, String city, String state) {
		super();
		this.addressId = addressId;
		this.pinCode = pinCode;
		this.streetLine1 = streetLine1;
		this.streetLine2 = streetLine2;
		this.city = city;
		this.state = state;
	}
	
}
