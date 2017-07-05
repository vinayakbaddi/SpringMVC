package com.way2learnonline.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.way2learnonline.model.Cluster;

	public abstract  class MyAbstractJpaRepository<T>  {
	
		@PersistenceContext private EntityManager entityManager;
		
		private Class<T> entityClass;
		
		public T save(T entity) {
			entityManager.persist(entity);
			return entity;
		}
		
		public T findOne(Serializable id) {
			
			return entityManager.find(entityClass, id);		
		}
		
		public Iterable<T> findAll() {
			List<T> clusters=entityManager.createQuery("from "+entityClass.getName(),
						entityClass).getResultList();
			return clusters;
		}
	
		
		public long count() {
			long count=(Long) entityManager.createQuery("select count(c) from "
									+entityClass.getName()+" c").getSingleResult();;
			return count;
	
		}
	
	
	public boolean exists(Serializable id) {
		return findOne(id)!=null;
	}
	
	public void delete(Serializable id) {
		entityManager.remove(findOne(id));
		
	}

	
	public void delete(T entity) {
		entityManager.remove(entity);
		
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	

}
