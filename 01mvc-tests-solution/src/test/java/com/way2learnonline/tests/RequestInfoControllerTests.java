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
	
		MockHttpServletRequestBuilder requestBuilder=
				MockMvcRequestBuilders.post("/requestInfo.htm")
								.contentType(MediaType.APPLICATION_FORM_URLENCODED)
								.param("name", "siva").param("age", "111");
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(view().name("requestInfo"))
				.andExpect(model().attributeHasErrors("requestInfo"))
				.andExpect(model().attributeErrorCount("requestInfo", 1))
				.andExpect(model().attributeHasFieldErrors("requestInfo", "age"))
				.andExpect(model().attribute("requestInfo", 
											hasProperty("name",is("siva"))));
			
				
		
	}
}
