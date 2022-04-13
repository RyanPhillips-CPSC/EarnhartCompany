package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerRecordsController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private MenuBar exitMenu;

    @FXML
    private ImageView myImageView;

    @FXML
    private TextArea textArea = new TextArea("Customer Records --------------------" +
            "----------------------------------------------------------\n\n");

    /**
     * Iterate through each Customer recursively (Customer -> Orders -> Items -> repeat)
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
                    + Main.getCustomers().get(i).getAddress() + "\nOrders -- " + Main.getCustomers().get(i).getCustomerOrders().size() + "\n");
            textArea.appendText("--------------\n");
            for (int j = 0; j < Main.getCustomers().get(i).getCustomerOrders().size(); j++) {
                textArea.appendText("Order ID - " + Main.getCustomers().get(i).getCustomerOrders().get(j).getCurrentOrderID()
                        + "\nOrder Total - " + Main.getCustomers().get(i).getCustomerOrders().get(j).getTotal() + "\nOrder Tax - "
                        + Main.getCustomers().get(i).getCustomerOrders().get(j).getTax() + "\nPurchase Quantity - "
                        + Main.getCustomers().get(i).getCustomerOrders().get(j).getOrderItems().size() + "\n");
                textArea.appendText("--------------\n");
                for (int k = 0; k < Main.getCustomers().get(i).getCustomerOrders().get(j).getOrderItems().size(); k++) {
                   textArea.appendText(Main.getCustomers().get(i).getCustomerOrders().get(j).getOrderItems().get(k).getName()
                           + "\nSku: " + Main.getCustomers().get(i).getCustomerOrders().get(j).getOrderItems().get(k).getSku() + "\nCost: " +
                           Main.getCustomers().get(i).getCustomerOrders().get(j).getOrderItems().get(k).getsPrice() + "\n");
                    textArea.appendText("-------\n");
                }
            }
            textArea.appendText("\n----------------------------------------------------" +
                    "-----------------------------------------------\n");
        }
        exitMenu.setOnMouseClicked(e -> Platform.exit());

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
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
