package com.example.demo1;

import java.io.FileWriter;
import java.io.IOException;

public class Associate extends Person {

    private String userID;
    private String password;
    private AssociateTitle associateTitle;

    public Associate(){}

    public Associate(String name, String phone, String email, String address, String userID, String password, AssociateTitle associateTitle) {
        super(name, phone, email, address);
        this.userID = userID;
        this.password = password;
        this.associateTitle = associateTitle;
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

    public void writeAssociate() throws IOException {
        FileWriter fileWriter = new FileWriter("Associates\\AssociateList", true);
        fileWriter.write(this.name + "\n");
        fileWriter.write(this.phone + "\n");
        fileWriter.write(this.email + "\n");
        fileWriter.write(this.address + "\n");
        fileWriter.write(this.userID + "\n");
        fileWriter.write(this.password + "\n");
        fileWriter.write(String.valueOf(this.associateTitle) + "\n");
        fileWriter.close();
    }

    public void rewriteAssociate() throws IOException {
        FileWriter fileWriter = new FileWriter("Associates\\AssociateList");
        fileWriter.write(this.name + "\n");
        fileWriter.write(this.phone + "\n");
        fileWriter.write(this.email + "\n");
        fileWriter.write(this.address + "\n");
        fileWriter.write(this.userID + "\n");
        fileWriter.write(this.password + "\n");
        fileWriter.write(String.valueOf(this.associateTitle) + "\n");
        fileWriter.close();
    }
}
