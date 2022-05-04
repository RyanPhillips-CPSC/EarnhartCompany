package com.example.demo1;

public class Admin {

    private static String userID;
    private static String password;

    public Admin() {
    }

    public Admin(String userID, String password) {
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
