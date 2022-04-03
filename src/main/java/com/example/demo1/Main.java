package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

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
        Scene scene = new Scene(fxmlLoader.load(), 600, 400, Color.TRANSPARENT);
        stage.setTitle("Associate Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
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
        orderIDAssignment();
        customerAssignment();
        associateAssignment();
        launch();
        //upon closing platform:
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

    /**
     *
     * @throws FileNotFoundException
     */
    public static void itemAssignment() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("Items\\ItemList.txt"));
        while (scanner.hasNextLine()) {
            Item i = new Item();
            i.setName(scanner.nextLine());
            i.setSku(scanner.nextLine());
            i.setPrice(scanner.nextDouble());
            scanner.nextLine();
            items.add(i);
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
}