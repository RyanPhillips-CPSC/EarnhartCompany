package com.example.demo1;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
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
    private MenuBar exitMenu;

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
        exitMenu.setOnMouseClicked(e -> Platform.exit());

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
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
    void displayAbout(ActionEvent event) {
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
            helpPopup.show(exitMenu.getScene().getWindow());
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
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
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
    }
}



