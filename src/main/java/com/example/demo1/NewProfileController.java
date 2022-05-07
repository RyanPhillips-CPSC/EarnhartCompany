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
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewProfileController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField addressText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField fNameText;

    @FXML
    private Label invalidLabel;

    @FXML
    private TextField lNameText;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    private TextField phoneText;


    @FXML
    void helpScene(ActionEvent event) throws IOException {
        super.helpScene(mouthpieceIcon);
    }

    @FXML
    void aboutScene(ActionEvent event) throws IOException {
        super.aboutScene(mouthpieceIcon);
    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        super.returnHome(event);
    }

    @FXML
    void submit(ActionEvent event) throws InterruptedException, IOException {
        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";

        String firstName = fNameText.getText().strip();
        String lastName = lNameText.getText().strip();
        String phone = phoneText.getText().strip();
        String email = emailText.getText().strip();
        String address = addressText.getText().strip();

        if (firstName.equals("") || lastName.equals("") || phone.equals("") || email.equals("") || address.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            try {
                Connection connection = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into clientProfile values ('" + phone + "','" + email + "','" + address + "','" + firstName + "','" + lastName + "', null)");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("" + e + "");
            }
            clientMenu(firstName,lastName,email,address,phone,event);
        }
    }

    private void clientMenu(String firstName, String lastName, String email, String address, String phone, ActionEvent event) throws IOException {
        Profile.setFirstName(firstName);
        Profile.setLastName(lastName);
        Profile.setEmail(email);
        Profile.setAddress(address);
        Profile.setPhone(phone);
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("ClientMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("clientMenuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invalidLabel.setVisible(false);
    }
}