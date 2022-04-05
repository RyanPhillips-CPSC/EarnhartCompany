package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    private static boolean loggedIn = false;
    private static ArrayList<Associate> associates = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();

    /**
     * Sets important Stage properties and loads the initial Scene
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 403, 548, Color.TRANSPARENT);
        stage.setTitle("Associate Portal");
        stage.setResizable(false);
        stage.setScene(scene);
        scene.getStylesheets().add("style.css");
        stage.show();
    }

    /**
     * Calls data assignment methods and runs the GUI
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        itemAssignment();
        //orderIDAssignment();
        customerAssignment();
        associateAssignment();
        launch();
    }

    /**
     * Sets the orderID
     * @throws FileNotFoundException
     */
    private static void orderIDAssignment() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("OrderID\\OrderID.txt"));
        Order.setOrderID(scanner.nextInt());
    }

    /**
     * Collects and stores product information from a local database so the data can be easily accessed
     * from other classes without having to connect to a database.
     */
    public static void itemAssignment() {
        String name, sku, price;

        String host = "jdbc:mysql://localhost:3306/clientInfo";
        String user = "root";
        String password = "aTundeAdjuah_22!";

        try {
            Connection connection = DriverManager.getConnection(host, user, password);//Establishing connection
            PreparedStatement statement = connection.prepareStatement("select * from product where product.Name <> 'null'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                name = ("" + resultSet.getObject("Name"));
                sku = ("" + resultSet.getObject("Sku"));
                price = ("" + resultSet.getObject("Price"));
                Item it = new Item(name,sku,price);
                items.add(it);
            }
        } catch (SQLException e) {
            System.out.println("ERROR CONNECTING TO DATABASE OR EXECUTING QUERY");
        }
    }

    /**
     * Collects and stores associate information from a local database so the data can be easily accessed
     * from other classes without having to connect to a database.
     */
    public static void associateAssignment() {
        String name, phone, email, address, userID, password, associateTitle;

        String host = "jdbc:mysql://localhost:3306/clientInfo";
        String user = "root";
        String sqlPassword = "aTundeAdjuah_22!";

        try {
            Connection connection = DriverManager.getConnection(host, user, sqlPassword);//Establishing connection
            PreparedStatement statement = connection.prepareStatement("select * from associate where associate.Name <> 'null'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                name = ("" + resultSet.getObject("Name"));
                phone = ("" + resultSet.getObject("Phone"));
                email = ("" + resultSet.getObject("Email"));
                address = ("" + resultSet.getObject("Address"));
                userID = ("" + resultSet.getObject("UserID"));
                password = ("" + resultSet.getObject("Password"));
                associateTitle = ("" + resultSet.getObject("AssociateTitle"));
                Associate a = new Associate(name,phone,email,address,userID, password, associateTitle);
                associates.add(a);
            }
        } catch (SQLException e) {
            System.out.println("ERROR CONNECTING TO DATABASE OR EXECUTING QUERY");
        }
    }

    /**
     * Collects and stores customer information from a local database so the data can be easily accessed
     * from other classes without having to connect to a database.
     */
    public static void customerAssignment() {
        String name, phone, email, address;

        String host = "jdbc:mysql://localhost:3306/clientInfo";
        String user = "root";
        String password = "aTundeAdjuah_22!";

        try {
            Connection connection = DriverManager.getConnection(host, user, password);//Establishing connection
            PreparedStatement statement = connection.prepareStatement("select * from client where client.Name <> 'null'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                name = ("" + resultSet.getObject("Name"));
                phone = ("" + resultSet.getObject("Phone"));
                email = ("" + resultSet.getObject("Email"));
                address = ("" + resultSet.getObject("Address"));
                Customer c = new Customer(name,phone,email,address);
                customers.add(c);
            }
        } catch (SQLException e) {
            System.out.println("ERROR CONNECTING TO DATABASE OR EXECUTING QUERY");
        }
    }

    public static ArrayList<Associate> getAssociates() {
        return associates;
    }
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    public static ArrayList<Item> getItems() {
        return items;
    }
    public static void setLoggedIn(boolean loggedIn) {
        Main.loggedIn = loggedIn;
    }
    public static boolean isLoggedIn() {
        return loggedIn;
    }
}