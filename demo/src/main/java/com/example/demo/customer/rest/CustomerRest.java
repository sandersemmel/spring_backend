package com.example.demo.customer.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/customer")
public class CustomerRest {

	@GetMapping("/customertest")
	public String greeting() {
		return "hello";
	}
}
