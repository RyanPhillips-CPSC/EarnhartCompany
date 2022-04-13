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

public class NewProductController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button newProductButton;

    @FXML
    private Label invalidLabel;

    @FXML
    private ImageView myImageView;

    @FXML
    private TextField iPrice;

    @FXML
    private TextField iName;

    @FXML
    private TextField iSku;

    /**
     * Saves user input into the database table (product) and returns to the main menu
     * @param event
     * @throws SQLException
     */
    @FXML
    void submit(ActionEvent event) {
        String name, sku,price;
        name = iName.getText();
        sku = iSku.getText();
        price = iPrice.getText();

        if (name == "" || sku == "" || price == "") {
            invalidLabel.setVisible(true);
        } else {
            Item it = new Item(name, sku, price);
            Main.getItems().add(it);

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientInfo", "root", "aTundeAdjuah_22!");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into product values ('"+name+"','"+sku+"','"+price+"')");
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
        newProductButton.setStyle("-fx-background-color: blue");
        newProductButton.setDisable(true);

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture6.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }

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
