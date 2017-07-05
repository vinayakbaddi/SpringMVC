package com.way2learnonline.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MeasurementInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mav) throws Exception {
		Long startTime=(Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		Long endTime=System.currentTimeMillis();
		mav.addObject("handlingTime", endTime-startTime);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

}
