package com.way2learnonline.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.way2learnonline.model.Server;

public interface ServerRepository  extends PagingAndSortingRepository<Server, Long>{
	
	
	@Query(value=" select c.servers from Cluster c where c.clusterId=?1")
	public Iterable<Server> findServersByClusterId(Long clusterId);

}
