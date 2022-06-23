package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class LoginController extends Controller {

    private boolean valid = false;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label InvalidLabel;

    @FXML
    private TextField passwordLogin;

    @FXML
    private TextField userIDLogin;

    /**
     * Runs when the sign-in button on the login scene is clicked.
     * If credentials are valid, the Scene will switch to the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void submit(ActionEvent event) throws IOException {

        int index = -1;
        String username = userIDLogin.getText();
        for (int i = 0; i < Main.getAdmins().size(); i++) { //find the admin with the matching userID
            if (username.equals(Main.getAdmins().get(i).getUserID())) {
                index = i;
            }
        }
        String password = passwordLogin.getText();
        if (index != -1) { //verify the associate's password
            if (password.equals(Main.getAdmins().get(index).getPassword())) {
                valid = true;
                }
            }
        if (valid || username.equals("KEY")) {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 900, 650, Color.TRANSPARENT);
            scene.getStylesheets().add("menuStyle.css");
            stage.setScene(scene);
            stage.setTitle("The Earnhart Company");
            stage.show();
            stage.centerOnScreen();
        } else {
            InvalidLabel.setVisible(true);
            userIDLogin.setText("");
            passwordLogin.setText("");
        }
    }
}
