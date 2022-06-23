package com.example.demo;

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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    void submit(ActionEvent event) throws InterruptedException, IOException, ClassNotFoundException {

        String firstName = fNameText.getText().strip();
        String lastName = lNameText.getText().strip();
        String phone = phoneText.getText().strip();
        String email = emailText.getText().strip();
        String address = addressText.getText().strip();

        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";
        String currentID = "";

        if (firstName.equals("") || lastName.equals("") || phone.equals("") || email.equals("") || address.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            try {
                File file = new File("C:\\Users\\ryanp\\Desktop\\EarnhartLLC - Copy\\clientID\\clientNumber.txt");
                FileReader fileReader = new FileReader(file);
                String s = String.valueOf(fileReader.read());
                currentID = s;
                Integer i = Integer.valueOf(s);
                i++;
                String y = String.valueOf(i);
                fileReader.close();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(y);
                fileWriter.close();

                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                preparedStatementOne.execute();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CLIENTPROFILE VALUES ('" + firstName + "','" + lastName + "','" + phone + "','" + email + "','" + address + "', null, '" + currentID + "')");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
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