package com.salon.dto;




public class UserClientDto  extends UserDto{

    private ClientDto client;

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
