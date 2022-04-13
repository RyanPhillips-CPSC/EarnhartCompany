package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

public class NewAssociateController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button newAssociateButton;

    @FXML
    private ImageView myImageView;

    @FXML
    private Label invalidLabel;

    @FXML
    private TextField newAssociateAddress;

    @FXML
    private TextField newAssociateEmail;

    @FXML
    private TextField newAssociateName;

    @FXML
    private TextField newAssociatePassword;

    @FXML
    private TextField newAssociatePhone;

    @FXML
    private TextField newAssociateUserID;

    @FXML
    private ComboBox<String> newAssociateTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newAssociateTitle.setItems(FXCollections.observableArrayList("Sales Associate","Cashier","Asset Protection",
                "Freight Associate","Assistant Manager","Manager"));

        newAssociateButton.setStyle("-fx-background-color: blue");
        newAssociateButton.setDisable(true);

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture2.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }

    /**
     * Saves user input into the database table (associate) and returns to the main menu
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    void newAssociateSubmit(ActionEvent event) throws IOException {
        String name, phone, email, address, userID, password, associateTitle;
        name = newAssociateName.getText();
        phone = newAssociatePhone.getText();
        email = newAssociateEmail.getText();
        address = newAssociateAddress.getText();
        userID = newAssociateUserID.getText();
        password = newAssociatePassword.getText();
        associateTitle = newAssociateTitle.getValue();

        //If they are not null, proceed to assignment
        if (name.equals("") || phone.equals("") || email.equals("") || address.equals("") || userID.equals("") || password.equals("") || associateTitle.equals("")) {
            invalidLabel.setVisible(true);
        } else {

            Associate a = new Associate(name, phone, email, address, userID, password, associateTitle);
            Main.getAssociates().add(a);

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientInfo", "root", "aTundeAdjuah_22!");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into associate values ('" + name + "','" + phone + "','" + email + "','" + address + "','" + userID + "','" + password + "','" + associateTitle + "')");
                preparedStatement.executeUpdate();

                FXMLLoader loader = new FXMLLoader(Controller.class.getResource("MainMenu.fxml"));
                Parent mainCallWindowFXML = loader.load();
                stage = (Stage) myImageView.getScene().getWindow();
                scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
                scene.getStylesheets().add("menuStyle.css");
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (SQLException s) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }
        }
    }

    /**
     * Switches to program settings
     * @param event
     * @throws IOException
     */
    @FXML
    void settings(ActionEvent event) throws IOException {
        super.settings(myImageView);
    }

    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
        super.helpDisplay(myImageView);
    }

    @FXML
    void exit (ActionEvent event) throws IOException {
        super.exit(myImageView);
    }

    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        super.newAssociate(event);
    }

    @FXML
    void newCustomer(ActionEvent event) throws IOException {
        super.newCustomer(event);
    }

    @FXML
    void newProduct(ActionEvent event) throws IOException {
        super.newProduct(event);
    }

    @FXML
    void customerRecords(ActionEvent event) throws IOException {
        super.customerRecords(event);
    }

    @FXML
    void productRecords(ActionEvent event) throws IOException {
        super.productRecords(event);
    }

    @FXML
    void associateRecords(ActionEvent event) throws IOException {
        super.associateRecords(event);
    }

    @FXML
    void removeAssociate(ActionEvent event) throws IOException {
        super.removeAssociate(event);
    }

    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        super.removeCustomer(event);
    }

    @FXML
    void removeProduct(ActionEvent event) throws IOException {
        super.removeProduct(event);
    }
}



