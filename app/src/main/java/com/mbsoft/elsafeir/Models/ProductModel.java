package com.mbsoft.elsafeir.Models;

public class ProductModel {
    String oldPrice, newPrice, percent, description;

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductModel(String oldPrice, String newPrice, String percent, String description) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.percent = percent;
        this.description = description;
    }
}
