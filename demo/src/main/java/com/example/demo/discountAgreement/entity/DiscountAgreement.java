package com.example.demo.discountAgreement.entity;

import com.example.demo.common.BaseEntity;
import com.example.demo.product.entity.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISCOUNTAGREEMENT")
public class DiscountAgreement extends BaseEntity {
    
    public DiscountAgreement(){
        
    }

    @Column(nullable = true)
    @OneToOne
    private Product product;

    private int percentageOff;
    private int mustBuyAmount;
    private int onlyPayForAmount;


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

    private AgreementType agreementType;

    public AgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType;
    }


}
