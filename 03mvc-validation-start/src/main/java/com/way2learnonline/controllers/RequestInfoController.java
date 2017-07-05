package com.way2learnonline.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;



import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.way2learnonline.entity.City;
import com.way2learnonline.entity.RequestInfoData;


@Controller
@SessionAttributes({"cities"})
public class RequestInfoController {
/*	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new RequestInfoDataValidator());
	}*/
	
	
	@ModelAttribute("cities")
	public List<City> getCties(){
		List<City> cities=Arrays.asList(new City("Hyderabad", "hyd"),
				new City("Bangalore", "blr"),
				new City("Delhi", "del"));
		return cities;
	}
	
	
	
	@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.GET)
	public String requestInfo(Map<String, Object>  modelMap){
		modelMap.put("requestInfo", new RequestInfoData());
		/*List<City> cities=Arrays.asList(new City("Hyderabad", "hyd"),
				new City("Bangalore", "blr"),
				new City("Delhi", "del"));*/
		
		//List<String> cities= Arrays.asList("Bangalore","Hyderabad","Delhi");
		//modelMap.put("cities", cities);
		return "requestInfo";
	}
	
	@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.POST)
	public String requestInfoPost(@ModelAttribute("requestInfo")  RequestInfoData requestInfoData,
			BindingResult result,SessionStatus  sessionStatus){
		
		if(result.hasErrors()){
			return "requestInfo";
		}		
		
		sessionStatus.setComplete();
		
		
		return "requestInfoSuccess";
	}

}
