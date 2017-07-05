package com.way2learnonline.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.way2learnonline.entity.Course;

public interface ICourseService {

	List<Course> getAll(boolean isPrivateCourse);

	Course get(String courseId);

	List<Object[]> getAllCourseIdNames(boolean isPrivateCourse);

}