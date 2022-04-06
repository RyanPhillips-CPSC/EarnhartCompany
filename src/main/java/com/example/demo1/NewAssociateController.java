package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewAssociateController implements Initializable {

    private Popup helpPopup;
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
        if (helpPopup != null) { helpPopup.hide();}
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

                Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root, Color.TRANSPARENT);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.setTitle("Main Menu");
                stage.show();
                stage.centerOnScreen();
            } catch (SQLException s) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }
        }
    }

    /**
     * Returns the associate type that corresponds to the user's comboBox selection
     * @param comboBoxSelection
     * @return
     */
    public static AssociateTitle returnTitle(String comboBoxSelection){
        if (comboBoxSelection.equals("Sales Associate")) return AssociateTitle.SalesAssociate;
        if (comboBoxSelection.equals("Cashier")) return AssociateTitle.Cashier;
        if (comboBoxSelection.equals("Asset Protection")) return AssociateTitle.AssetProtection;
        if (comboBoxSelection.equals("Freight Associate")) return AssociateTitle.FreightAssociate;
        if (comboBoxSelection.equals("Assistant Manager")) return AssociateTitle.AssistantManager;
        if (comboBoxSelection.equals("Manager")) return AssociateTitle.Manager;
        return null;
    }

    /**
     * Displays information related to the current Scene without closing the current Stage
     * @param event
     */
    @FXML
    void helpDisplay(ActionEvent event) {
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
     * Returns to the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void exit(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) myImageView.getScene().getWindow();
        scene = new Scene (mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
        scene.getStylesheets().add("menuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

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
        Stage thisStage = (Stage) myImageView.getScene().getWindow();
        Scene mainCallWindow = new Scene (mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
        mainCallWindow.getStylesheets().add("style.css");
        thisStage.setScene(mainCallWindow);
        stage.centerOnScreen();
    }
    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("NewAssociateInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,575, Color.TRANSPARENT);
        scene.getStylesheets().add("menuStyle.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }
    @FXML
    void newCustomer(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("NewCustomerInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 602,432, Color.TRANSPARENT);
        scene.getStylesheets().add("customer.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }
    @FXML
    void newProduct(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("NewProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("product.css");
        stage.setScene(scene);
        stage.setTitle("New Product Form");
        stage.show();
        stage.centerOnScreen();
    }
    @FXML
    void customerRecords(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("CustomerRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.setY(30);
        stage.show();
    }
    @FXML
    void productRecords(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("ProductRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Product Form");
        stage.setY(30);
        stage.show();
    }
    @FXML
    void associateRecords(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("AssociateRecords.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,725, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Associate Data");
        stage.setY(30);
        stage.show();
    }
    @FXML
    void removeAssociate(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveAssociate.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("removeAssociate.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }
    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("removeAssociate.css");
        stage.setScene(scene);
        stage.setTitle("Associate Portal");
        stage.show();
        stage.centerOnScreen();
    }
    @FXML
    void removeProduct(ActionEvent event) throws IOException {
        if (helpPopup != null) { helpPopup.hide();}
        Parent root = FXMLLoader.load(getClass().getResource("RemoveProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Product Removal Form");
        stage.show();
    }
}



