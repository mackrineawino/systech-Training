package com.systechtraining.pos;

public class Item {
    private int itemCode;
    private int quantity;
    private double unitPrice;

    public Item() {

    }

    public Item(int itemCode, int quantity, double unitPrice) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
