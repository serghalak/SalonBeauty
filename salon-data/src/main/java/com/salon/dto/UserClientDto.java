package com.salon.dto;

import java.io.Serializable;

public class UserClientDto  implements Serializable/*extends PersonDto*/{

    private PersonDto person;

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    //    private ClientDto client;
//
//    public ClientDto getClient() {
//        return client;
//    }
//
//    public void setClient(ClientDto client) {
//        this.client = client;
//    }
}
