package com.example.demo1;

public class Item {

    private String name;
    private String sku;
    private double price;
    private String sPrice;

    public Item() {}

    public Item(String name, String sku, String price) {
        this.name = name;
        this.sku = sku;
        this.sPrice = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getsPrice() {
        return sPrice;
    }

    public void setsPrice(String sPrice) {
        this.sPrice = sPrice;
    }
}