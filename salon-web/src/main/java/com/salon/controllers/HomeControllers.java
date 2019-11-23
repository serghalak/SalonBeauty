package com.salon.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api","/api/","/api/index","/api/index.html"})
public class HomeControllers {

    @GetMapping
    public String getHome(){
        return "Get home";
    }

    @PostMapping
    public String postHome(){
        return "Post home";
    }

    @PutMapping
    public String putHome(){
        return "put home";
    }

    @DeleteMapping
    public String deleteHome(){
        return "delete home";
    }
}
