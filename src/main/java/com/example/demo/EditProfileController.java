package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EditProfileController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

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
    void clientMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("ClientMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("clientMenuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void setMainTextArea() {
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());

        String id = Profile.getClientID();

        if (id.contains("clob")) {
            boolean cont = true;
            int index = 0;
            while (cont) {
                if (id.charAt(index) == ':') {
                    cont = false;
                }
                index++;
            }
            id = id.substring(index + 2);
            int split = id.length();
            id = id.substring(0, split - 1);
        }

        String phone = "";
        String email = "";
        String address = "";
        String consultation = "";

        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
            preparedStatementOne.execute();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTPROFILE WHERE clientID = '" + id + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                phone = ("" + resultSet.getObject("phone"));
                email = ("" + resultSet.getObject("email"));
                address = ("" + resultSet.getObject("address"));
                consultation = ("" + resultSet.getObject("consultation"));
            }
        } catch (SQLException e) {
            System.out.println("" + e + "");
        }

        if (consultation.contains("clob")) {
            boolean b = true;
            int i = 0;
            while (b) {
                if (consultation.charAt(i) == ':') {
                    b = false;
                }
                i++;
            }
            consultation = consultation.substring(i + 2);
            int separate = consultation.length();
            consultation = consultation.substring(0,separate - 1);
        }

        if (consultation.charAt(0) == '\'') {
            consultation = consultation.substring(1);
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
    void submit(ActionEvent event) throws SQLException {
        String x = dropDown.getValue();

        if (x == null) {
            x = "";
        }

        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";
        String newText = updateText.getText().strip();
        Connection connection = null;
        connection = DriverManager.getConnection(jdbcURL, username, password);
        PreparedStatement preparedStatementSet = connection.prepareStatement("SET SCHEMA TWO");
        preparedStatementSet.execute();

        if (newText.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            switch (x) {
                case "First Name":
                    try {
                        connection = DriverManager.getConnection(jdbcURL, username, password);
                        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                        preparedStatementOne.execute();
                        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET firstname = '" + newText + "' WHERE email = '" + Profile.getEmail() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    Profile.setFirstName(newText);
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                case "Last Name":
                    try {
                        connection = DriverManager.getConnection(jdbcURL, username, password);
                        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                        preparedStatementOne.execute();
                        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET lastname = '" + newText + "' WHERE email = '" + Profile.getEmail() + "'");
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
                        connection = DriverManager.getConnection(jdbcURL, username, password);
                        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                        preparedStatementOne.execute();
                        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET phone = '" + newText + "' WHERE email = '" + Profile.getEmail() + "'");
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("" + e);
                    }
                    Profile.setPhone(newText);
                    updateLabel.setVisible(true);
                    setMainTextArea();
                    break;
                case "Email Address":
                    try {
                        connection = DriverManager.getConnection(jdbcURL, username, password);
                        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                        preparedStatementOne.execute();
                        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET email = '" + newText + "' WHERE phone = '" + Profile.getPhone() + "'");
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
                        connection = DriverManager.getConnection(jdbcURL, username, password);
                        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                        preparedStatementOne.execute();
                        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET address = '" + newText + "' WHERE email = '" + Profile.getEmail() + "'");
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
