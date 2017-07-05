package com.way2learnonline.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.way2learnonline.model.Server;

public interface ServerRepository  extends CrudRepository<Server, Serializable>{
	
	
	
}
