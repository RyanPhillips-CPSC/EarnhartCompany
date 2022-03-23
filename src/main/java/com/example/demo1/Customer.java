package com.example.demo1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Customer extends Person {

    PaymentMethod paymentMethod;
    ArrayList<Order> customerOrders = new ArrayList<>();

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

    /**
     * Appends CustomerList.txt with client information
     * @throws IOException
     */
    public void writeCustomer() throws IOException {
        //Write client's general info
        FileWriter fileWriter = new FileWriter("Customers\\CustomerList.txt", true);
        fileWriter.write(this.name + "\n");
        fileWriter.write(this.phone + "\n");
        fileWriter.write(this.email + "\n");
        fileWriter.write(this.address + "\n");
        fileWriter.write(this.getCustomerOrders().size() + "\n");
        for (int i = 0; i < this.getCustomerOrders().size(); i++){ //Write clients order info
            fileWriter.write(this.getCustomerOrders().get(i).getCurrentOrderID() + "\n");
            fileWriter.write(this.getCustomerOrders().get(i).getTotal() + "\n");
            fileWriter.write(this.getCustomerOrders().get(i).getTax() + "\n");
            for (int j = 0; j < this.getCustomerOrders().get(i).getOrderItems().size(); j++) { //Write order's item info
                fileWriter.write(this.getCustomerOrders().get(i).getOrderItems().get(j).getName() + "\n");
                fileWriter.write(this.getCustomerOrders().get(i).getOrderItems().get(j).getSku() + "\n");
                fileWriter.write(this.getCustomerOrders().get(i).getOrderItems().get(j).getPrice() + "\n");
            }
        }
        fileWriter.close();
    }

    /**
     * rewrites CustomerList.txt
     * @throws IOException
     */
    public void rewriteCustomer() throws IOException {
        //Write client's general info
        FileWriter fileWriter = new FileWriter("Customers\\CustomerList.txt");
        fileWriter.write(this.name + "\n");
        fileWriter.write(this.phone + "\n");
        fileWriter.write(this.email + "\n");
        fileWriter.write(this.address + "\n");
        fileWriter.write(this.getCustomerOrders().size() + "\n");
        for (int i = 0; i < this.getCustomerOrders().size(); i++){ //Write clients order info
            fileWriter.write(this.getCustomerOrders().get(i).getCurrentOrderID() + "\n");
            fileWriter.write(this.getCustomerOrders().get(i).getTotal() + "\n");
            fileWriter.write(this.getCustomerOrders().get(i).getTax() + "\n");
            for (int j = 0; j < this.getCustomerOrders().get(i).getOrderItems().size(); j++) { //Write order's item info
                fileWriter.write(this.getCustomerOrders().get(i).getOrderItems().get(j).getName() + "\n");
                fileWriter.write(this.getCustomerOrders().get(i).getOrderItems().get(j).getSku() + "\n");
                fileWriter.write(this.getCustomerOrders().get(i).getOrderItems().get(j).getPrice() + "\n");
            }
        }
        fileWriter.close();
    }
}
