package com.salon.ui.model.request;


public class UserClientRequest extends UserRequest {

    private ClientRequest client;

    public ClientRequest getClient() {
        return client;
    }

    public void setClient(ClientRequest client) {
        this.client = client;
    }
}
