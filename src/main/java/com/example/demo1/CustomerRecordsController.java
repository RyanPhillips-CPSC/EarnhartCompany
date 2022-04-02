package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
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
import java.util.ResourceBundle;

public class CustomerRecordsController implements Initializable {

    private Popup helpPopup;
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
     * Displays information related to the current Scene without closing the current Stage
     * @param event
     */
    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
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
}
