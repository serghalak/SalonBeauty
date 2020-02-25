package com.salon.domain;

import javax.persistence.*;

//@MappedSuperclass
@Entity
public class Person extends IdEntity{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;


//    @OneToOne(cascade = {CascadeType.ALL},mappedBy = "person")
//    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = {CascadeType.ALL},mappedBy = "person")
    private Client client;

    @OneToOne(cascade = {CascadeType.ALL},mappedBy = "person")
    private Master master;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
