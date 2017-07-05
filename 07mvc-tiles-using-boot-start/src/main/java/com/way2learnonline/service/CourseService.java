package com.way2learnonline.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.dao.CourseDao;
import com.way2learnonline.entity.Course;

@Service

public class CourseService {
	@Autowired
	private CourseDao courseDao;
	
	@Cacheable(value="courses")
	@Transactional
	public List<Course> getAll(boolean isPrivateCourse) {
		return courseDao.getAll(isPrivateCourse);
	}

	@Cacheable(value="courses")
	@Transactional
	public Course get(String courseId) {
		return courseDao.get(courseId);
	}

	public List<Object[]> getAllCourseIdNames(boolean isPrivateCourse) {
		
		return courseDao.getAllCourseIdNames(isPrivateCourse);
	}
	


}
