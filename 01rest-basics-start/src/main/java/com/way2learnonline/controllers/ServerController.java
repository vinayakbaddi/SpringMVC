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
import com.way2learnonline.exceptions.ServerNotFoundException;
import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.ServerRepository;

//@Controller
//TODO -1 map this controllers class to /servers
public class ServerController {
	
	@Autowired
	private ServerRepository serverRepository;
	
	// TODO -2  Map this method to  GET /servers . 
	//Make sure to annotate the return value with appropriate annotation so that a HttpMessageConverter will be used to convert return value into required representation
	
	public List<ServerDTO> getAllServers(){
		Iterable<Server>  servers=serverRepository.findAll();
		
		List<ServerDTO> serverDTOs= new ArrayList<ServerDTO>();
		
		for(Server server:servers){
			serverDTOs.add(ServerDTO.createServerDTO(server));
		}
		return serverDTOs;
	}
	
	
	// TODO -3  Map this method to GET /servers/{serverId}
	// Annotate the method argument serverID such that the pathvariable {serverID} is injected
	//Make sure to annotate the return value with appropriate annotation so that a HttpMessageConverter will be used to convert return value into required representation
	
	public  ServerDTO getServerById( Long serverId){
		Server server=serverRepository.findOne(serverId);
		if(server==null){
			throw new ServerNotFoundException("Server with Id "+serverId+" is Not found!!");
		}
		return ServerDTO.createServerDTO(server);
		
		
	}
	

	
	
	// TODO-5 Map this method for POST /servers
	// Annotate the method argument such that the data in  request body will be converted to java object and  injected
	public ResponseEntity<?> addNewServer(  ServerDTO serverDTO){
		
		Server server=serverDTO.createServer();
		
		server=serverRepository.save(server);
		
		
	
		//TODO-6  Initialize the newServerURI.
		
		URI newServerURI= null; 
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newServerURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
	
	
	

}
