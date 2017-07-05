package com.way2learnonline.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

@Controller
@RequestMapping("/clusters")
public class ClusterController {
	
	
	@Autowired
	private ClusterRepository clusterRepository;
	
	@Autowired
	private ServerRepository serverRepository;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Page<ClusterDTO> getAllClusters(Pageable pageable){
		
		Page<Cluster> clusters= clusterRepository.findAll(pageable);
		
		List<ClusterDTO> clusterDTOList= new ArrayList<ClusterDTO>();
		
		
		for(Cluster cluster:clusters){			
			clusterDTOList.add(ClusterDTO.createCluster(cluster));
		}
		
		Page<ClusterDTO> clusterDTOPage= new PageImpl<ClusterDTO>(clusterDTOList,pageable,clusters.getTotalElements());
		
		return clusterDTOPage;
		
	}
	
	
	@RequestMapping(value="/{clusterId}",method=RequestMethod.GET)
	public @ResponseBody ClusterDTO getClusterById(@PathVariable("clusterId") Long clusterId){
		
		Cluster cluster=clusterRepository.findOne(clusterId);
		
		if(cluster==null){
			throw new ClusterNotFoundException("Cluster with Id "+clusterId+" Not Found");
		}
		
		return ClusterDTO.createCluster(cluster);
	}
	
	@RequestMapping(value="/{clusterId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCluster(@PathVariable("clusterId") Long clusterId){
		
		clusterRepository.delete(clusterId);
		return new ResponseEntity<String>("Cluster Deleted Successfully",HttpStatus.OK);
	}
	
	public ResponseEntity<ClusterDTO> updateCluster(@RequestBody ClusterDTO clusterDTO,@PathVariable("clusterId") Long clusterId){
		
		Cluster cluster=clusterRepository.save(clusterDTO.createCluster());
		return new ResponseEntity<ClusterDTO>(ClusterDTO.createCluster(cluster),HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> addNewCluster( @RequestBody ClusterDTO clusterDTO){
		
		Cluster cluster= new Cluster();
		cluster.setClusterName(clusterDTO.getClusterName());
		cluster.setClusterStatus(clusterDTO.getClusterStatus());
		cluster.setRunningServices(clusterDTO.getRunningServices());
		
		cluster=clusterRepository.save(cluster);
		
	
		
		URI newClusterURI=ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(cluster.getClusterId())
									.toUri();
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newClusterURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{clusterId}/servers",method=RequestMethod.GET)
	public @ResponseBody List<ServerDTO> getAllServers(@PathVariable("clusterId") Long clusterId){
		
		Iterable<Server> servers=serverRepository.findServersByClusterId(clusterId);
		
		List<ServerDTO> serverDTOs= new ArrayList<ServerDTO>();
		
		for(Server server:servers){
			serverDTOs.add(ServerDTO.createServerDTO(server));
		}
		return serverDTOs;
		
	}
	
	@RequestMapping(value="/{clusterId}/servers",method=RequestMethod.POST)
	public ResponseEntity<?> addServerToCluster(@RequestBody ServerDTO server,@PathVariable("clusterId") Long clusterId){
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
