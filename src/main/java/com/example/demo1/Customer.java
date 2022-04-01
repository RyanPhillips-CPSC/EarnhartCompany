package com.example.demo1;

import java.util.ArrayList;

public class Customer extends Person {

    PaymentMethod paymentMethod;
    ArrayList<Order> customerOrders = new ArrayList<>();

    public Customer(){}

    public Customer(String cName, String cPhone, String cEmail, String cAddress) {
        super(cName,cPhone,cEmail,cAddress);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(ArrayList<Order> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
