package com.example.demo1;

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

    @FXML
    void newAssociateSubmit(ActionEvent event) throws IOException {
        String name, phone, email, address, userID, password, associateTitle;
        name = cName.getText();
        phone = cPhone.getText();
        email = cEmail.getText();
        address = cAddress.getText();

        //If they are not null, proceed to assignment
        Customer c = new Customer(name,phone,email,address);
        Main.getCustomers().add(c);
        c.writeCustomer();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
