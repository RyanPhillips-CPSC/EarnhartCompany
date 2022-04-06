package com.example.demo1;

public class Associate extends Person {

    private String userID;
    private String password;
    private String associateTitleString;
    private AssociateTitle associateTitle;

    public Associate(){}

    public Associate(String name, String phone, String email, String address, String userID, String password, AssociateTitle associateTitle) {
        super(name, phone, email, address);
        this.userID = userID;
        this.password = password;
        this.associateTitle = associateTitle;
    }

    public Associate(String name, String phone, String email, String address, String userID, String password, String associateTitle) {
        super(name, phone, email, address);
        this.userID = userID;
        this.password = password;
        this.associateTitleString = associateTitle;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AssociateTitle getAssociateTitle() {
        return associateTitle;
    }

    public void setAssociateTitle(AssociateTitle associateTitle) {
        this.associateTitle = associateTitle;
    }
}
