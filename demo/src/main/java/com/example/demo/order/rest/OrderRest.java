package com.example.demo.order.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.dto.incoming.DTO_CreateOrder;
import com.example.demo.order.entity.OOrder;
import com.example.demo.order.service.OrderService;
import com.example.demo.util.Util;

import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController()
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/createtestorder")
    public String createTestOrder(){
        orderService.createTestOrder();
        return "createtestorder called";
    }

    @GetMapping("getallorders")
    public List<OOrder> getAllOrders(){
        return orderService.getAllOrders();
    }
    
    @PostMapping("/createorder")
    public String createOrder(@RequestBody DTO_CreateOrder order) {
        try {
            if(!Util.isSafeFromSqlInject(order)){
                return "Unable to create order";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong, unable to create order";
        }

        if(order.getCustomerID() == 0){
            return "Unable to create Order, no customer given.";
        }
        
        Customer customer = customerService.findCustomer(order.getCustomerID());
        if(customer == null){
            return "no customer exists..";
        }

        orderService.createOrder(order);
        System.out.println(customer.getDiscountAgreement());

        return "Order created";
    }
    
}
