package com.example.demo.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.discountAgreement.entity.AgreementType;
import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.dto.incoming.DTO_CreateOrder;
import com.example.demo.dto.outgoing.BaseDTO;
import com.example.demo.interfaces.Discount.BuyXPayYsavings;
import com.example.demo.interfaces.Discount.IPreparedOrder;
import com.example.demo.interfaces.Discount.OrderSavings;
import com.example.demo.order.entity.OOrder;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.types.OrderProducts;
import com.example.demo.product.service.ProductService;
import com.example.demo.sku.repository.SKURepository;
import com.example.demo.sku.service.SKUservice;
import com.example.demo.util.Util;

@Service
public class OrderService {

    @Autowired()
    private OrderRepository orderRepository;

    public void createTestOrder(){
        //orderRepository.save(util.getTestOrder());
    }

    public List<OOrder> getAllOrders() {
        return orderRepository.findAll();
    }
    public OOrder createOrder(IPreparedOrder preparedOrder){
        OOrder order = new OOrder();
        preparedOrder.getOrderProducts();
        order.setSKU(preparedOrder.getOrderSKUs());
        order.setDiscountAgreement(preparedOrder.getDiscountAgreement());
        order.setTotalAfterDiscount(preparedOrder.getTotalAfterSavings());
        order.setTotalBeforeDiscount(preparedOrder.getOriginalOrderTotal());
        order.setCustomer(preparedOrder.getCustomer());
        
        return orderRepository.save(order);

    }

}
