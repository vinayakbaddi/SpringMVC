package com.way2learnonline.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.dao.CourseDao;
import com.way2learnonline.entity.Course;

@Service
@Transactional
public class CourseService implements ICourseService {
	@Autowired
	private CourseDao courseDao;
	
	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ICourseService#getAll(boolean)
	 */
	@Override
	@Cacheable(value="courses")
	public List<Course> getAll(boolean isPrivateCourse) {
		return courseDao.getAll(isPrivateCourse);
	}

	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ICourseService#get(java.lang.String)
	 */
	@Override
	@Cacheable(value="courses")
	public Course get(String courseId) {
		return courseDao.get(courseId);
	}

	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ICourseService#getAllCourseIdNames(boolean)
	 */
	@Override
	public List<Object[]> getAllCourseIdNames(boolean isPrivateCourse) {
		
		return courseDao.getAllCourseIdNames(isPrivateCourse);
	}
	


}
