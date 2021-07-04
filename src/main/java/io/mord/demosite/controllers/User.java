package io.mord.demosite.controllers;

public class User {

    private String fName;
    private String lName; 
    private String eAddr;
    private String uName;
    private int identifier; 
    
    public User(String firstName, String lastName, String emailAddr, String userName, int id) {
        fName = firstName;
        lName = lastName; 
        eAddr = emailAddr; 
        uName = userName; 
        identifier = id; 
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName; 
    }

    public String getEmailAddr() {
        return eAddr;
    }

    public static User userObject(User user) {

        return user; 
    }




}
