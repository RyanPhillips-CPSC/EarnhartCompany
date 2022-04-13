package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends Controller implements Initializable {

    private static String currentUser = "Administrator";

    @FXML
    private Button homeButton;

    @FXML
    private Label mainLabel;

    @FXML
    private ImageView myImageView;

    private Stage stage;
    private Scene scene;

    /**
     * Sets ImageView and creates close button
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeButton.setStyle("-fx-background-color: blue");
        homeButton.setDisable(true);

        mainLabel.setText("Hello " + currentUser + ", \n\nWelcome to the Farmhouse Associate Portal. \nHere, clientele, associate, " +
                "and product information \ncan be accessed and modified.");
        mainLabel.wrapTextProperty();
        mainLabel.setPadding(new Insets(10));
        mainLabel.textAlignmentProperty();
        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture.jpg")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }

    public static void setCurrentUser(String currentUser) {
        MainMenuController.currentUser = currentUser;
    }

    @FXML
    void settings(ActionEvent event) throws IOException {
        super.settings(myImageView);
    }

    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
        super.helpDisplay(myImageView);
    }

    @FXML
    void exit (ActionEvent event) throws IOException {
        super.exit(myImageView);
    }

    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        super.newAssociate(event);
    }

    @FXML
    void newCustomer(ActionEvent event) throws IOException {
        super.newCustomer(event);
    }

    @FXML
    void newProduct(ActionEvent event) throws IOException {
        super.newProduct(event);
    }

    @FXML
    void customerRecords(ActionEvent event) throws IOException {
        super.customerRecords(event);
    }

    @FXML
    void productRecords(ActionEvent event) throws IOException {
        super.productRecords(event);
    }

    @FXML
    void associateRecords(ActionEvent event) throws IOException {
        super.associateRecords(event);
    }

    @FXML
    void removeAssociate(ActionEvent event) throws IOException {
        super.removeAssociate(event);
    }

    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        super.removeCustomer(event);
    }

    @FXML
    void removeProduct(ActionEvent event) throws IOException {
        super.removeProduct(event);
    }
}