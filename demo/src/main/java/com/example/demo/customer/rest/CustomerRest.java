package com.example.demo.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.service.CustomerService;


@RestController()
@RequestMapping("/customer")
public class CustomerRest {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customertest")
	public String greeting() {
		return "hello";
	}
	@GetMapping("/createtestcustomer")
	public String createTestCustomer(){
		customerService.createTestCustomer_withDiscountAgreement();
		return "/createtestcustomer called";
	}
	@GetMapping("/getallcustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
}
