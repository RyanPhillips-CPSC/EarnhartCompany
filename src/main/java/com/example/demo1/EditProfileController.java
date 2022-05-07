package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EditProfileController extends Controller implements Initializable {

    @FXML
    private Label invalidLabel;

    @FXML
    private Label updateLabel;

    @FXML
    private TextArea mainTextArea;

    @FXML
    private Label clientLabel;

    @FXML
    private ChoiceBox<String> dropDown;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    private TextField updateText;

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
    void clientMenu(ActionEvent event) {

    }

    public void setMainTextArea() {
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());

        String phone = "";
        String email = "";
        String address = "";
        String firstName = "";
        String lastname = "";
        String consultation = "";

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";

        try {
            Connection connection = DriverManager.getConnection(host, user, password);
            PreparedStatement statement = connection.prepareStatement("select * from clientprofile where FName <> 'null'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                phone = ("" + resultSet.getObject("Phone"));
                email = ("" + resultSet.getObject("Email"));
                address = ("" + resultSet.getObject("Address"));
                firstName = ("" + resultSet.getObject("FName"));
                lastname = ("" + resultSet.getObject("LName"));
                consultation = ("" + resultSet.getObject("Consultation"));
            }
        } catch (SQLException e) {
            System.out.println("" + e + "");
        }

        if (consultation.equals("null")) {
            mainTextArea.setText("Existing Profile Data\n" + Profile.getLastName() + ", " + Profile.getFirstName() +
                    "\n\nPhone : " + phone + "\n" + "Email : " + email + "\n" + "Address : " + address + "\n\n" + "No Existing Consultation");
        } else {
            mainTextArea.setText("Existing Profile Data\n" + Profile.getLastName() + ", " + Profile.getFirstName() +
                    "\n\nPhone : " + phone + "\n" + "Email : " + email + "\n" + "Address : " + address + "\n\n" + "Consultation : \n"
                    + consultation + "\n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invalidLabel.setVisible(false);
        updateLabel.setVisible(false);
        mainTextArea.setEditable(false);
        String phone = "";
        String email = "";
        String address = "";
        String firstName = "";
        String lastname = "";
        String consultation = "";

        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());
        dropDown.getItems().add("First Name");
        dropDown.getItems().add("Last Name");
        dropDown.getItems().add("Phone Number");
        dropDown.getItems().add("Email Address");
        dropDown.getItems().add("Shipping Address");

        setMainTextArea();
    }

    @FXML
    void submit(ActionEvent event) {
        String x = dropDown.getValue();

        if (x == null) {
            x = "";
        }

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";
        String newText = updateText.getText().strip();

        if (newText == "") {
            invalidLabel.setVisible(true);
        } else {
            switch (x) {
                case "First Name":
                    try {
                        Connection connection = DriverManager.getConnection(host, user, password);
                        PreparedStatement statement = connection.prepareStatement("update clientprofile set FName = '" + newText + "' where Email = '" + Profile.getEmail() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("" + e);
                    }
                    Profile.setFirstName(newText);
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                case "Last Name":
                    try {
                        Connection connection = DriverManager.getConnection(host, user, password);
                        PreparedStatement statement = connection.prepareStatement("update clientprofile set LName = '" + newText + "' where Email = '" + Profile.getEmail() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("" + e);
                    }
                    Profile.setLastName(newText);
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                case "Phone Number":
                    try {
                        Connection connection = DriverManager.getConnection(host, user, password);
                        PreparedStatement statement = connection.prepareStatement("update clientprofile set Phone = '" + newText + "' where Email = '" + Profile.getEmail() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("" + e);
                    }
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                case "Email Address":
                    try {
                        Connection connection = DriverManager.getConnection(host, user, password);
                        PreparedStatement statement = connection.prepareStatement("update clientprofile set Email = '" + newText + "' where Phone = '" + Profile.getPhone() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("" + e);
                    }
                    Profile.setEmail(newText);
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                case "Shipping Address":
                    try {
                        Connection connection = DriverManager.getConnection(host, user, password);
                        PreparedStatement statement = connection.prepareStatement("update clientprofile set Address = '" + newText + "' where Email = '" + Profile.getEmail() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("" + e);
                    }
                    Profile.setAddress(newText);
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                default:
                    invalidLabel.setVisible(true);
            }
        }
    }
}
