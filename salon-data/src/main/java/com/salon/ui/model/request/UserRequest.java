package com.salon.ui.model.request;

import com.salon.domain.Client;
import com.salon.domain.Person;
import com.salon.domain.PersonExt;

public class UserRequest /*extends Person *//*PersonExt*/ {

    private String userId;
    private String password;
    private String userName;

    private boolean userIsClient=true;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isUserIsClient() {
        return userIsClient;
    }

    public void setUserIsClient(boolean userIsClient) {
        this.userIsClient = userIsClient;
    }
}
