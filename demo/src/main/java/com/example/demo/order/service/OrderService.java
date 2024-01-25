package com.example.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.order.entity.OOrder;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.util.Util;

@Service
public class OrderService {

    @Autowired
    private Util util;

    @Autowired()
    private OrderRepository orderRepository;

    public void createTestOrder(){
        //orderRepository.save(util.getTestOrder());
    }

    public List<OOrder> getAllOrders() {
        return orderRepository.findAll();
    }

}
