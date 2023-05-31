package com.cts.client.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CircuitService {
	
	    @CircuitBreaker(name = "getUserDetails", fallbackMethod = "getUserDetailsFallback")
	    public UserDetails getUserDetails(String userId) {
	        // Make the remote call or perform operations
	        // that could potentially fail
	    }

	    public UserDetails getUserDetailsFallback(String userId, Throwable throwable) {
	        // Fallback logic when the circuit is open or an exception occurs
	    }
	}

}
