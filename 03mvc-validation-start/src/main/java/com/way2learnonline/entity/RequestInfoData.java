package com.way2learnonline.entity;



import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.way2learnonline.controllers.MySize;

public class RequestInfoData {
	
	
	private String name;
	
	
	private String email;

	private int age;
	private String city;
	
	private Date dob;
	private long mobile;
	private String query;
	private String company;
	private SocialSecurityNumber ssn;
	
	
	
	
	public SocialSecurityNumber getSsn() {
		return ssn;
	}
	public void setSsn(SocialSecurityNumber ssn) {
		this.ssn = ssn;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	
	
}
