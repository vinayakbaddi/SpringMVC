package com.way2learnonline.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.way2learnonline.entity.City;
import com.way2learnonline.entity.RequestInfoData;


@Controller

public class RequestInfoController {
	
	
	

	@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.GET)
	public String requestInfo(){	
		
	
		return "requestInfo";
	}
	
	@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.POST)
	public String requestInfoPost(){		
		
		
		
		return "requestInfoSuccess";
	}
	
	
	/*@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.POST)
	public String requestInfoPost(String name,String email,int age,String city,
		@DateTimeFormat(pattern="yyyy-MM-dd")	 Date dob, long mobile, String query,Map<String,Object> model){		
		RequestInfoData requestInfoData= new RequestInfoData();
		requestInfoData.setName(name);
		requestInfoData.setEmail(email);
		requestInfoData.setAge(age);
		requestInfoData.setCity(city);
		requestInfoData.setDob(dob);
		requestInfoData.setMobile(mobile);
		requestInfoData.setQuery(query);
		
		model.put("requestInfoData", requestInfoData);
		
		return "requestInfoSuccess";
	}
	*/
	
	/*@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.POST)
	public String requestInfoPost(){		
		return "requestInfoSuccess";
	}*/
	
	

}
