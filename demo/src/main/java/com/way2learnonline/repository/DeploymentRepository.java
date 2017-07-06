package com.way2learnonline.repository;

import org.springframework.data.repository.CrudRepository;

import com.way2learnonline.model.Deployment;

public interface DeploymentRepository extends CrudRepository<Deployment, Long> {

}
