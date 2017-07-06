package com.way2learnonline.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.way2learnonline.dto.ClusterDTO;
import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.exceptions.ServerNotFoundException;
import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.ServerRepository;

	@SuppressWarnings("unused")
	@Controller
	@RequestMapping("/servers")
	public class ServerController {
		
		@Autowired
		private ServerRepository serverRepository;
		
		@RequestMapping(method=RequestMethod.GET,produces={"application/json"})
		public @ResponseBody List<ServerDTO> getAllServers(){
			Iterable<Server>  servers=serverRepository.findAll();
			
			List<ServerDTO> serverDTOs= new ArrayList<ServerDTO>();
			
			for(Server server:servers){
				serverDTOs.add(ServerDTO.createServerDTO(server));
			}
			return serverDTOs;
		}

	
		
	
	@RequestMapping(value="/{serverId}",method=RequestMethod.GET)
	public ResponseEntity<ServerDTO> getServerById(@PathVariable("serverId") Long serverId){
		Server server=serverRepository.findOne(serverId);
		if(server==null){
			throw new ServerNotFoundException("Server with Id "+serverId+" is Not found!!");
		}
		ServerDTO serverDTO= ServerDTO.createServerDTO(server);	
		
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("myx", "1234");
		
	return 	new ResponseEntity<>(serverDTO, headers, HttpStatus.OK);
		
		
	}
	

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> addNewServer( @RequestBody ServerDTO serverDTO){
		
		Server server=serverDTO.createServer();		
		server=serverRepository.save(server);
		
		URI newServerURI=ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(server.getServerId())
									.toUri();
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newServerURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
	
	
	

}
