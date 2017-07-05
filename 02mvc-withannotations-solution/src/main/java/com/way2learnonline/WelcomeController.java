package com.way2learnonline;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

	
	@Controller
	public class WelcomeController { 
		
	
		
		
		// TODO-1 Write a method withName sayWelcome to accept request coming for /welcome.htm.
		//make return type of this method as  String. return "/WEB-INF/jsp/w.jsp"
		//This method should add "welcome to Spring@MVC" as a model  with name message.
		//
		@RequestMapping("/welcome.htm")
		public String sayWelcome(Model model){
			model.addAttribute("message", "welcome to Spring@Mvc");
			return  "w";
		}
	
		
		
		// TODO-2 map the below method to accepts requestcoming for /welcomeuser.htm along with request parameter "name"
		// Inject request parameter in to method argument.
		//add model attribue with name message and value should be "Welcome Siva  " if name is passed as Siva		
		//make return type of this method as  String. return "welcometouser".
		// Open welcometouser.jsp under /WEB-INF/jsp folder and observe the code in it.		
		// Deploy the application and make sure "Hi Welcome Siva" if  request parameter "name=Siva" 
		/*@RequestMapping("/welcomeuser.htm")
		public String sayWelcomeToUser(@RequestParam("name") String name,Model model){
			
			model.addAttribute("message", "Welcome "+name);
			
			return "welcometouser";
			
		}*/
		
		// TODO-3 Give a request to /welcomeuser.htm and dont pass request parameter name and 
		//observe that you get an error.
		//Now Make the request parameter optional and test it again
		
		/*@RequestMapping("/welcomeuser.htm")
		public String sayWelcomeToUser(@RequestParam(value="name",required=false) String name,Model model){
			
			model.addAttribute("message", "Welcome "+name);
			
			return "welcometouser";
			
		}*/
		
		
		// TODO-4 Modify the above method so that it will be invoked only if there is a 
		//request parameter  "name"  and its value is "Siva"  		
		//Deploy the application and make a request  to /welcomeuser.htm?name=Prasad . make sure that you get an error
		
		@RequestMapping(value="/welcomeuser.htm",params={"name=Siva"})
		public String sayWelcomeToUserOptional(@RequestParam(value="name") String name,Model model){
			
			model.addAttribute("message", "Welcome "+name);
			
			return "welcometouser";
			
		}
		
		// TODO-5 Modify the above method so that you can access the request parameter 
		//using HttpServletRequest. Keep the request parameter in HttpSession.
		//Deploy the application  and test by making a request to /welcomeuser.htm?name=Siva .
		
		// TODO-6 Modify the request mapping of the above method so that it can be accessible over 
		// GET and also POST request. Try by making a post request to the above URL
		
		
		
		
		//TODO-7   map the below to url  :/welcome/{firstName}/{lastName} .
		// Inject path variables firstname and last name in to the method aruments
		// Deploy the application and give request to /welcome/siva/prasad.htm
		
		public String welcome(String firstName,String lastName ,Map<String, Object> modelMap){
			
			modelMap.put("message",  "Welcome to Spring@MVC "+firstName+"  "+lastName);
			return "w";
		}
		
		//TODO-8 map the below method to be invoked for /welcome/{dob}. Inject dob into method argument of type Date
		//Make sure that the date format should be in dd-MM-yyyy format only
		// Deploy the application and try to pass date in other format and expected format. Observe what happens in both scenarios.
		
			
		public String welcome(  Date dob,Map<String,Object> modelMap){
			
			modelMap.put("message", "Welcome to Spring MVC!!!" +dob );
			return "welcome";
		} 
		
		// TODO-9 If you observe web.xml, you have mapped it to *.htm. 
		//Modify it so that it is mapped to / . Now give a request to a static resource (logo.png)
		//present in the webapp. it will not be accessible. 
		//Can u think of a reason why it is not accessible even though it is a static resource?
		// Now make configurations changes so that static resources will be accessible.
		// Hint :<mvc:annotation-driven />
		
		
		// TODO-10 I want to just give request to /home. 
		//There is no business logic to be executed before rendering home page 
		//I dont want to write a method in my controller class.
		// So, configure a view controller for /home so that it will render /WEB-INF/jsp/home.jsp
		// Deploy the application and test it.
		
		// TODO-11  Write configuration such that when ever i give a request for /google, 
		//it should be redirected to www.google.com
		// Deploy the application and test it.
 	
	}
