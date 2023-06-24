package com.product.resource;

public class CircuitBreaker {
	@GetMapping("/test1")
	@CircuitBreaker(name = "test1service", fallbackMethod = "fallback")
	public String test() {
	 
	    return this.restTemplate.getForObject("http://localhost:8080/testing", String.class);
	 
	}
}
