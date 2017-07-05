package com.way2learnonline.repository;

import java.io.Serializable;

	public interface MyCrudRepository<T,ID extends Serializable> {
	
		 T save(T entity);
		
		 T findOne(ID id);
		
		boolean exists(ID id);
	
	
		Iterable<T> findAll();
		
		long count();
	
	
		void delete(ID id);
		
		void delete(T entity);
		
		
	}

	