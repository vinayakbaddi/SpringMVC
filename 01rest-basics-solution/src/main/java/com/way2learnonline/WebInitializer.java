package com.way2learnonline;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



	public class WebInitializer extends
			AbstractAnnotationConfigDispatcherServletInitializer {
	
		@Override
		protected Class<?>[] getRootConfigClasses() {		
			return new Class[]{JpaConfig.class};
		}
	
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class[]{RestConfig.class};
		}
	
		@Override
		protected String[] getServletMappings() {
			return new String[]{"/"};
		}
	
	}
