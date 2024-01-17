package com.example.demo.customer.entity;

import java.util.UUID;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyDiscriminatorValue;
import org.hibernate.annotations.AnyKeyJavaClass;

import com.example.demo.common.BaseEntity;
import com.example.demo.discountAgreement.entity.DiscountAgreement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity{
    
    DiscountAgreement discountAgreement;

    public DiscountAgreement getDiscountAgreement() {
        return discountAgreement;
    }

    public void setDiscountAgreement(DiscountAgreement discountAgreement) {
        this.discountAgreement = discountAgreement;
    }
}
