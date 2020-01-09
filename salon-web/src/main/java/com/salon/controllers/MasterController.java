package com.salon.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/masters")
public class MasterController {

    @GetMapping
    public void getAllMasters(){
        System.out.println("api/masters/ all masters");
    }
}
