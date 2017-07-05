package com.way2learnonline.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.way2learnonline.service.IAboutUsService;
import com.way2learnonline.service.ICourseService;


@Controller
public class HomePageController {
	
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IAboutUsService aboutUsService;
	
	@RequestMapping("/home.htm")
	public String home(Map<String, Object> modelMap){
		
		
		modelMap.put("courses",courseService.getAll(false));
		modelMap.put("aboutUs", aboutUsService.get("aboutUs123"));
		return "baseLayout";
	}
	
	
	
	
	

}
