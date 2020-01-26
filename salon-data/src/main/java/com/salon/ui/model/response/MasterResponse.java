package com.salon.ui.model.response;

import com.salon.ui.model.request.SpecializationRequest;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;


public class MasterResponse extends UserMainResponse {



    private Set<SpecializationResponse> specializations=new HashSet<>();//specializationResponse;



    public Set<SpecializationResponse> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationResponse> specializations) {
        this.specializations = specializations;
    }
}
