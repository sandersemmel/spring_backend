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
import com.example.demo.interfaces.Discount.OrderSavings;
import com.example.demo.order.entity.OOrder;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.types.OrderProducts;
import com.example.demo.product.service.ProductService;
import com.example.demo.util.Util;

@Service
public class OrderService {

    @Autowired
    private Util util;

    @Autowired()
    private OrderRepository orderRepository;

    @Autowired()
    private CustomerRepository customerRepository;

    @Autowired()
    private ProductService productService;

    @Autowired()
    private OrderPrepareService orderPrepService;

    public void createTestOrder(){
        //orderRepository.save(util.getTestOrder());
    }

    public List<OOrder> getAllOrders() {
        return orderRepository.findAll();
    }
    public BaseDTO<String> createOrder(DTO_CreateOrder dto_createOrder){
        BaseDTO<String> response = new BaseDTO<String>();

        // Try to fetch Products from database
        List<OrderProducts> orderProducts = orderPrepService.createOrderProducts(dto_createOrder);
        if(orderProducts.isEmpty()){
            response.setExplanation(" Can not create order because no such product exists or no products are in the order");
            return response;
        }

        //Try to fetch customer from database
        var customer = customerRepository.findById(dto_createOrder.getCustomerID()).orElse(null);
        if(customer == null){
            response.setExplanation("Order can not be created, no customer found");
        }

        Util.calculateProductSavings(customer.getDiscountAgreement(), orderProducts);
        Util.calculateOrderSavings(customer.getDiscountAgreement(), orderProducts);
        Util.calculateBuyXPayYSavings(customer.getDiscountAgreement(), orderProducts);

        // calculate discounts
   
        OrderSavings orderSavings = null;
        List<BuyXPayYsavings> buyXPayYsavingsList = new ArrayList();


        double totalProductSavings = 0;
        double totalOrderSavings = 0;
        double totalBuyXPayYSavings = 0;

        
        
        for (DiscountAgreement item : customer.getDiscountAgreement()) {
        




                //totalBuyXPayYSavings = savings.stream().mapToDouble(e-> e.getTotalSavings()).sum();

            
            }

            System.out.println("Savings");
            System.out.println(totalProductSavings);
            System.out.println(totalBuyXPayYSavings);
            System.out.println(totalOrderSavings);
        
            
        return response;
//        order.set
    }

}
