package com.way2learnonline.repository;

import org.springframework.stereotype.Repository;

import com.way2learnonline.model.Server;

	@Repository
	public class ServerRepositoryImpl extends 
			MyAbstractJpaRepository<Server> implements ServerRepository {
	
		public ServerRepositoryImpl() {
			setEntityClass(Server.class);
		}
		
		
		
	}

	