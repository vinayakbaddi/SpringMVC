package com.way2learnonline.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.dao.TestimonialDao;
import com.way2learnonline.entity.Testimonial;

@Service
@Transactional
public class TestimonialService implements ITestimonialService  {
	@Autowired
	private TestimonialDao testimonialDao;

	
	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ITestimonialService#getGoodTestimonials()
	 */
	@Override
	@Cacheable(value="testimonials")
	public List<Testimonial> getGoodTestimonials() {
		
		return testimonialDao.getGoodTestimonials();
	}

	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ITestimonialService#getNumberOfTestimonialsByCourse(java.lang.String)
	 */
	@Override
	@Cacheable(value="testimonials")
	public int getNumberOfTestimonialsByCourse(String courseId) {
		
		return testimonialDao.getNumberOfTestimonialsByCourse(courseId);
	}

	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ITestimonialService#getTestimonialsByCourse(java.lang.String)
	 */
	@Override
	@Cacheable(value="testimonials",key="'getTestimonialsByCourse'+#courseId")
	public List<Testimonial> getTestimonialsByCourse(String courseId) {
		if(courseId.equals("0")){
			return getGoodTestimonials();
		}
		return testimonialDao.getTestimonialsByCourse(courseId);
	}

	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ITestimonialService#getTestimonial(java.lang.String, java.lang.String)
	 */
	@Override
	public Testimonial getTestimonial(String email, String courseId) {
		return testimonialDao.getTestimonial(email,courseId);
	}

	
	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ITestimonialService#save(com.way2learnonline.entity.Testimonial)
	 */
	@Override
	public boolean save(Testimonial testimonial) {
		return testimonialDao.save(testimonial);
	}

	
	/* (non-Javadoc)
	 * @see com.way2learnonline.service.ITestimonialService#update(com.way2learnonline.entity.Testimonial)
	 */
	@Override
	public boolean update(Testimonial testimonial) {
		return testimonialDao.update(testimonial);
	}
	
	

}
