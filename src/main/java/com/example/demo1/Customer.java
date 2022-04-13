package com.example.demo1;

import java.util.ArrayList;

public class Customer extends Person {

    ArrayList<Order> customerOrders = new ArrayList<>();

    public Customer(){}

    public Customer(String cName, String cPhone, String cEmail, String cAddress) {
        super(cName,cPhone,cEmail,cAddress);
    }

    public ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }
}
