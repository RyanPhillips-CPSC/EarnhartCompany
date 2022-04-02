package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A series of ActionEvents used to switch between scenes via the main menu
 */
public class MainMenuController implements Initializable {

    private Popup helpPopup;

    @FXML
    private MenuBar exitMenu;

    @FXML
    private ImageView myImageView;

    private Stage stage;
    private Scene scene;

    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
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
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Product Removal Form");
        stage.show();
    }

    /**
     * Switches to program settings
     * @param event
     * @throws IOException
     */
    @FXML
    void settings(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        Parent mainCallWindowFXML = loader.load();
        Stage thisStage = (Stage) myImageView.getScene().getWindow();
        Scene mainCallWindow = new Scene (mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
        mainCallWindow.getStylesheets().add("style.css");
        thisStage.setScene(mainCallWindow);
    }

    /**
     * Displays information related to the current Scene without closing the current Stage
     * @param event
     */
    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
        if (helpPopup == null) {
            Popup popup = new Popup();
            popup.setX(100);
            popup.setY(200);
            Label label = new Label("The Farmhouse Company Data Manager software\n" +
                    "provides ease of access to sensitive clientele and\n " +
                    "employee information. It allows for effortless\n" +
                    "storage and modification of company records.\n\n" +
                    "Please speak to management regarding any questions\nor contact our developer team:\n\n");
            label.setTextAlignment(TextAlignment.CENTER);
            label.setTextFill(Paint.valueOf("white"));
            label.setStyle("-fx-label-padding: 10 10 10 10");
            Label label2 = new Label("        rphillip@mail.umw.edu\n" +
                    "        jhewitt2@mail.umw.edu\n" +
                    "        jvogtli@mail.umw.edu");
            label2.setTextAlignment(TextAlignment.CENTER);
            label2.setTextFill(Paint.valueOf("blue"));
            label2.setStyle("-fx-label-padding: 30 0 20 60");

            VBox vBox = new VBox(label, label2);
            popup.getContent().add(vBox);
            helpPopup = popup;
            helpPopup.show(exitMenu.getScene().getWindow());
        }
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