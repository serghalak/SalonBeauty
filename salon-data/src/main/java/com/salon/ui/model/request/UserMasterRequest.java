package com.salon.ui.model.request;


import com.salon.domain.Master;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserMasterRequest implements Serializable /*extends UserRequest*//*extends PersonRequest*/ {

    private PersonRequest person;

    public PersonRequest getPerson() {
        return person;
    }

    public void setPerson(PersonRequest person) {
        this.person = person;
    }

    private Set<SpecializationRequest> specializations=new HashSet<>();//specializationRequests;

    public Set<SpecializationRequest> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationRequest> specializations) {
        this.specializations = specializations;
    }


//    private MasterRequest master;//Request;
//
//
//    public MasterRequest getMaster() {
//        return master;
//    }
//
//    public void setMaster(MasterRequest master) {
//        this.master = master;
//    }
}
