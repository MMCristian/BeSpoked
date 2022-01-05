package com.example.bespoked;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Sale {
    @Id
    private Integer id;

    private String product;
    private Integer saleperson;
    private Integer customer;
    private Date saleDate;
    private Float price;
    private Float commission;

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCommission() {
        return this.commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getSaleperson() {
        return this.saleperson;
    }

    public void setSaleperson(Integer saleperson) {
        this.saleperson = saleperson;
    }

    public Integer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Date getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

}
