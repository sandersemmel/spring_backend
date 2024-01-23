package com.example.demo.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.customer.entity.Customer;
import com.example.demo.discountAgreement.entity.AgreementType;
import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.order.entity.OOrder;
import com.example.demo.product.entity.Product;
import com.github.rkpunjal.sqlsafe.SqlSafeUtil;

@Service
public class Util {
 
    public OOrder getTestOrder(){
        Product hammasHarja = new Product("HammasHarja",5, "150");
        Product koiranRuoka = new Product("KoiranRuoka",10, "150");

        var orderProducts = new ArrayList<Product>();
        orderProducts.add(hammasHarja);
        orderProducts.add(koiranRuoka);

        var calculatedOrderTotal = calculateProductTotal(orderProducts);

        OOrder order = new OOrder();
        order.setProducts(orderProducts);
        order.setTotal(calculatedOrderTotal);

        return order;
    }
    public Customer createTestCustomer_withDiscountAgreement(){
        Customer customer = new Customer();

        Product product = new Product("Testituote", 5,"150");

        List<DiscountAgreement> discount_agreements = new ArrayList<DiscountAgreement>();
        DiscountAgreement discountAgreement = new DiscountAgreement();
        discountAgreement.setAgreementType(AgreementType.PERCENTAGE_OFF_PRODUCT);
        discountAgreement.setProduct(product);
        discountAgreement.setPercentageOff(5);
        discount_agreements.add(discountAgreement);
        
        discountAgreement.setProduct(product);
        customer.setDiscountAgreement(discount_agreements);

        return customer;

    }

    public void getTestDiscountAgreement(){
        //DiscountAgreement discountAgreement = new DiscountAgreement();
    }

    private double calculateProductTotal(List<Product> products){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public static <T> boolean isSafeFromSqlInject(T checkableObject){     
        
        Class<?> clazz = checkableObject.getClass();

        // Get all methods of the class
        Method[] methods = clazz.getMethods();
    
        // Iterate through methods to find getters
        for (Method method : methods) {
            // Check if the method is a getter by its name and return type
            if (isGetter(method)) {
                // Invoke the getter method dynamically

                Object result = <String>method.invoke(checkableObject);
                try
              

                SqlSafeUtil.isSqlInjectionSafe(result);
                
                // Print the result
                System.out.println("Getter: " + method.getName() + ", Value: " + result);
            }
        }
        
        
        return true;




    }

   

}
