package com.salon.ui.model.request;


import java.io.Serializable;

public class UserClientRequest implements Serializable/*extends UserRequest*//*extends PersonRequest*/ {

    private PersonRequest person;

    public PersonRequest getPerson() {
        return person;
    }

    public void setPerson(PersonRequest person) {
        this.person = person;
    }

    //    private ClientRequest client;
//
//    public ClientRequest getClient() {
//        return client;
//    }
//
//    public void setClient(ClientRequest client) {
//        this.client = client;
//    }
}
