package com.example.demo.discountAgreement.entity;

import com.example.demo.product.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISCOUNT_AGREEMENT_PERCENTAGE_OFF")
public class DA_PercentageOff extends DiscountAgreement{
    
    @OneToOne
    private Product product;
    private int percentageOff;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getPercentageOff() {
        return percentageOff;
    }
    public void setPercentageOff(int percentageOff) {
        this.percentageOff = percentageOff;
    }
}
