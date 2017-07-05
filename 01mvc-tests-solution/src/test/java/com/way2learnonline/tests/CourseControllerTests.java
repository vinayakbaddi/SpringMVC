package com.way2learnonline.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import com.way2learnonline.MvcConfig;
import com.way2learnonline.entity.Course;
import com.way2learnonline.entity.Testimonial;
import com.way2learnonline.service.ICourseService;
import com.way2learnonline.service.ITestimonialService;

	@RunWith(SpringJUnit4ClassRunner.class)
	@SpringApplicationConfiguration(classes={MvcConfig.class,TestConfig.class})
	@WebAppConfiguration
	@ActiveProfiles({"test"})
	public class CourseControllerTests {
		
		private MockMvc mockMvc;
		
		@Autowired private ITestimonialService testimonialService;	
		@Autowired private ICourseService courseService;
		
		@Autowired
		private WebApplicationContext webApplicationContext;
		
		private Course course;
		
		@Before
		public void setUp(){		
			Mockito.reset(testimonialService,courseService);		
			mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
			
			
			Testimonial testimonial1= new Testimonial(5,"Hadoop Trainer was Excellent","Very Good Training");
			Testimonial testimonial2= new Testimonial(4,"Hadoop Trainer was good","Excellent Training");		
			 course= new Course("hadoop","Hadoop Course",40,6000);		
			when(courseService.get("hadoop")).thenReturn(course);
			when(testimonialService.getTestimonialsByCourse("hadoop")).thenReturn(Arrays.asList(testimonial1,testimonial2));
		}
		
	
	@Test
	public void testViewIndividualCourseWithInvalidCourseId() throws Exception{
	
		
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get("/viewIndividualCourse.htm")
														.param("courseId", "invalidCourseId");
		
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(view().name("coursenotfound"))
		.andExpect(model().attributeExists("ex"))
		.andExpect(model().attribute("ex", hasProperty("message",
					is("Course is not found!! Who asked you to type courseID in URL?")) ));
				
			
		verify(courseService,times(1)).get("invalidCourseId");
		verifyNoMoreInteractions(courseService);
		verifyZeroInteractions(testimonialService);
	}
	
	
	@Test
	public void testViewIndividualCourse() throws Exception{		
	
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get("/viewIndividualCourse.htm")
				.param("courseId", "hadoop");		
		
		
		
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(view().name("viewIndividualCourse"))	
		
		.andExpect(model().attribute("course", course))
		.andExpect(model().attribute("testimonials", hasSize(2)))
		.andExpect( 
					model().attribute(
							"testimonials", hasItem(
													allOf(
															hasProperty("rating",is(5)),
															hasProperty("title",is("Hadoop Trainer was Excellent")),
															hasProperty("description",is("Very Good Training"))
														)
													)
									)
					);
		
		
		verify(courseService,times(1)).get("hadoop");
		verifyNoMoreInteractions(courseService);		
	}
	
	

}
