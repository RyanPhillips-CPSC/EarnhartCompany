package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAssociateController implements Initializable {

    private Stage stage;
    private Scene scene;

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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//New associate methods
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newAssociateTitle.setItems(FXCollections.observableArrayList("Sales Associate","Cashier","Asset Protection",
                "Freight Associate","Assistant Manager","Manager"));
    }

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
        AssociateTitle associateTitle1 = returnTitle(associateTitle);

        //If they are not null, proceed to assignment
        Associate a = new Associate(name,phone,email,address,userID,password, associateTitle1);
        Main.getAssociates().add(a);
        a.writeAssociate();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
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
}



