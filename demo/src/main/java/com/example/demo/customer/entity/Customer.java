package com.example.demo.customer.entity;

import java.util.List;

import com.example.demo.common.BaseEntity;
import com.example.demo.discountAgreement.entity.DiscountAgreement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity{
    
    @OneToMany(cascade = CascadeType.ALL)
    List<DiscountAgreement> discountAgreement;

    public List<DiscountAgreement> getDiscountAgreement() {
        return discountAgreement;
    }

    public void setDiscountAgreement(List<DiscountAgreement> discountAgreement) {
        this.discountAgreement = discountAgreement;
    }
}
