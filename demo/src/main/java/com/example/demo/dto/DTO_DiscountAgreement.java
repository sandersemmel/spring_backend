package com.example.demo.dto;

public class DTO_DiscountAgreement {

    private String productId;
    private String agreementType;
    private Integer percentageOff;
    private Integer mustBuyAmount;
    private Integer onlyPayForAmount;

    public DTO_DiscountAgreement(){

    }

    public DTO_DiscountAgreement(String productId, String agreementType, Integer percentageOff, Integer mustBuyAmount,
            Integer onlyPayForAmount) {
        this.productId = productId;
        this.agreementType = agreementType;
        this.percentageOff = percentageOff;
        this.mustBuyAmount = mustBuyAmount;
        this.onlyPayForAmount = onlyPayForAmount;
    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getAgreementType() {
        return agreementType;
    }
    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }
    public Integer getPercentageOff() {
        return percentageOff;
    }
    public void setPercentageOff(Integer percentageOff) {
        this.percentageOff = percentageOff;
    }
    public Integer getMustBuyAmount() {
        return mustBuyAmount;
    }
    public void setMustBuyAmount(Integer mustBuyAmount) {
        this.mustBuyAmount = mustBuyAmount;
    }
    public Integer getOnlyPayForAmount() {
        return onlyPayForAmount;
    }
    public void setOnlyPayForAmount(Integer onlyPayForAmount) {
        this.onlyPayForAmount = onlyPayForAmount;
    }

}
