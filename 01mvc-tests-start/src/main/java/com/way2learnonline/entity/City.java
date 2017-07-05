package com.way2learnonline.entity;

public class City {
	
	
	private String cityName;
	private String cityCode;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public City(String cityName, String cityCode) {
		super();
		this.cityName = cityName;
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	

}
