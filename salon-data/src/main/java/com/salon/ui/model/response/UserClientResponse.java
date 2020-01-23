package com.salon.ui.model.response;


import com.salon.domain.Client;
import org.springframework.hateoas.RepresentationModel;

public class UserClientResponse extends UserResponse {

    private ClientResponse client;//Response;

    public ClientResponse getClient() {
        return client;
    }

    public void setClient(ClientResponse client) {
        this.client = client;
    }
}
