package com.way2learnonline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.way2learnonline.model.Cluster;

@RepositoryRestResource(itemResourceRel="cluster",collectionResourceRel="clusters")
public interface ClusterRepository extends PagingAndSortingRepository<Cluster, Long> {

}
