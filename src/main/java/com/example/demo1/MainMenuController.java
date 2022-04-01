package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A series of ActionEvents used to switch scenes from the main menu
 */
public class MainMenuController {

    private Stage stage;
    private Scene scene;

    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewAssociateInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,575);
        stage.setScene(scene);
        stage.setTitle("Associate Form");
        stage.show();
    }

    @FXML
    void newCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewCustomerInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("New Customer Form");
        stage.show();
    }

    @FXML
    void newProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("New Product Form");
        stage.show();
    }

    @FXML
    void customerRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725);
        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.setY(30);
        stage.show();
    }

    @FXML
    void productRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725);
        stage.setScene(scene);
        stage.setTitle("Product Form");
        stage.setY(30);
        stage.show();
    }

    @FXML
    void associateRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AssociateRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725);
        stage.setScene(scene);
        stage.setTitle("Associate Data");
        stage.setY(30);
        stage.show();
    }

    @FXML
    void removeAssociate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveAssociate.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Associate Removal Form");
        stage.show();
    }

    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Customer Removal Form");
        stage.show();
    }

    @FXML
    void removeProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Product Removal Form");
        stage.show();
    }
}