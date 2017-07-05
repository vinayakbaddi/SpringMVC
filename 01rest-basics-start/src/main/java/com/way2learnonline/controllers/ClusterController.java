package com.way2learnonline.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.way2learnonline.dto.ClusterDTO;
import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.exceptions.ClusterNotFoundException;
import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.ServerRepository;

//@Controller

public class ClusterController {
	
	
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private ServerRepository serverRepository;
	
	
	// TODO -7  Map this method to  GET /clusters . 
	//Make sure to annotate the return value with appropriate annotation so that a HttpMessageConverter will be used to convert return value into required representation
	
	public  List<ClusterDTO> getAllClusters(){
		
		Iterable<Cluster> clusters= clusterRepository.findAll();
		
		List<ClusterDTO> clusterDTOList= new ArrayList<ClusterDTO>();
		for(Cluster cluster:clusters){			
			clusterDTOList.add(ClusterDTO.createCluster(cluster));
		}
		
		return clusterDTOList;
		
	
	}
	
	
	// TODO -8  Map this method to GET /clusters/{clusterId}
		// Annotate the method argument clusterId such that the pathvariable {clusterId} is injected
		//Make sure to annotate the return value with appropriate annotation so that a HttpMessageConverter will be used to convert return value into required representation
		
	public  ClusterDTO getClusterById( Long clusterId){
		
		Cluster cluster=clusterRepository.findOne(clusterId);
		
		if(cluster==null){
			throw new ClusterNotFoundException("Cluster with Id "+clusterId+" Not Found");
		}
		
		return ClusterDTO.createCluster(cluster);
	}
	
	
	//TODO-9 Map this method to DELETE /clusters/{clusterId}
	// Annotate the method argument clusterId such that the pathvariable {clusterId} is injected
	public ResponseEntity<String> deleteCluster( Long clusterId){
		
		clusterRepository.delete(clusterId);
		return new ResponseEntity<String>("Cluster Deleted Successfully",HttpStatus.OK);
	}
	
	
	//TODO -10 MAP this method to PUT /clusters/{clusterID}
	// Annotate the method argument clusterId such that the pathvariable {clusterId} is injected
	//Make sure to annotate the method argument clusterDTO value with appropriate annotation so that a HttpMessageConverter will be used to convert
	//request body to ClusterDTO
	
	// Observe how Reponse entity is created
	public ResponseEntity<ClusterDTO> updateCluster( ClusterDTO clusterDTO, Long clusterId){
		
		Cluster cluster=clusterRepository.save(clusterDTO.createCluster());
		return new ResponseEntity<ClusterDTO>(ClusterDTO.createCluster(cluster),HttpStatus.OK);
	}
	
	
	// TODO-11 Map this method for POST /clusters
		// Annotate the method argument such that the data in  request body will be converted to java object and  injected
	public ResponseEntity<?> addNewCluster(  ClusterDTO clusterDTO){
		
		Cluster cluster= new Cluster();
		cluster.setClusterName(clusterDTO.getClusterName());
		cluster.setClusterStatus(clusterDTO.getClusterStatus());
		cluster.setRunningServices(clusterDTO.getRunningServices());
		
		cluster=clusterRepository.save(cluster);
		
	
		//TODO -12 Initialize the new Cluster URI using the below code 
		
		/*ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(cluster.getClusterId())
		.toUri();*/
		
		URI newClusterURI=null;
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newClusterURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
	
// TODO -13 map this method to GET /clusters/{clusterID}/servers
	//Make sure tha path variable is injected into method argument
	//Make sure to annotate the return value with appropriate annotation so that a HttpMessageConverter will be used to convert return value into required representation
	
	public  List<ServerDTO> getAllServers(Long clusterId){
		
		Iterable<Server> servers=serverRepository.findServersByClusterId(clusterId);
		
		List<ServerDTO> serverDTOs= new ArrayList<ServerDTO>();
		
		for(Server server:servers){
			serverDTOs.add(ServerDTO.createServerDTO(server));
		}
		return serverDTOs;
		
	}
	
	// TODO -14 map this method to POST /clusters/{clusterId}/servers
	public ResponseEntity<?> addServerToCluster( ServerDTO server, Long clusterId){
		Cluster cluster=clusterRepository.findOne(clusterId);
		cluster.addServer(server.createServer());
		
		clusterRepository.save(cluster);
		URI newserverURI=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(server.getServerId())
				.toUri();
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newserverURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
		

}
