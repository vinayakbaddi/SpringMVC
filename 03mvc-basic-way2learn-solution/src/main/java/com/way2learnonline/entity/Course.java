package com.way2learnonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table
public class Course {
	
	@Id
	private String courseId;
	private String name;
	@Column(length=500)
	private String description;
	private int durationInHours;
	private int numberOfViews;
	private int numberOfLearners;
	private int price;
	private int priceUSD;
	private int rating;
	private String imageName;

	@Transient
	private int numberOfReviews;
	
	

	public int getPriceUSD() {
		return priceUSD;
	}
	public void setPriceUSD(int priceUSD) {
		this.priceUSD = priceUSD;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public int getNumberOfViews() {
		return numberOfViews;
	}
	public void setNumberOfViews(int numberOfViews) {
		this.numberOfViews = numberOfViews;
	}
	public int getNumberOfLearners() {
		return numberOfLearners;
	}
	public void setNumberOfLearners(int numberOfLearners) {
		this.numberOfLearners = numberOfLearners;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getNumberOfReviews() {
		return numberOfReviews;
	}
	public void setNumberOfReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}
	
	
	
}
