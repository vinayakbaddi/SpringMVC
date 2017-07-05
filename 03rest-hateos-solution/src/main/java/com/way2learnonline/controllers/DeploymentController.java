package com.way2learnonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.way2learnonline.dto.DeploymentDTO;
import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.model.Deployment;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.DeploymentRepository;

@Controller
@RequestMapping("/deployments")
public class DeploymentController {
	
	@Autowired private DeploymentRepository deploymentRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<DeploymentDTO> getAllDeployments(){
		Iterable<Deployment> deployments=deploymentRepository.findAll();	
		return DeploymentResourceCreator.toResources(deployments);
	}
	
	
	@RequestMapping(value="/{deploymentId}",method=RequestMethod.GET)
	public @ResponseBody DeploymentDTO getDeploymentById(@PathVariable Long deploymentId){
		Deployment deployment=deploymentRepository.findOne(deploymentId);			
		return DeploymentResourceCreator.toResource(deployment);
		
	}
	
	@RequestMapping(value="/{deploymentId}/servers",method=RequestMethod.GET)
	public @ResponseBody List<ServerDTO> getAllServersByDeploymentId(@PathVariable Long deploymentId){
		Iterable<Server> servers=deploymentRepository.findServersByDeploymentId(deploymentId);
		return ServerResourceCreator.toResources(servers);
		 
	}

}
