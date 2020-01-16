package com.salon.ui.model.response;


import com.salon.ui.model.request.MasterRequest;

public class UserMasterResponse {

    private String userId;
    //private String password;
    private String userName;

    private MasterRequest master;//Request;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MasterRequest getMaster() {
        return master;
    }

    public void setMaster(MasterRequest master) {
        this.master = master;
    }
}
