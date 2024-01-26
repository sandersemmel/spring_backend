package com.example.demo.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.dto.incoming.DTO_CreateCustomer;
import com.example.demo.util.Util;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@CrossOrigin
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

	@PostMapping("/createcustomer")
	public void createCustomer(@RequestBody DTO_CreateCustomer entity) {

		try {
			if(!Util.isSafeFromSqlInject(entity)){
				return;
			}
		} catch (Exception e) {
			System.out.println("SQL injection testing failed");
			return;
		}

		customerService.createCustomer(entity);
		
	}
	
}
