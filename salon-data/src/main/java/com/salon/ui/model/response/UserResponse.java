package com.salon.ui.model.response;

import org.springframework.hateoas.RepresentationModel;



public class UserResponse extends RepresentationModel  /*extends Person*/ /*PersonExt*/{

    private String userId;
    private String userName;
    private Boolean userIsClient=true;

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

    public Boolean getUserIsClient() {
        return userIsClient;
    }

    public void setUserIsClient(Boolean userIsClient) {
        this.userIsClient = userIsClient;
    }
}
