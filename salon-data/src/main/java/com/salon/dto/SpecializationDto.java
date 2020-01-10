package com.salon.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


public class SpecializationDto implements Serializable {

    private long id;
    private String specializationName;

    private Set<MasterDto> masters;//master;//masterDtoList;

    public Set<MasterDto> getMasters() {
        return masters;
    }

    public void setMasters(Set<MasterDto> masters) {
        this.masters = masters;
    }

    //    public MasterDto getMaster() {
//        return master;
//    }
//
//    public void setMaster(MasterDto master) {
//        this.master = master;
//    }

    //    public List<MasterDto> getMasterDtoList() {
//        return masterDtoList;
//    }
//
//    public void setMasterDtoList(List<MasterDto> masterDtoList) {
//        this.masterDtoList = masterDtoList;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
