package com.salon.ui.model.response;


import com.salon.ui.model.request.MasterRequest;
import org.springframework.hateoas.RepresentationModel;

public class UserMasterResponse extends RepresentationModel {

    private String userId;
    //private String password;
    private String userName;

    private MasterResponse master;//Response;

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

    public MasterResponse getMaster() {
        return master;
    }

    public void setMaster(MasterResponse master) {
        this.master = master;
    }
}
