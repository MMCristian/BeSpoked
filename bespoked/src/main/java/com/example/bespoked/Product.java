package com.example.bespoked;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
    @Id
    private String name;

    private String manufacturer;
    private String style;
    private Float purchasePrice;
    private Float salePrice;
    private Integer qty;
    private Float commissionPercentage;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Float getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Float getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Float getCommissionPercentage() {
        return this.commissionPercentage;
    }

    public void setCommissionPercentage(Float commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

}
