package com.cts.resources;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/bill")

public class BillingServiceResources {
	
	@GetMapping("/res")
	public String Welcome() {
		return "You have entered Billing Service:";
	}
	
	
}
