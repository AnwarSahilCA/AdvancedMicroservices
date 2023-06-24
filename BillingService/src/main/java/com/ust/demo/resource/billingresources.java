package com.ust.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/billingservice")
public class billingresources {
	@GetMapping
	public String welcome() {
		return "Programming billing services";
	}
	@GetMapping("/add")
	public int add() {
		int a=5+3;
		return a;
	}

}
