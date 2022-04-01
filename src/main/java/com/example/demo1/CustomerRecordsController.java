package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerRecordsController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextArea textArea = new TextArea("Customer Records --------------------" +
            "----------------------------------------------------------\n\n");

    /**
     * Returns to the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }

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
                           Main.getCustomers().get(i).getCustomerOrders().get(j).getOrderItems().get(k).getPrice() + "\n");
                    textArea.appendText("-------\n");
                }
            }
            textArea.appendText("\n----------------------------------------------------" +
                    "-----------------------------------------------\n");
        }
    }
}
