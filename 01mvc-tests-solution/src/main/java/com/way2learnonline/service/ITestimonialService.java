package com.way2learnonline.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.way2learnonline.entity.Testimonial;

public interface ITestimonialService {

	List<Testimonial> getGoodTestimonials();

	int getNumberOfTestimonialsByCourse(String courseId);

	List<Testimonial> getTestimonialsByCourse(String courseId);

	Testimonial getTestimonial(String email, String courseId);

	boolean save(Testimonial testimonial);

	boolean update(Testimonial testimonial);

}