package com.cts.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/client")
public class HelloClientResources {
	@Autowired
	RestTemplate template;
	@GetMapping
	public String callServer() {
		//String url="http://localhost:8093/rest/server/status";
		//String url="http://localhost:8093/rest/server";
		String url1="http://localhost:8093/bill/res";

		//String output=template.getForObject(url, String.class);
		String output1=template.getForObject(url1, String.class);
		
		return output1 ;
		
	}

}
