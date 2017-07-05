package com.way2learnonline.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.way2learnonline.service.AboutUsService;
import com.way2learnonline.service.CourseService;


@Controller
public class HomePageController {
	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AboutUsService aboutUsService;
	
	
	// TODO-1  Observe the code in this method and map this method to /home.htm
	//observe the code inside corresponding jsp
	public String home(Map<String, Object> modelMap){
		
		
		modelMap.put("courses",courseService.getAll(false));
		modelMap.put("aboutUs", aboutUsService.get("aboutUs123"));
		return "home";
	}
	
	
	
	
	

}
