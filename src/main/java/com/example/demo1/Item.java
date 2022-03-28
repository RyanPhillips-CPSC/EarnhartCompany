package com.example.demo1;

import java.io.FileWriter;
import java.io.IOException;

public class Item {

    private String name;
    private String sku;
    private double price;

    public String getName() {
        return name;
    }

    /**
     * When you create a new item, this method will write its specs into ItemList.txt
     * @throws IOException
     */
    public void writeItem() throws IOException {
        FileWriter fileWriter = new FileWriter("Associates\\AssociateList", true);
        fileWriter.write(this.name + "\n");
        fileWriter.write(this.sku + "\n");
        fileWriter.write(this.price + "\n");
        fileWriter.close();
    }

    /**
     * When you remove an item from ItemList.txt, this method rewrites the entire file
     * @throws IOException
     */
    public void rewriteItem() throws IOException {
        FileWriter fileWriter = new FileWriter("Associates\\AssociateList");
        fileWriter.write(this.name + "\n");
        fileWriter.write(this.sku + "\n");
        fileWriter.write(this.price + "\n");
        fileWriter.close();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}