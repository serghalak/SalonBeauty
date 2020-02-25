package com.salon.dto;

import java.io.Serializable;
import java.util.Set;


public class UserMasterDto implements  Serializable /*extends PersonDto*/ {


    private PersonDto person;

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    private Set<SpecializationDto>specializations;

    public Set<SpecializationDto> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationDto> specializations) {
        this.specializations = specializations;
    }

    //    private MasterDto master;//Dto;
//
//
//    public MasterDto getMaster() {
//        return master;
//    }
//
//    public void setMaster(MasterDto master) {
//        this.master = master;
//    }
}
