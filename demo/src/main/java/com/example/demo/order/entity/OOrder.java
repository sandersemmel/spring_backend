package com.example.demo.order.entity;



import java.util.List;

import com.example.demo.common.BaseEntity;
import com.example.demo.product.entity.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "OORDER")
public class OOrder extends BaseEntity{

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id")  // This creates a foreign key column in the Product table
    private List<Product> products;

    private double total;

    public OOrder() {
        // Default constructor required by JPA
    }

    public OOrder(List<Product> products, double total) {
        this.products = products;
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    // Getters and setters
}