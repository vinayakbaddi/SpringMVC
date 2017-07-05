package com.way2learnonline.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.way2learnonline.entity.City;
import com.way2learnonline.entity.RequestInfoData;


@Controller
@SessionAttributes({"cities"})
public class RequestInfoController {
	
	
	@ModelAttribute("cities")
	public List<City> getCities(){
		System.err.println("RequestInfoController.getCities()");
		List<City> cities=Arrays.asList(new City("Hyderabad", "hyd"),
				new City("Bangalore", "blr"),
				new City("Delhi", "del"));
		
		
		return cities;
	}
	
	@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.GET)
	public String requestInfo(Map<String, Object>  modelMap){
		modelMap.put("requestInfoData", new RequestInfoData());
		
		List<String> cities= Arrays.asList("Bangalore","Hyderabad","Delhi");
		modelMap.put("cities", cities);
		/*List<City> cities=Arrays.asList(new City("Hyderabad", "hyd"),
				new City("Bangalore", "blr"),
				new City("Delhi", "del"));*/
	
		//
		return "requestInfo";
	}
	
	
	@RequestMapping(value={"/requestInfo.htm","/s/requestInfo.htm"},method=RequestMethod.POST)
	public String requestInfoPost(@ModelAttribute("requestInfoData") RequestInfoData requestInfoData,
						BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return "requestInfo";
		}	
		
		redirectAttributes.addAttribute("name",requestInfoData.getName());
		redirectAttributes.addAttribute("email",requestInfoData.getEmail());
		
		redirectAttributes.addFlashAttribute("requestInfoData", requestInfoData);
			
		
		return "redirect:requestInfoSuccessRedirect";
	}
	
	@RequestMapping("requestInfoSuccessRedirect")
	public String requestInfoSuccessRedirect(){
	
		return  "requestInfoSuccess";
	}

}
