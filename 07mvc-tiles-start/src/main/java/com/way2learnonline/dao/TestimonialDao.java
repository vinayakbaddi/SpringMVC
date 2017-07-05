package com.way2learnonline.dao;



import java.util.List;

import com.way2learnonline.entity.Testimonial;


public interface TestimonialDao{

	List<Testimonial> getGoodTestimonials();

	int getNumberOfTestimonialsByCourse(String courseId);

	List<Testimonial> getTestimonialsByCourse(String courseId);

	Testimonial getTestimonial(String email, String courseId);

	boolean save(Testimonial testimonial);

	boolean update(Testimonial testimonial);
	
}
