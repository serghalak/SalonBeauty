package com.salon.controllers;


import com.salon.domain.User;
import com.salon.dto.ClientDto;
import com.salon.dto.UserClientDto;
import com.salon.services.UserService;
import com.salon.ui.model.response.ClientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

//@RestController
//@RequestMapping("api/clients")
public class ClientController {

    private UserService userService;

    public ClientController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public void getAllClientAppointments(){
        System.out.println("api/clients get method ....");

    }

//    @GetMapping(path = "/{clientId}"
//            ,produces = {MediaType.APPLICATION_JSON_VALUE
//                ,MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
//    public ClientResponse getClientById(@PathVariable Long clientId){
//        ClientDto client = userService.getClientByClientId(clientId);
//        UserClientDto userClient = userService.getUserClientByClientId(clientId);
//        if(client==null){
//            throw new RuntimeException("Client not found");
//        }
//        if(userClient==null){
//            throw new RuntimeException("User for client: " + client.getFirstName()+" " +client.getLastName()+" not found");
//        }
//
//
//        ModelMapper modelMapper=new ModelMapper();
//        ClientResponse returnValue = modelMapper.map(client, ClientResponse.class);
//        Link link=linkTo(ClientController.class).slash(clientId).withSelfRel();
//        Link userLink=linkTo(UserClientController.class).slash(userClient.getUserId()).withRel("user");
//        returnValue.add(link,userLink);
//
//        return returnValue;
//    }

}
