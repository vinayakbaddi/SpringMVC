package com.way2learnonline.controllers;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.way2learnonline.entity.Course;
import com.way2learnonline.entity.Testimonial;
import com.way2learnonline.service.CourseService;
import com.way2learnonline.service.TestimonialService;

@Controller
public class CourseController {


	@Autowired
	private TestimonialService testimonialService;
	

	@Autowired
	private CourseService courseService;
	

	// TODO-2 Observe the code in this method and map this method to /viewIndividualCourse.htm and /s/viewIndividualCourse.htm
	// Inject courseId in to the method argument using corresponding annotation
	//observe the code inside corresponding jsp
	
	public String viewIndividualCourse(String courseId,	Map<String,Object> modelMap){
		
		Course course=courseService.get(courseId);
		modelMap.put("course", course );		
		List<Testimonial> testimonials=testimonialService.getTestimonialsByCourse(courseId);
		modelMap.put("testimonials", testimonials);
		
		return "viewIndividualCourse";
	}
	
	
	// TODO-3 Observe the code in this method and map this method to /browseCourses.htm and /s/browseCourses.htm for GET request	
	//observe the code inside corresponding jsp
	public String browseCourses(Map<String, Object> modelMap) {	
		
		modelMap.put("courses",courseService.getAll(false));		
		return "browseCoursesmain";
	}
	
	
	

	
}