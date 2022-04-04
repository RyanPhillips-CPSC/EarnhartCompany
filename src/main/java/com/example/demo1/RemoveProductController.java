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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
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

public class RemoveProductController implements Initializable {

    private Stage stage;
    private Scene scene;

    private Popup helpPopup;

    @FXML
    private MenuBar exitMenu;

    @FXML
    private ImageView myImageView;

    @FXML
    private ListView<String> itemList;

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

    /**
     * Returns to main menu
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
     * Displays customer names inside a ListView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleItemClicks();
        for (int i = 0; i < Main.getItems().size(); i++){
            itemList.getItems().add(Main.getItems().get(i).getName());
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
     * Removes the selected customer from the ArrayList and deletes their row on the client table
     */
    public void handleItemClicks() {
        itemList.setOnMouseClicked(event -> {
            String selectedName = itemList.getSelectionModel().getSelectedItem();
            String host = "jdbc:mysql://localhost:3306/clientInfo";
            String user = "root";
            String password = "aTundeAdjuah_22!";

            //remove from ArrayList, then from table
            for (int i = 0; i < Main.getItems().size(); i ++) {
                if (selectedName.equals(Main.getItems().get(i).getName())) {
                    Main.getItems().remove(i);
                }
            }

            try {
                Connection connection = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("delete from product where Name = '"+selectedName+"'");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 600,400, Color.TRANSPARENT);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        });
    }
}
