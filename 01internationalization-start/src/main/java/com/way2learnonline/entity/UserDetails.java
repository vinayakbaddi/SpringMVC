package com.way2learnonline.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class UserDetails{

	
	@Id
	private String email;	
	private String location;
	@Temporal(TemporalType.DATE)
	private Date dob;	
	private String id;
	private String fullName;
	
	
	private String phoneNumber;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	
	
		
}
