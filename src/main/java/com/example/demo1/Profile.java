package com.example.demo1;

public class Profile {

    private static String firstName;
    private static String lastName;
    private static String email;
    private static String address;
    private static String phone;

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Profile.firstName = firstName;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        Profile.phone = phone;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Profile.address = address;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Profile.email = email;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Profile.lastName = lastName;
    }
}
