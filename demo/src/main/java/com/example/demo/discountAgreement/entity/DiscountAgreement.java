package com.example.demo.discountAgreement.entity;

import com.example.demo.common.BaseEntity;
import com.example.demo.product.entity.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISCOUNTAGREEMENT")
public class DiscountAgreement extends BaseEntity {
    
    public DiscountAgreement(){
        
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private AgreementType agreementType;
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


    public AgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType;
    }

    public int getMustBuyAmount() {
        return mustBuyAmount;
    }

    public void setMustBuyAmount(int mustBuyAmount) {
        this.mustBuyAmount = mustBuyAmount;
    }
    public int getOnlyPayForAmount() {
        return onlyPayForAmount;
    }

    public void setOnlyPayForAmount(int onlyPayForAmount) {
        this.onlyPayForAmount = onlyPayForAmount;
    }

}
