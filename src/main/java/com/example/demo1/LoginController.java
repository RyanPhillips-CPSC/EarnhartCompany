package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage stage;
    private Scene scene;

    //Login scene objects
    @FXML
    private Label InvalidLabel;

    @FXML
    private TextField passwordLogin;

    @FXML
    private TextField userIDLogin;


    /**
     * Runs when the sign-in button on the login scene is clicked.
     * If credentials are valid, the login scene will switch to the main menu scene
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void submit(ActionEvent event) throws IOException {
        boolean valid = false;
        int index = -1;
        String username = userIDLogin.getText();
        for (int i = 0; i < Main.getAssociates().size(); i++) { //find the associate with the matching userID
            if (username.equals(Main.getAssociates().get(i).getUserID())) {
                index = i;
            }
        }
        String password = passwordLogin.getText();
        if (index != -1) { //verify the associate's password
            if (password.equals(Main.getAssociates().get(index).getPassword())) {
                valid = true;
            }
        }
        if (valid) {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        } else {
            InvalidLabel.setVisible(true); //display's message if the userId or password is invalid
            userIDLogin.setText("");
            passwordLogin.setText("");
        }
    }
}
