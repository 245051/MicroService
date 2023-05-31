package com.cts.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/server")
public class helloService {
	@Autowired
	Environment environment;//Refrence to properties file.
	
	@Value("name")
	String strMessage;
	
	@GetMapping
	public String Welcome() {
		String port=environment.getProperty("server.port");
		return "Programming Microservices @ "+port;
				
		
	}
	@GetMapping("/status")
	public String Status() {
		return "Up and Down running ->>>>>";
	}

}
