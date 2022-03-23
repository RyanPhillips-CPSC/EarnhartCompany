package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    private static ArrayList<Associate> associates = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Associate Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //itemAssignment();
        orderIDAssignment();
        customerAssignment();
        associateAssignment();
        launch();
        System.out.println("GUI HAS BEEN CLOSED");
    }

    /**
     *
     * @throws FileNotFoundException
     */
    private static void orderIDAssignment() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("OrderID\\OrderID.txt"));
        Order.setOrderID(scanner.nextInt());
    }

    public static void associateAssignment() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("Associates\\AssociateList"));
        while (scanner.hasNextLine()) {
            Associate a = new Associate();
            a.setName(scanner.nextLine());
            a.setPhone(scanner.nextLine());
            a.setEmail(scanner.nextLine());
            a.setAddress(scanner.nextLine());
            a.setUserID(scanner.nextLine());
            a.setPassword(scanner.nextLine());
            a.setAssociateTitle(AssociateTitle.valueOf(scanner.nextLine()));
            associates.add(a);
        }
    }

    /**
     * Reads the CustomerList.txt and assigns Objects, variables, and ArrayLists in a specified order
     * @throws FileNotFoundException
     */
    public static void customerAssignment() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("Customers\\CustomerList.txt"));
        while (scanner.hasNextLine()) {
            Customer c = new Customer();
            c.setName(scanner.nextLine());
            c.setPhone(scanner.nextLine());
            c.setEmail(scanner.nextLine());
            c.setAddress(scanner.nextLine());
            int x = scanner.nextInt();
            for (int i = 0; i < x; i++) {
                Order o = new Order();
                o.setCurrentOrderID(scanner.nextInt());
                o.setTotal(scanner.nextDouble());
                o.setTax(scanner.nextDouble());
                int y = scanner.nextInt();
                c.getCustomerOrders().add(o);
                for (int j = 0; j < y; j++) {
                    Item it = new Item();
                    scanner.nextLine();
                    it.setName(scanner.nextLine());
                    it.setSku(scanner.nextLine());
                    it.setPrice(scanner.nextDouble());
                    //If this is the last item run an extra line to adjust the scanner
                    //If this is the last line in the file, do not adjust the scanner
                    if (j == y - 1 && scanner.hasNextLine()) scanner.nextLine();
                    o.getOrderItems().add(it);
                }
            }
            customers.add(c);
        }
        scanner.close();
    }

    public static ArrayList<Associate> getAssociates() {
        return associates;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}