package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {

    private static Stage stage;
    private static Scene scene;


    void returnHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("MainMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("menuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void helpScene(ImageView myImageView) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("HelpScene.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) myImageView.getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("helpStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void aboutScene(ImageView myImageView) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("AboutScene.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) myImageView.getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("aboutStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    void customerRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800,560, Color.TRANSPARENT);
        scene.getStylesheets().add("records.css");
        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.setY(30);
        stage.show();
        stage.centerOnScreen();
    }

    void productRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800,560, Color.TRANSPARENT);
        scene.getStylesheets().add("records.css");
        stage.setScene(scene);
        stage.setTitle("Admin Portal");
        stage.setY(30);
        stage.show();
        stage.centerOnScreen();
    }

    void associateRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AssociateRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800,560, Color.TRANSPARENT);
        scene.getStylesheets().add("records.css");
        stage.setScene(scene);
        stage.setTitle("Admin Data");
        stage.setY(30);
        stage.show();
        stage.centerOnScreen();
    }
}

