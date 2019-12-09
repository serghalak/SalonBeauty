package com.salon.controllers;

//import com.salon.service.UserService;
//import com.salon.shared.dto.UserDto;
//import com.salon.ui.model.request.UserRequest;
//import com.salon.ui.model.response.UserResponse;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import com.salon.domain.Client;
import com.salon.domain.Person;
import com.salon.dto.UserDto;
import com.salon.services.UserService;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.UserResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class UserController {

    //@Autowired
    private UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<UserResponse> getAllListUsers(){

        List<UserResponse>userResponseList=new ArrayList<>();
        List<UserDto> listUsers = userService.getListUsers();
        if(listUsers.isEmpty() || listUsers==null){
            throw new RuntimeException("List of users is empty");
        }
        for (UserDto userDto:listUsers){
            UserResponse userResponse=new UserResponse();
            BeanUtils.copyProperties(userDto,userResponse);
            userResponseList.add(userResponse);
        }
        return userResponseList;
        //return "get some user !!!...";
    }

    @GetMapping(value = "/{userId}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public UserResponse getUserByUserId(@PathVariable("userId")String userId){
        UserDto userDb=userService.getUserByUserId(userId);
        UserResponse userResponse=new UserResponse();
        BeanUtils.copyProperties(userDb,userResponse);
        return userResponse;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public UserResponse createUser(
            @RequestBody UserRequest userRequest){

        UserResponse userResponse=new UserResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);
        System.out.println("-------------------------------");
//        Client client=null;
//
//        if(userRequest.isClient()){
//            client=new Client();
//            //client.setFirstName(userRequest.getFirstName());
//            BeanUtils.copyProperties(userDto,client);
//
//        }

        UserDto createdUser=userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser,userResponse);

//        userResponse.setFirstName(userRequest.getFirstName());
//        userResponse.setLastName(userRequest.getLastName());
//        userResponse.setEmail(userRequest.getEmail());
//        userResponse.setPhoneNumber(userRequest.getPhoneNumber());
//        userResponse.setUserId(UUID.randomUUID().toString());
        return userResponse;
        //return "post some user !!!...";
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public /*UserResponse*/String updateUser(
            /*@RequestBody UserRequest userRequest*/){

//        if(userRequest==null){
//            throw new RuntimeException("User for update is wronge");
//        }
//        UserDto userDto=new UserDto();
//        BeanUtils.copyProperties(userRequest,userDto);
//        UserDto userUpdated= userService.updateUser(userDto);
//        if(userUpdated==null){
//            throw new RuntimeException("Error during updating");
//        }
//        UserResponse userReturn=new UserResponse();
//        BeanUtils.copyProperties(userUpdated,userReturn);
//        return userReturn;
        return "put update some user ...";
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public /*void*/String deleteUser(/*@RequestBody UserRequest user*/){
//        if(user==null){
//            throw new RuntimeException("user is wronge");
//        }
//        UserDto userDto=new UserDto();
//        BeanUtils.copyProperties(user,userDto);
//        userService.deleteUser(userDto);
        return "delete delete some user ...";
    }

    @PutMapping("/put")
    public String testPut(){
        return "from /put";
    }
}
