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
import java.sql.*;
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
    void submit(ActionEvent event) throws InterruptedException, IOException, ClassNotFoundException {

        String firstName = fNameText.getText().strip();
        String lastName = lNameText.getText().strip();
        String phone = phoneText.getText().strip();
        String email = emailText.getText().strip();
        String address = addressText.getText().strip();
        //TEMPORARY
        //String currentID = "1";

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";
        String currentID = "";

        if (firstName.equals("") || lastName.equals("") || phone.equals("") || email.equals("") || address.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            try {
                Connection connection2 = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement2 = connection2.prepareStatement("select ID from clientid");
                ResultSet resultSet = preparedStatement2.executeQuery();

                while (resultSet.next()) {
                    currentID = ("" + resultSet.getObject("ID"));
                }

                Connection connection = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into clientProfile values ('" + phone + "','" + email + "','" + address + "','" + firstName + "','" + lastName + "', null, '" + currentID + "')");
                preparedStatement.executeUpdate();

                int updatedID = Integer.parseInt(currentID);
                updatedID++;
                String updatedString = String.valueOf(updatedID);

                Connection connection3 = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement3 = connection3.prepareStatement("update clientid set ID = '" + updatedString + "'");
                preparedStatement3.executeUpdate();

            } catch (SQLException e) {
                System.out.println("" + e + "");
            }
            clientMenu(firstName,lastName,email,address,phone,event,currentID);
        }
    }

    private void clientMenu(String firstName, String lastName, String email, String address, String phone, ActionEvent event, String currentID) throws IOException {
        Profile.setFirstName(firstName);
        Profile.setLastName(lastName);
        Profile.setEmail(email);
        Profile.setAddress(address);
        Profile.setPhone(phone);
        Profile.setClientID(currentID);
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