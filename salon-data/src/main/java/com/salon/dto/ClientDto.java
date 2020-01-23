package com.salon.dto;

import java.io.Serializable;


public class ClientDto /*extends UserDto*/ {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

//    private UserDto userDto;
//
//    public UserDto getUserDto() {
//        return userDto;
//    }
//
//    public void setUserDto(UserDto userDto) {
//        this.userDto = userDto;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
