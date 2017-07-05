package com.way2learnonline.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping("/home.htm")
	public String home(Map<String, Object> modelMap){
		System.err.println("HomePageController.home()==================");
		
		modelMap.put("courses",courseService.getAll(false));
		modelMap.put("aboutUs", aboutUsService.get("aboutUs123"));
		return "home";
	}
	
	
	
	
	

}
