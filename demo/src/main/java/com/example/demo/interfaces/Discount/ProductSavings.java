package com.example.demo.interfaces.Discount;

import com.example.demo.product.entity.Product;

public class ProductSavings {
    private Product product;
    private double originalPrice;
    private double discountedPrice;
    private double totalSavings;
    public double getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public double getTotalSavings() {
        return totalSavings;
    }
    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


}
