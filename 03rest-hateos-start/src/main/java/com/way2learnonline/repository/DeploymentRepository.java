package com.way2learnonline.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.way2learnonline.model.Deployment;
import com.way2learnonline.model.Server;

public interface DeploymentRepository extends CrudRepository<Deployment, Long> {

	@Query(value=" select s.deployments from Server s where s.serverId=?1")
	public Iterable<Deployment> findDeploymentsByServerId(Long serverId);
	
	@Query(value="select d.servers from Deployment d where d.deploymentId=?1")
	public Iterable<Server> findServersByDeploymentId(Long deploymentId);

}
