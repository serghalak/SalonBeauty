package com.salon.ui.model.request;

import com.salon.domain.Client;
import com.salon.domain.Person;
import com.salon.domain.PersonExt;

public class UserRequest /*extends Person *//*PersonExt*/ {

    private String userId;
    private String password;
    private String userName;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private boolean isClient=true;

    //private ClientRequest clientRequest;


    // get and set--------------------------------------------------
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    public ClientRequest getClientRequest() {
//        return clientRequest;
//    }
//
//    public void setClientRequest(ClientRequest clientRequest) {
//        this.clientRequest = clientRequest;
//    }
}
