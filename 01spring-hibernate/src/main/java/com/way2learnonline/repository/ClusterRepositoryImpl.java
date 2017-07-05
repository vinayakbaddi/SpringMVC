package com.way2learnonline.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.way2learnonline.model.Cluster;

@Repository
public class ClusterRepositoryImpl implements ClusterRepository {
	
	@Autowired private SessionFactory sessionFactory;

	@Override
	public Cluster save(Cluster cluster) {
		  sessionFactory.getCurrentSession().saveOrUpdate(cluster);		
		return cluster;
	}

	@Override
	public Cluster findOne(Long id) {
		return (Cluster)(sessionFactory.getCurrentSession().get(Cluster.class, id));
		
	}
	
	

	@Override
	public boolean exists(Long id) {
		
		return findOne(id)!=null;
	}

	@Override
	public Iterable<Cluster> findAll() {
		List<Cluster> clusters=sessionFactory.getCurrentSession().createQuery("from Clusters").list();
		return clusters;
	}

	@Override
	public long count() {
		long count=(long) sessionFactory.getCurrentSession().createQuery("select count(c) from Cluster c").uniqueResult();
		return 0;
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(findOne(id));

	}

	@Override
	public void delete(Cluster entity) {
		sessionFactory.getCurrentSession().delete(entity);

	}

	

}
