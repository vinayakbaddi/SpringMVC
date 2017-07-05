package com.way2learnonline.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.way2learnonline.model.Cluster;


	@Repository
	public class ClusterRepositoryImpl 
				extends MyAbstractJpaRepository<Cluster>
						implements ClusterRepository {
	
		public ClusterRepositoryImpl() {
			setEntityClass(Cluster.class);
			
		}
	
	}

	