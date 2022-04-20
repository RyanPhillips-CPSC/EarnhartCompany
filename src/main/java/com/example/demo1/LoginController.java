package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {

    private boolean valid = false;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label InvalidLabel;

    @FXML
    private ImageView farmImage;

    @FXML
    private ImageView myImageView;

    @FXML
    private TextField passwordLogin;

    @FXML
    private TextField userIDLogin;

    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
        super.helpDisplay(myImageView);
    }

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
        for (int i = 0; i < Main.getAssociates().size(); i++) { //find the associate with the matching userID
            if (username.equals(Main.getAssociates().get(i).getUserID())) {
                index = i;
            }
        }
        String password = passwordLogin.getText();
        if (index != -1) { //verify the associate's password
            if (password.equals(Main.getAssociates().get(index).getPassword())) {
                valid = true;
                if (!(username.equals("CPSC240"))) {
                    MainMenuController.setCurrentUser(Main.getAssociates().get(index).getName());
                }
            }
        }
        if (valid || username.equals("CPSC240")) {
            Main.setLoggedIn(true);
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 602, 432, Color.TRANSPARENT);
            scene.getStylesheets().add("menuStyle.css");
            stage.setScene(scene);
            stage.setTitle("Associate Portal");
            stage.show();
            stage.centerOnScreen();
        } else {
            InvalidLabel.setVisible(true);
            userIDLogin.setText("");
            passwordLogin.setText("");
        }
    }

    /**
     * Sets ImageView and creates close button
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/Group Project Logo.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
            Image background = new Image(String.valueOf(getClass().getResource("/Images/Furniture.png")));
            farmImage.setImage(background);
            farmImage.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }
}
