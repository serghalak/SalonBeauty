package com.salon.dto;


import java.io.Serializable;

public class UserClientDto  implements Serializable{

    private Long id;
    private String userId;
    private String userName;
    private String password;
    private String activateCode;
    private Boolean active=false;
    private Boolean userIsClient=true;

    private ClientDto client;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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


    public Boolean getUserIsClient() {
        return userIsClient;
    }

    public void setUserIsClient(Boolean userIsClient) {
        userIsClient = userIsClient;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
