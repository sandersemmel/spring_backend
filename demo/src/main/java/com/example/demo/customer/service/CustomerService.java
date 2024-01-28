package com.example.demo.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.dto.incoming.DTO_CreateCustomer;
import com.example.demo.util.Util;

@Service()
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Util util;

    public void createTestCustomer_withDiscountAgreement(){
        customerRepository.save(util.createTestCustomer_withDiscountAgreement());
    }
    
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(DTO_CreateCustomer entity) {
        Customer customer = new Customer();
        customer.setName(entity.getName()); 

        return customerRepository.save(customer);
  
    }
}
