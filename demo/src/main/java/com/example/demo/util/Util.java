package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.order.entity.OOrder;
import com.example.demo.product.entity.Product;

@Service
public class Util {
 
    public OOrder getTestOrder(){
        Product hammasHarja = new Product("HammasHarja",5);
        Product koiranRuoka = new Product("KoiranRuoka",10);

        var orderProducts = new ArrayList<Product>();
        orderProducts.add(hammasHarja);
        orderProducts.add(koiranRuoka);

        var calculatedOrderTotal = calculateProductTotal(orderProducts);

        OOrder order = new OOrder();
        order.setProducts(orderProducts);
        order.setTotal(calculatedOrderTotal);

        return order;
    }

    public void getTestDiscountAgreement(){
        //DiscountAgreement discountAgreement = new DiscountAgreement();
    }

    private double calculateProductTotal(List<Product> products){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
