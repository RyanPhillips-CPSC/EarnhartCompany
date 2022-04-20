package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AssociateRecordsController extends Controller implements Initializable {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private ImageView myImageView;

    @FXML
    private TextArea textArea = new TextArea("Associate Records --------------------" +
            "----------------------------------------------------------\n\n");

    /**
     * Fills the ListView with associate information
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture4.png")));
            backgroundImageView.setImage(logo);
            backgroundImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }

        textArea.appendText("Associate Records --------------------" +
                "-----------------------------------------------------------\n\n");
        for (int i = 0; i < Main.getAssociates().size(); i++) {
            textArea.appendText(Main.getAssociates().get(i).getName() + "\nPhone -- " +
                    Main.getAssociates().get(i).getPhone() + "\nEmail -- " + Main.getAssociates().get(i).getEmail() + "\nAddress -- "
            + Main.getAssociates().get(i).getAddress() + "\nPosition -- " + Main.getAssociates().get(i).getAssociateTitle() + "\nUser ID -- "
            + Main.getAssociates().get(i).getUserID() + "\nPassword -- " + Main.getAssociates().get(i).getPassword());
            textArea.appendText("\n----------------------------------------------------" +
                    "-----------------------------------------------\n");
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
