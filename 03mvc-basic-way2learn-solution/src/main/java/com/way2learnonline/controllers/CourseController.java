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
	
	HttpServletRequest req;

	@Autowired
	private CourseService courseService;
	

	@RequestMapping(value={"/viewIndividualCourse.htm","/s/viewIndividualCourse.htm"})
	public String viewIndividualCourse(@RequestParam("courseId")String courseId,
			Map<String,Object> modelMap){
		
		Course course=courseService.get(courseId);
		modelMap.put("course", course );		
		//List<Testimonial> testimonials=testimonialService.getTestimonialsByCourse(courseId);
		//modelMap.put("testimonials", testimonials);
		
		return "viewIndividualCourse";
	}
	
	
	
	
	@RequestMapping(value = { "/browseCourses.htm","/s/browseCourses.htm","/s/myCourses.htm"}, method = RequestMethod.GET)
	public String browseCourses(Map<String, Object> modelMap) {	
		
		modelMap.put("courses",courseService.getAll(false));		
		return "browseCoursesmain";
	}
	
	
	@SuppressWarnings("unused")
	private void initializeNumberOfReviews(List<Course> courses) {
		for(Course course:courses){
			course.setNumberOfReviews(testimonialService.getNumberOfTestimonialsByCourse(course.getCourseId()));
		}
	}

	
}