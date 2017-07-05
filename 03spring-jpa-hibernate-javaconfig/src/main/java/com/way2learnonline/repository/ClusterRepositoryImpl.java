package com.way2learnonline.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.way2learnonline.model.Cluster;

@Component

public class ClusterRepositoryImpl implements ClusterRepository {
	
	@PersistenceContext private EntityManager entityManager;

	@Override
	public Cluster save(Cluster cluster) {
		entityManager.persist(cluster);
		  
		
		return cluster;
	}

	@Override
	public Cluster findOne(Long id) {
		return entityManager.find(Cluster.class, id);		
		
	}

	@Override
	public boolean exists(Long id) {
		
		return findOne(id)!=null;
	}

	@Override
	public Iterable<Cluster> findAll() {
		List<Cluster> clusters=entityManager.createQuery("from Cluster", Cluster.class).getResultList();
		return clusters;
	}

	@Override
	public long count() {
		
		long count=(Long) entityManager.createQuery("select count(c) from Cluster c").getSingleResult();;
		return count;
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(findOne(id));

	}

	@Override
	public void delete(Cluster entity) {
		entityManager.remove(entity);

	}

	

}
