package com.example.demo.sku.entity;

import com.example.demo.common.BaseEntity;
import com.example.demo.product.entity.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class SKU extends BaseEntity {
    
    @ManyToOne()
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
