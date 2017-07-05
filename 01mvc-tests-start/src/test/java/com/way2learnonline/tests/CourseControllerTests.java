package com.way2learnonline.tests;

import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


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
	public class CourseControllerTests {
		
		private MockMvc mockMvc;
		
		@Autowired private ITestimonialService testimonialService;	
		@Autowired private ICourseService courseService;
		
		//TODO-1 Declare and  Inject WebApplicationContext by uncommenting below
		
		
		
		private Course course;
		
		@Before
		public void setUp(){		
			Mockito.reset(testimonialService,courseService);
			
			//TODO-2 initialize mockMVC by uncommenting below 
			
			mockMvc=null;
			
			
			Testimonial testimonial1= new Testimonial(5,"Hadoop Trainer was Excellent","Very Good Training");
			Testimonial testimonial2= new Testimonial(4,"Hadoop Trainer was good","Excellent Training");	
			
			 course= new Course("hadoop","Hadoop Course",40,6000);		
			 
			 
			when(courseService.get("hadoop")).thenReturn(course);
			when(testimonialService.getTestimonialsByCourse("hadoop")).thenReturn(Arrays.asList(testimonial1,testimonial2));
		}
		
	
	@Test
	public void testViewIndividualCourseWithInvalidCourseId() throws Exception{
	
		//TODO -3 We want to make a get request to /viewIndividualCourse.htm and send query parameter courseId.
		//So you need to create a request builder by uncommenting below line
		
		
		
	//	MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get("/viewIndividualCourse.htm");
		
		//TODO-4 Add a request parameter courseId with value "invalidCourseId" by uncommenting below line
		
	//	requestBuilder.param("courseId", "invalidCourseId");
		
		
		//TODO-5 perform the request by uncommenting below. You will get an object of ResultActions on which you can assert.
		//ResultActions  resultActions=mockMvc.perform(requestBuilder);
		
		//TODO-6 assert that the  response Status is OK by uncommenting below
		
		//TODO-7 assert that the  view name is coursenotfound by uncommenting below
		//resultActions.andExpect(view().name("coursenotfound"));
		
		//TODO-8 Assert that there wil be  a model attribute with name "ex"  by uncommenting below
		//resultActions.andExpect(model().attributeExists("ex"));
		
		//TODO-8 Assert that the model attribute ex has a property "message" with value "Course is not found!! Who asked you to type courseID in URL?" by uncommenting below
		/*resultActions.andExpect(model().attribute("ex", hasProperty("message",
					is("Course is not found!! Who asked you to type courseID in URL?")) ));
		*/		
			
		verify(courseService,times(1)).get("invalidCourseId");
		verifyNoMoreInteractions(courseService);
		verifyZeroInteractions(testimonialService);
	}
	
	
	@Test
	
	public void testViewIndividualCourse() throws Exception{		
		
		//TODO -9 We want to make a get request to /viewIndividualCourse.htm and send query parameter courseId with value hadoop.
		// So, prepare a request builder by uncommenting below 		
			
	
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get("/viewIndividualCourse.htm")
											.param("courseId", "hadoop");		
		
		
		//TODO-10 perform the request by uncommenting below. You will get an object of ResultActions on which you can assert.
		ResultActions resultActions= mockMvc.perform(requestBuilder);
		
		
		//TODO-11 assert that the  response Status is OK and view name is "viewIndividualCourse"  by uncommenting below
		
		 resultActions.andExpect(status().isOk());
		resultActions.andExpect(view().name("viewIndividualCourse"));	
			
				
		// TODO-12 Assert that the  value of model attribute "course"  is same as course object
		
		
		resultActions.andExpect(model().attribute("course", course));
		// TODO -13 assert that the size of modelattribute "testimonials" is 2 by uncommenting below
		
		resultActions.andExpect(model().attribute("testimonials", hasSize(1)));
		
		//TODO-14 Assert that model attribute "testimonials" which is a collection has an item with properties rating=5, title="Hadoop Trainer was Excellent" and
		// desription =Very Good Training by uncommenting as  below
		
		resultActions.andExpect( 
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
