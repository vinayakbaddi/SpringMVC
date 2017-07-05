package com.way2learnonline.dao;

import java.util.List;

import com.way2learnonline.entity.Course;


public interface CourseDao{

	List<Course> getAll(boolean isPrivateCourse);

	Course get(String courseId);

	List<Object[]> getAllCourseIdNames(boolean isPrivateCourse);

	

}
