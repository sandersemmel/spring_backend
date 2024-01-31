package com.example.demo.dto.incoming;

import java.util.List;

public class DTO_CreateOrder {
    private long customerID;
    private List<DTO_CartProduct> productQuantity;

    public long getCustomerID() {
        return customerID;
    }
    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }
    public List<DTO_CartProduct> getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(List<DTO_CartProduct> productQuantity) {
        this.productQuantity = productQuantity;
    }
    @Override
    public String toString() {
        return "DTO_CreateOrder [customerID=" + customerID + ", productQuantity=" + productQuantity + "]";
    }
    
}


