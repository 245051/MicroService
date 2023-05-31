package com.cts.boot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.boot.MyUserDetailsService;
import com.cts.boot.model.AuthenticationRequest;
import com.cts.boot.model.AuthenticationResponse;
import com.cts.boot.util.JwtUtil;

@RestController
public class EmployeeResources {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailService;
	@Autowired
	JwtUtil jwtutil;
	@GetMapping
	public String greet() {
		return "Working";
	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
               System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtutil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	

}
