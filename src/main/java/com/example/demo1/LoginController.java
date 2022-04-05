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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Popup helpPopup;
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
        Stage thisStage = (Stage) passwordLogin.getScene().getWindow();
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
            helpPopup.show(myImageView.getScene().getWindow());
        }
    }

    /**
     * Runs when the sign-in button on the login scene is clicked.
     * If credentials are valid, the Scene will switch to the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void submit(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
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
                if (!(username.equals("CPSC220"))) {
                    MainMenuController.setCurrentUser(Main.getAssociates().get(index).getName());
                }
            }
        }
        if (valid || username.equals("CPSC220")) {
            Main.setLoggedIn(true);
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 602, 432, Color.TRANSPARENT);
            scene.getStylesheets().add("menuStyle.css");
            stage.setScene(scene);
            stage.setTitle("Main Menu");
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
