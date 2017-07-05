package com.way2learnonline.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way2learnonline.dao.AboutUsDao;
import com.way2learnonline.entity.AboutUs;

@Service
@Transactional
public class AboutUsService {
	@Autowired
	private AboutUsDao aboutUsDao;
	
	@Cacheable(value="aboutus")
	public AboutUs get(String primaryKey) {
		return aboutUsDao.get(primaryKey);
	}

}
