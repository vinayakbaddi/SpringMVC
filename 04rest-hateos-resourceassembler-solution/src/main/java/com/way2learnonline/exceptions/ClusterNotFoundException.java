package com.way2learnonline.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Cluster Not Found!!!!!")
public class ClusterNotFoundException extends RuntimeException {


	private static final long serialVersionUID = -2624884516596859220L;

	public ClusterNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClusterNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
