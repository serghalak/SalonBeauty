package com.salon.dto;


import java.io.Serializable;

public class UserDto implements Serializable {

    private Long id;
    private  String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    //private String password;
    private String password;
    private String activateCode;
    //private String emailStatus;
    private Boolean active=false;
    private Boolean client=true;

//    private String password;//plain text
//    private String encryptedPassword;
//    private String emailVerificationToken;
//    private String getEmailVerificationStatus;


    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getClient() {
        return client;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getEncryptedPassword() {
//        return encryptedPassword;
//    }
//
//    public void setEncryptedPassword(String encryptedPassword) {
//        this.encryptedPassword = encryptedPassword;
//    }

//    public String getEmailToken() {
//        return emailToken;
//    }
//
//    public void setEmailToken(String emailToken) {
//        this.emailToken = emailToken;
//    }
//
//    public String getEmailStatus() {
//        return emailStatus;
//    }
//
//    public void setEmailStatus(String emailStatus) {
//        this.emailStatus = emailStatus;
//    }

    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

//    public Boolean getClient() {
//        return isClient;
//    }
//
//    public void setClient(Boolean client) {
//        isClient = client;
//    }


    public Boolean isClient() {
        return client;
    }

    public void setClient(Boolean client) {
        this.client = client;
    }
}
