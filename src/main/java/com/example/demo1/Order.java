package com.example.demo1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {

    static private int orderID;
    private int currentOrderID;
    private double total;
    private double tax;
    private ArrayList<Item> orderItems = new ArrayList<>();

    /**
     *
     * @throws IOException
     */
    public static void incrementOrderId() throws IOException {
        orderID += 1;
        FileWriter fileWriter = new FileWriter("OrderID\\OrderId.txt");
        fileWriter.write(orderID);
    }

    public static int getOrderID() {
        return orderID;
    }

    public static void setOrderID(int orderID) {
        Order.orderID = orderID;
    }

    public int getCurrentOrderID() {
        return currentOrderID;
    }

    public void setCurrentOrderID(int currentOrderID) {
        this.currentOrderID = currentOrderID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public ArrayList<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<Item> orderItems) {
        this.orderItems = orderItems;
    }
}
