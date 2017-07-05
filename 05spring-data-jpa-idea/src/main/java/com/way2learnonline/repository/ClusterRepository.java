package com.way2learnonline.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.way2learnonline.model.Cluster;

public interface ClusterRepository extends MyCrudRepository<Cluster, Serializable> {

}
