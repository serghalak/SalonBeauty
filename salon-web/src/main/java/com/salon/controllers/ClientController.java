package com.salon.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    @GetMapping
    public void getAllClientAppointments(){
        System.out.println("api/clients get method ....");

    }
}
