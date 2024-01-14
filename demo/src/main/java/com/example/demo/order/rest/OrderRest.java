package com.example.demo.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.entity.OOrder;
import com.example.demo.order.service.OrderService;

@RestController()
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private OrderService orderService;

    @GetMapping("/createtestorder")
    public String createTestOrder(){
        orderService.createTestOrder();
        return "createtestorder called";
    }

    @GetMapping("getallorders")
    public List<OOrder> getAllOrders(){
        return orderService.getAllOrders();
    }
    
}
