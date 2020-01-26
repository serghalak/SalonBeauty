package com.salon.dto;

import java.io.Serializable;


public class UserMasterDto implements Serializable {

    private Long id;
    private String userId;
    private String userName;
    private String password;
    private String activateCode;
    private Boolean active=false;
    private Boolean userIsClien=false;

    //private String password;
    //private String emailStatus;

    private MasterDto master;//Dto;

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

    public Boolean getUserIsClien() {
        return userIsClien;
    }

    public void setUserIsClien(Boolean userIsClien) {
        this.userIsClien = userIsClien;
    }

    //    public MasterDto getMasterDto() {
//        return masterDto;
//    }
//
//    public void setMasterDto(MasterDto masterDto) {
//        this.masterDto = masterDto;
//    }


    public MasterDto getMaster() {
        return master;
    }

    public void setMaster(MasterDto master) {
        this.master = master;
    }
}
