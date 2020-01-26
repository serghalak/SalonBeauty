package com.salon.ui.model.response;




public class UserMasterResponse extends UserResponse {

    private MasterResponse master;//Response;
    public MasterResponse getMaster() {
        return master;
    }
    public void setMaster(MasterResponse master) {
        this.master = master;
    }
}
