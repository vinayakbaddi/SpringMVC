package com.way2learnonline.tests;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.way2learnonline.MvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={MvcConfig.class,TestConfig.class})
@WebAppConfiguration
public class RequestInfoControllerTests {

	private MockMvc mockMvc;	

	@Autowired
	private WebApplicationContext webApplicationContext;	

	
	@Before
	public void setUp(){		
			
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();			
		
	
	}
	
	@Test
	public void testRequestInfoPOst() throws Exception{
		
		//  TODO-15  We want to make a post request to /requestInfo.htm and send name="siva" and age=111 ans email="sivaemail".
		//Since it is post request, content type should be "application/x-www-form-urlencoded"
		
		//Prepare a request builder by uncommenting the below code
	
		MockHttpServletRequestBuilder requestBuilder=null;/*MockMvcRequestBuilders.post("/requestInfo.htm")
								.contentType(MediaType.APPLICATION_FORM_URLENCODED)
								.param("name", "siva").param("age", "12").param("email", "xyz");*/
		
		ResultActions resultActions= mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(view().name("requestInfo"));
		
		//TODO -16 Assert that the model Attribute with name "requestInfo" has errors by uncommenting below 
		
	//resultActions.andExpect(model().attributeHasErrors("requestInfo"));
		
		// TODO-17 Assert that there are 2 errors for model attribute with name "requestInfo" by uncommenting below 
		//resultActions.andExpect(model().attributeErrorCount("requestInfo", 2));
		
		// TODO-18 Assert that there are field errors for age and email in requestInfo by uncommenting below 
		//resultActions.andExpect(model().attributeHasFieldErrors("requestInfo", "age","email"));
		
		
		// TODO-19 Assert that the model Attribute requestInfo has a property name and its value is siva by uncommenting below
		//resultActions.andExpect(model().attribute("requestInfo", hasProperty("name",is("siva"))));
			
				
		
	}
}
