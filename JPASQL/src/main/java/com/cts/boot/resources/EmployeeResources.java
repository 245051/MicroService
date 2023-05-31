package com.cts.boot.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResources {
	@GetMapping
	public String greet() {
		return "Working";
	}
	@GetMapping
	@RequestMapping("/admin")
	public String greetAdmin() {
		return "Admin@Work";
	}
	@GetMapping
	@RequestMapping("/user")
	public String greetUser() {
		return "User@work";
	}

}
