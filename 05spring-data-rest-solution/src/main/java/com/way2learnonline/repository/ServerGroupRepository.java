package com.way2learnonline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.way2learnonline.model.ServerGroup;

@RepositoryRestResource
public interface ServerGroupRepository extends CrudRepository<ServerGroup, Long> {

}
