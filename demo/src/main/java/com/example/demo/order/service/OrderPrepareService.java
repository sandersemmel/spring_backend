package com.example.demo.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.incoming.DTO_CreateOrder;
import com.example.demo.order.errors.ProductNotFoundException;
import com.example.demo.order.types.OrderProducts;
import com.example.demo.product.service.ProductService;

@Service
public class OrderPrepareService {
    
    @Autowired()
    private ProductService productService;


    public List<OrderProducts> createOrderProducts(DTO_CreateOrder dto_createOrder){
        List<OrderProducts> ret = new ArrayList();
        try {
            ret = dto_createOrder.getProductQuantity().stream().map((cartProduct)-> {
                var product = productService.getProduct(cartProduct.getProductID());
                if(product == null){
                    throw new ProductNotFoundException("Product that was in cart " + cartProduct.getProductID() + " was not found from DB");
                }
                return new OrderProducts(product,cartProduct.getQuantity());
            }).toList();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
            return ret;
        }
        return ret;
    }
}
