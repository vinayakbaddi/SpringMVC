package com.way2learnonline.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.entity.Course;

@Repository
public class CourseDaoImpl implements CourseDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAll(boolean isPrivateCourse) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Course ")
					//.setBoolean("privateCourse", isPrivateCourse)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override	
	public Course get(String courseId) {
		try {
			return (Course)sessionFactory.getCurrentSession()
					.createQuery("from Course where courseId=:courseId")
					.setString("courseId", courseId)
					.setMaxResults(1)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> getAllCourseIdNames(boolean isPrivateCourse) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery("select courseId,name from Course where privateCourse=:privateCourse order by name asc")
					.setBoolean("privateCourse", isPrivateCourse)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
