package com.way2learnonline.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class AboutUs implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	private String aboutUsId;
	private String tollFreeNumber;
	private String contactSupport;
	private String email;
	private String companyName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	public AboutUs() {}
	
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	
	public AboutUs(String aboutUsId) {
		super();
		this.aboutUsId = aboutUsId;
	}

	public String getAboutUsId() {
		return aboutUsId;
	}

	public void setAboutUsId(String aboutUsId) {
		this.aboutUsId = aboutUsId;
	}

	public String getTollFreeNumber() {
		return tollFreeNumber;
	}

	public void setTollFreeNumber(String tollFreeNumber) {
		this.tollFreeNumber = tollFreeNumber;
	}

	public String getContactSupport() {
		return contactSupport;
	}

	public void setContactSupport(String contactSupport) {
		this.contactSupport = contactSupport;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}