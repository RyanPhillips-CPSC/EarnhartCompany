package com.example.demo1;

public class Associate extends Person {

    private String userID;
    private String password;
    private String associateTitle;

    public Associate(){}

    public Associate(String name, String phone, String email, String address, String userID, String password, String associateTitle) {
        super(name, phone, email, address);
        this.userID = userID;
        this.password = password;
        this.associateTitle = associateTitle;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getAssociateTitle() {
        return associateTitle;
    }
}
