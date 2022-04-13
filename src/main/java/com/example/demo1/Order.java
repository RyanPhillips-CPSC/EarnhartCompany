package com.example.demo1;

import java.util.ArrayList;

public class Order {

    static private int orderID;
    private int currentOrderID;
    private double total;
    private double tax;
    private ArrayList<Item> orderItems = new ArrayList<>();


    public int getCurrentOrderID() {
        return currentOrderID;
    }

    public double getTotal() {
        return total;
    }

    public double getTax() {
        return tax;
    }

    public ArrayList<Item> getOrderItems() {
        return orderItems;
    }
}
