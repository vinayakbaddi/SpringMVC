package com.way2learnonline.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
