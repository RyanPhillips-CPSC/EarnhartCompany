package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class NewCustomerController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label addressLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Button newCustomerButton;

    @FXML
    private Label invalidLabel;

    @FXML
    private ImageView myImageView;

    @FXML
    private TextField cAddress;

    @FXML
    private TextField cEmail;

    @FXML
    private TextField cName;

    @FXML
    private TextField cPhone;

    /**
     * Saves user input into the database table (client) and returns to the main menu
     * @param event
     * @throws SQLException
     */
    @FXML
    void submit(ActionEvent event) {
        String name, email, phone, address;
        name = cName.getText();
        email = cEmail.getText();
        phone = cPhone.getText();
        address = cAddress.getText();

        if (name == "" || email == "" || phone == "" || address == "") {
            invalidLabel.setVisible(true);
        } else {
            //add to ArrayList, then to table
            Customer c = new Customer(name, phone, email, address);
            Main.getCustomers().add(c);

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientInfo", "root", "aTundeAdjuah_22!");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into Client values ('" + name + "','" + phone + "','" + email + "','" + address + "')");
                preparedStatement.executeUpdate();

                FXMLLoader loader = new FXMLLoader(Controller.class.getResource("MainMenu.fxml"));
                Parent mainCallWindowFXML = loader.load();
                stage = (Stage) myImageView.getScene().getWindow();
                scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
                scene.getStylesheets().add("menuStyle.css");
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (Exception e) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }
        }
    }

    /**
     * Sets ImageView and creates close button
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCustomerButton.setStyle("-fx-background-color: blue");
        newCustomerButton.setDisable(true);
        nameLabel.setStyle("-fx-text-fill: black");
        phoneLabel.setStyle("-fx-text-fill: black");
        emailLabel.setStyle("-fx-text-fill: black");
        addressLabel.setStyle("-fx-text-fill: black");


        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture4.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
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

