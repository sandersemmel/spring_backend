package com.example.demo.customer.entity;

import com.example.demo.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity{
    
}
