package com.salon.dto;

import java.io.Serializable;


public class UserMasterDto extends UserDto {


    private MasterDto master;//Dto;


    public MasterDto getMaster() {
        return master;
    }

    public void setMaster(MasterDto master) {
        this.master = master;
    }
}
