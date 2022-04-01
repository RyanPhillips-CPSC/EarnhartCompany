package com.example.demo1;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewCustomerController {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField cAddress;

    @FXML
    private TextField cEmail;

    @FXML
    private TextField cName;

    @FXML
    private TextField cPhone;

    /**
     * Returns to the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }

    /**
     * Saves the user's input into the database table (client) and returns to the main menu
     * @param event
     * @throws SQLException
     */
    @FXML
    void submit(ActionEvent event) throws SQLException {
        String name, email, phone, address;
        name = cName.getText();
        email = cEmail.getText();
        phone = cPhone.getText();
        address = cAddress.getText();

        //add to ArrayList, then to table
        Customer c = new Customer(name,phone,email,address);
        Main.getCustomers().add(c);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientInfo", "root", "aTundeAdjuah_22!");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Client values ('"+name+"','"+phone+"','"+email+"','"+address+"')");
            preparedStatement.executeUpdate();

            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 600,400);
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        } catch(Exception e) {
            System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
        }
    }
}

