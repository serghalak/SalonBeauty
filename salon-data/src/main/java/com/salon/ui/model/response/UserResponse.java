package com.salon.ui.model.response;

import com.salon.domain.Authority;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;


public class UserResponse  extends RepresentationModel /*extends Person*/ /*PersonExt*/{

    protected String userId;
    protected String userName;
    protected Boolean active;
    protected Boolean userIsClient=true;
    protected Authority authority;

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
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
        this.userIsClient = userIsClient;
    }
}
