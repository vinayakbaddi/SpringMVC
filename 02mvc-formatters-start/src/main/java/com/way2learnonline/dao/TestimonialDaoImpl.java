package com.way2learnonline.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.way2learnonline.entity.Testimonial;
@Repository
public class TestimonialDaoImpl implements TestimonialDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override

	public List<Testimonial> getGoodTestimonials() {
		try {
			
			List<Testimonial> testimonials=sessionFactory.getCurrentSession()
			.createQuery("from Testimonial t left join fetch t.purchase p where t.rating>4")
			.list();
		
			return testimonials;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	
	public int getNumberOfTestimonialsByCourse(String courseId) {
		try {
			return (int)((long)sessionFactory.getCurrentSession()
					.createQuery("select count(*) from Testimonial t join t.purchase.course c where c.courseId=:courseId")
					.setString("courseId", courseId)
					.setMaxResults(1)
					.uniqueResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Testimonial> getTestimonialsByCourse(String courseId) {
		try {
			
			List<Testimonial> testimonials=sessionFactory.getCurrentSession()
					.createQuery("from Testimonial t  join fetch t.purchase p where p.course.courseId=:courseId order by p.testimonial.rating desc")
					.setString("courseId", courseId)
					.setFirstResult(0)
					.setMaxResults(20)
					.list();
			
			
		/*	List<Purchase> purchases=sessionFactory.getCurrentSession()
			.createQuery("from Purchase p where p.course.courseId=:courseId and p.testimonial is not null order by p.testimonial.rating desc")
			.setString("courseId", courseId)
			.setFirstResult(0)
			.setMaxResults(20)
			.list();
			List<Testimonial> testimonials=new ArrayList<Testimonial>();
			for(Purchase purchase:purchases){
				 purchase.getTestimonial().setPurchase(purchase);
				 testimonials.add(purchase.getTestimonial());
			}*/
			return testimonials;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override

	public Testimonial getTestimonial(String email, String courseId) {
		try {
			return (Testimonial)sessionFactory.getCurrentSession().createQuery("from Testimonial t where t.purchase.userDetails.email=:email and t.purchase.course.courseId=:courseId")
			.setString("courseId", courseId)
			.setString("email", email)
			.setMaxResults(1)
			.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override

	public boolean save(Testimonial testimonial) {
		try {
			sessionFactory.getCurrentSession().save(testimonial);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override

	public boolean update(Testimonial testimonial) {
		
		try {
			sessionFactory.getCurrentSession().update(testimonial);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
