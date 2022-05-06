package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    private static ArrayList<Admin> admins = new ArrayList();

    /**
     * Sets important Stage properties and loads the initial Scene
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 549, Color.TRANSPARENT);
        stage.setTitle("The Earnhart Company");
        stage.setResizable(false);
        stage.setScene(scene);
        scene.getStylesheets().add("loginStyle.css");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/windowIcon.png"))));
        stage.show();
        stage.centerOnScreen();
    }

    /**
     * Runs the GUI
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        associateAssignment();
        launch();
    }

    /**
     * Adds administrator login info to an ArrayList for easy access
     */
    public static void associateAssignment() {
        String userID, password;

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "root";
        String sqlPassword = "aTundeAdjuah_22!";

        try {
            Connection connection = DriverManager.getConnection(host, user, sqlPassword);
            PreparedStatement statement = connection.prepareStatement("select * from login where login.UserID <> 'null'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                userID = ("" + resultSet.getObject("UserID"));
                password = ("" + resultSet.getObject("Password"));
                Admin a = new Admin(userID,password);
                admins.add(a);
            }
        } catch (SQLException e) {
            System.out.println("ERROR CONNECTING TO DATABASE OR EXECUTING QUERY");
        }
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
}