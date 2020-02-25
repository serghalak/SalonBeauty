package com.salon.ui.model.request;


import com.salon.domain.Master;
import com.salon.domain.Specialization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MasterRequest extends PersonRequest{

    protected Set<SpecializationRequest> specializations=new HashSet<>();//specializationRequests;

    public Set<SpecializationRequest> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationRequest> specializations) {
        this.specializations = specializations;
    }
}
