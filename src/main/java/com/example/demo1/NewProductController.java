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

public class NewProductController {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField pName;

    @FXML
    private TextField pPrice;

    @FXML
    private TextField pSku;

    @FXML
    void submit(ActionEvent event) throws IOException {
        String name, sku, price;
        name = pName.getText();
        sku = pSku.getText();
        price = pPrice.getText();

        //If they are not null, proceed to assignment
        Item it = new Item(name,sku,price);
        Main.getItems().add(it);
        it.writeItem();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
