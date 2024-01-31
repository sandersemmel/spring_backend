package com.example.demo.interfaces.Discount;

public class OrderSavings {
    
    private double originalOrderTotal;
    private double totalAfterSavings;
    private double totalSavings;

    public double getOriginalOrderTotal() {
        return originalOrderTotal;
    }
    public void setOriginalOrderTotal(double originalOrderTotal) {
        this.originalOrderTotal = originalOrderTotal;
    }
    public double getTotalAfterSavings() {
        return totalAfterSavings;
    }
    public void setTotalAfterSavings(double totalAfterSavings) {
        this.totalAfterSavings = totalAfterSavings;
    }
    public double getTotalSavings() {
        return totalSavings;
    }
    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

}
