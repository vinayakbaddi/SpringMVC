package com.way2learnonline.entity;

public class SocialSecurityNumber {
	
	private String area;
	private String group;
	private String serial;
	
	@Override
	public String toString() {
		return area+"-"+group+"-"+serial;
	}
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	

}
