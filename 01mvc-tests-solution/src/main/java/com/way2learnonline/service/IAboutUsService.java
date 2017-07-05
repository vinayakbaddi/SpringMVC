package com.way2learnonline.service;

import org.springframework.cache.annotation.Cacheable;

import com.way2learnonline.entity.AboutUs;

public interface IAboutUsService {

	AboutUs get(String primaryKey);

}