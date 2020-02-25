package com.salon.ui.model.request;

import com.salon.domain.Authority;
import com.salon.domain.Client;
import com.salon.domain.Person;
import com.salon.domain.PersonExt;

public class UserRequest /*extends Person *//*PersonExt*/ {

    protected String userId;
    protected String password;
    protected String userName;

    protected AuthorityRequest authority;

    protected boolean userIsClient=true;

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

    public AuthorityRequest getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityRequest authority) {
        this.authority = authority;
    }
}
