package com.salon.ui.model.response;

import com.salon.ui.model.request.SpecializationRequest;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;


public class MasterResponse extends RepresentationModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private Set<SpecializationResponse> specializations=new HashSet<>();//specializationResponse;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<SpecializationResponse> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationResponse> specializations) {
        this.specializations = specializations;
    }
}
