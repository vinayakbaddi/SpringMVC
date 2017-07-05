package com.way2learnonline.controllers;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.way2learnonline.entity.Course;
import com.way2learnonline.entity.Testimonial;
import com.way2learnonline.exceptions.CourseNotFoundException;
import com.way2learnonline.exceptions.InvalidRequestException;
import com.way2learnonline.service.ICourseService;
import com.way2learnonline.service.ITestimonialService;

@Controller
public class CourseController {


	@Autowired
	private ITestimonialService testimonialService;
	
	

	@Autowired
	private ICourseService courseService;
	
	

	@RequestMapping(value={"/viewIndividualCourse.htm","/s/viewIndividualCourse.htm"})
	public String viewIndividualCourse(@RequestParam("courseId")String courseId, @RequestParam(value="showerror",required=false)boolean showError,
			Map<String,Object> modelMap){
		
		
		Course course=courseService.get(courseId);
		if(course==null){
			throw new CourseNotFoundException("Course is not found!! Who asked you to type courseID in URL?");
		}
		
		if(showError){
			throw new InvalidRequestException("You are really a fool !! Will any one ask to show error?");
		}
	
		modelMap.put("course", course );		
		List<Testimonial> testimonials=testimonialService.getTestimonialsByCourse(courseId);
		modelMap.put("testimonials", testimonials);
		
		return "viewIndividualCourse";
	}
	
	
	
	
	@RequestMapping(value = { "/browseCourses.htm","/s/browseCourses.htm","/s/myCourses.htm"}, method = RequestMethod.GET)
	public String browseCourses(Map<String, Object> modelMap) {	
		
		modelMap.put("courses",courseService.getAll(false));		
		return "browseCourses";
	}
	
	
	@SuppressWarnings("unused")
	private void initializeNumberOfReviews(List<Course> courses) {
		for(Course course:courses){
			course.setNumberOfReviews(testimonialService.getNumberOfTestimonialsByCourse(course.getCourseId()));
		}
	}

	
}