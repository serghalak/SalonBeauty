package com.salon.ui.model.request;


import com.salon.domain.Master;

public class UserMasterRequest extends UserRequest {

    private MasterRequest master;//Request;


    public MasterRequest getMaster() {
        return master;
    }

    public void setMaster(MasterRequest master) {
        this.master = master;
    }
}
