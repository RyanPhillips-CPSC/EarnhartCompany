package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A series of ActionEvents used to switch between scenes via the main menu
 */
public class MainMenuController implements Initializable {

    @FXML
    private MenuBar exitMenu;

    @FXML
    private ImageView myImageView;

    private Stage stage;
    private Scene scene;

    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewAssociateInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,575, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Associate Form");
        stage.show();
    }

    @FXML
    void newCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewCustomerInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("New Customer Form");
        stage.show();
    }

    @FXML
    void newProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("New Product Form");
        stage.show();
    }

    @FXML
    void customerRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.setY(30);
        stage.show();
    }

    @FXML
    void productRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Product Form");
        stage.setY(30);
        stage.show();
    }

    @FXML
    void associateRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AssociateRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Associate Data");
        stage.setY(30);
        stage.show();
    }

    @FXML
    void removeAssociate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveAssociate.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Associate Removal Form");
        stage.show();
    }

    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Customer Removal Form");
        stage.show();
    }

    @FXML
    void removeProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Product Removal Form");
        stage.show();
    }

    /**
     * Sets ImageView and creates close button
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exitMenu.setOnMouseClicked(e -> Platform.exit());

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }
}