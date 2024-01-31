package com.example.demo.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.discountAgreement.entity.AgreementType;
import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.dto.incoming.DTO_CartProduct;
import com.example.demo.dto.incoming.DTO_CreateOrder;
import com.example.demo.dto.outgoing.BaseDTO;
import com.example.demo.interfaces.Discount.BuyXPayYSavingsProduct;
import com.example.demo.interfaces.Discount.BuyXPayYsavings;
import com.example.demo.interfaces.Discount.OrderSavings;
import com.example.demo.interfaces.Discount.ProductSavings;
import com.example.demo.interfaces.Order.OrderProduct;
import com.example.demo.order.entity.OOrder;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.product.service.ProductService;
import com.example.demo.util.Util;
import com.fasterxml.jackson.databind.JsonSerializable.Base;

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

    public void createTestOrder(){
        //orderRepository.save(util.getTestOrder());
    }

    public List<OOrder> getAllOrders() {
        return orderRepository.findAll();
    }
    public BaseDTO<String> createOrder(DTO_CreateOrder dto_createOrder){
        BaseDTO<String> response = new BaseDTO<String>();

        dto_createOrder.getCustomerID();
        var cartProducts = dto_createOrder.getProductQuantity();

        // get order productsids to list
        List<Long> productsIds= dto_createOrder.getProductQuantity().stream().map(e->{
            return e.getProductID();
        }).toList();

        var customer = customerRepository.findById(dto_createOrder.getCustomerID()).orElse(null);
        if(customer == null){
            response.setExplanation("Order can not be created, no customer found");
        }

        // calculate discounts
        List<ProductSavings> productSavingsList = new ArrayList();
        OrderSavings orderSavings = null;
        List<BuyXPayYsavings> buyXPayYsavingsList = new ArrayList();

        
        for (DiscountAgreement item : customer.getDiscountAgreement()) {
            if(AgreementType.PERCENTAGE_OFF_PRODUCT.equals(item.getAgreementType())){
                if(productsIds.contains(item.getProduct().getId())){
                    productSavingsList.add(Util.calculateProductDiscount(item));
                }
            }

            if(AgreementType.PERCENTAGE_OFF_WHOLE_ORDER.equals(item.getAgreementType())){
                try {
                    List<OrderProduct> orderProducts = cartProducts.stream().map(cartProduct->{
                        var db_product = productService.getProduct(cartProduct.getProductID());
                        if(db_product == null){
                            throw new Exception("Order has product that does not exist in database.");
                        }
                        return new OrderProduct(cartProduct.getQuantity(),db_product.getId(), db_product.getPrice());
                    }).toList();

                    orderSavings = Util.calculateOrderSavings(orderProducts,item.getPercentageOff());

                } catch (Exception e) {
                    response.setExplanation(e.getMessage());
                }
            }

            if(AgreementType.BUY_X_ONLY_PAY_Y.equals(item.getAgreementType())){
                var productsThatAreEligible = cartProducts.stream().map(e-> {
                    if(e.getProductID() == item.getProduct().getId() && e.getQuantity() >= item.getMustBuyAmount()){
                        return true;
                    }
                    return false;
                }).toList();
    
                productsThatAreEligible.stream().map(e->e)

            
            }
        }
        
        
        return true;
        OOrder order = new OOrder();
//        order.set
    }

}
