package com.example.demo;

/**
 *
 */
public class User {

    private static String userID;
    private static String password;

    public User() {
    }

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public static String getUserID() {
        return userID;
    }

    public static String getPassword() {
        return password;
    }
}
