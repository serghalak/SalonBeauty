package com.salon.dto;


import com.salon.domain.Specialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MasterDto implements Serializable{

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Set<SpecializationDto> specializations
            =new HashSet<>();//specializationDtoList;

    //private UserDto user;//userDtoList;

//    public List<UserDto> getUserDtoList() {
//        return userDtoList;
//    }
//
//    public void setUserDtoList(List<UserDto> userDtoList) {
//        this.userDtoList = userDtoList;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public List<SpecializationDto> getSpecializationDtoList() {
//        return specializationDtoList;
//    }
//
//    public void setSpecializationDtoList(List<SpecializationDto> specializationDtoList) {
//        this.specializationDtoList = specializationDtoList;
//    }


    public Set<SpecializationDto> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationDto> specializations) {
        this.specializations = specializations;
    }

//    public UserDto getUser() {
//        return user;
//    }
//
//    public void setUser(UserDto user) {
//        this.user = user;
//    }
}
