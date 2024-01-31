package com.example.demo.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Service;

import com.example.demo.customer.entity.Customer;
import com.example.demo.discountAgreement.entity.AgreementType;
import com.example.demo.discountAgreement.entity.DiscountAgreement;
import com.example.demo.interfaces.Discount.OrderSavings;
import com.example.demo.interfaces.Discount.ProductSavings;
import com.example.demo.interfaces.Order.OrderProduct;
import com.example.demo.order.entity.OOrder;
import com.example.demo.product.entity.Product;
import com.github.rkpunjal.sqlsafe.SqlSafeUtil;

@Service
public class Util {
 
    public void getTestOrder(){
        Product hammasHarja = new Product("HammasHarja",5, "150");
        Product koiranRuoka = new Product("KoiranRuoka",10, "150");

        //var orderProducts = new ArrayList<Product>();
        //orderProducts.add(hammasHarja);
        //orderProducts.add(koiranRuoka);

        //var calculatedOrderTotal = calculateProductTotal(orderProducts);

        //OOrder order = new OOrder();
        //order.setProducts(orderProducts);
        //order.setTotal(calculatedOrderTotal);

        //return order;
    }
    public Customer createTestCustomer_withDiscountAgreement(){
        Customer customer = new Customer();

        Product product = new Product("Testituote", 5,"150");

        DiscountAgreement discountAgreement = new DiscountAgreement();
        discountAgreement.setAgreementType(AgreementType.PERCENTAGE_OFF_PRODUCT);
        discountAgreement.setProduct(product);
        discountAgreement.setPercentageOff(5);        
        
        discountAgreement.setProduct(product);

        return customer;

    }

    public void getTestDiscountAgreement(){
        //DiscountAgreement discountAgreement = new DiscountAgreement();
    }

    private double calculateProductTotal(List<Product> products){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public static <T> boolean isSafeFromSqlInject(T checkableObject) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{     
        // Not tested fully but perhaps works :)

        Class<?> clazz = checkableObject.getClass();

        // Get all methods of the class
        Method[] methods = clazz.getMethods();
    
        // Iterate through methods to find getters
        for (Method method : methods) {
            // Check if the method is a getter by its name and return type
            if (Util.isGetter(method)) {
                // Invoke the getter method dynamically

                Object result = method.invoke(checkableObject);

                String stringvalue =String.valueOf(result);
                
                SqlSafeUtil.isSqlInjectionSafe(stringvalue);
            }
        }
        
        
        return true;

    }
    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterCount() == 0
                && !method.getReturnType().equals(void.class);
    }

    public static ProductSavings calculateProductDiscount(DiscountAgreement discountAgreement){
            // calculate a discount off of single product and return the value

            var price = discountAgreement.getProduct().getPrice();
            var discountPerc = discountAgreement.getPercentageOff();

            // ensure discount is reasonable
            discountPerc = Math.max(0, Math.min(100, discountPerc));

            // calc the discount
            var discountedPrice = calculateDiscountForAmount(price,discountPerc);
            var totalSavings = price - discountedPrice;

            ProductSavings productSavings = new ProductSavings();
            productSavings.setDiscountedPrice(discountedPrice);
            productSavings.setTotalSavings(totalSavings);
            productSavings.setOriginalPrice(price);
            return productSavings;
    }

    private static double calculateDiscountForAmount(double originalPrice, int discountPercentage){
        return originalPrice * (1 - (discountPercentage / 100.0));
    }

    public static OrderSavings calculateOrderTotalPrice(List<OrderProduct> orderProducts, int percentageOff){
                
        double orderTotal = orderProducts.stream()
                                .mapToDouble(e -> e.getPrice() * e.getQuantity())
                                .sum();

        OrderSavings orderSavings = new OrderSavings();

        var totalAfterDiscount = calculateDiscountForAmount(orderTotal, percentageOff);

        orderSavings.setOriginalOrderTotal(orderTotal);
        orderSavings.setTotalAfterSavings(totalAfterDiscount);
        orderSavings.setTotalSavings((orderTotal-totalAfterDiscount));
                            
        return orderSavings;
    }

    

   

}
