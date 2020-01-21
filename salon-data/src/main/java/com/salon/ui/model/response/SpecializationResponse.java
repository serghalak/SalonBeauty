package com.salon.ui.model.response;

import org.springframework.hateoas.RepresentationModel;

public class SpecializationResponse extends RepresentationModel {

    private Long id;
    private String specializationName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
