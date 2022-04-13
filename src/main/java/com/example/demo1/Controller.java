package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

//TODO == STRIP THE WHITESPACE ON NEW DATA BEFORE ADDING IT TO THE DATABASE
public abstract class Controller {

    private static Popup helpPopup;
    private static Stage stage;
    private static Scene scene;

    public void exit(ImageView myImageView) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("MainMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) myImageView.getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
        scene.getStylesheets().add("menuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    void settings(ImageView myImageView) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        Parent mainCallWindowFXML = loader.load();
        Stage thisStage = (Stage) myImageView.getScene().getWindow();
        Scene mainCallWindow = new Scene (mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
        mainCallWindow.getStylesheets().add("style.css");
        thisStage.setScene(mainCallWindow);
    }

    void helpDisplay(ImageView myImageView) throws IOException {
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
            helpPopup.show(myImageView.getScene().getWindow());
        }
    }

    void newAssociate(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("NewAssociateInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,575, Color.TRANSPARENT);
        scene.getStylesheets().add("associate.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }

    void newCustomer(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("NewCustomerInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 602,432, Color.TRANSPARENT);
        scene.getStylesheets().add("customer.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }

    void newProduct(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("NewProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("product.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }

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

    void productRecords(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("ProductRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 700,450, Color.TRANSPARENT);
        scene.getStylesheets().add("records.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.setY(30);
        stage.show();
        stage.centerOnScreen();
    }

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

    void removeAssociate(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveAssociate.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("removeAssociate.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }

    void removeCustomer(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("removeAssociate.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }

    void removeProduct(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("removeAssociate.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }
}

