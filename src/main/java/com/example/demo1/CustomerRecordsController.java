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

public class CustomerRecordsController extends Controller implements Initializable {

    @FXML
    private ImageView myImageView;

    @FXML ImageView backgroundImageView;

    @FXML
    private TextArea textArea = new TextArea("Customer Records --------------------" +
            "----------------------------------------------------------\n\n");

    /**
     * Iterate through each Customer recursively
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.appendText("Customer Records --------------------" +
                "-----------------------------------------------------------\n\n");
        for (int i = 0; i < Main.getCustomers().size(); i++) {
            textArea.appendText(Main.getCustomers().get(i).getName() + "\nPhone -- " +
                    Main.getCustomers().get(i).getPhone() + "\nEmail -- " + Main.getCustomers().get(i).getEmail() + "\nAddress -- "
                    + Main.getCustomers().get(i).getAddress() + "\n");
            textArea.appendText("\n----------------------------------------------------" +
                    "-----------------------------------------------\n");
        }

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture4.png")));
            backgroundImageView.setImage(logo);
            backgroundImageView.setVisible(true);
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
