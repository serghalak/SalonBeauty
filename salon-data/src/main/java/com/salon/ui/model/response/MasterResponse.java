package com.salon.ui.model.response;

import com.salon.ui.model.request.SpecializationRequest;

import java.util.HashSet;
import java.util.Set;


public class MasterResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private Set<SpecializationRequest> specializations=new HashSet<>();//specializationRequests;

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
}
