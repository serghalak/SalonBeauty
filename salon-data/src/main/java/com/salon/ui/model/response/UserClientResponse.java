package com.salon.ui.model.response;


import com.salon.domain.Client;
import org.springframework.hateoas.RepresentationModel;

public class UserClientResponse /*extends UserResponse*/ {

    private PersonResponse person;

    public PersonResponse getPerson() {
        return person;
    }

    public void setPerson(PersonResponse person) {
        this.person = person;
    }

    //    private ClientResponse client;//Response;
//
//    public ClientResponse getClient() {
//        return client;
//    }
//
//    public void setClient(ClientResponse client) {
//        this.client = client;
//    }
}
