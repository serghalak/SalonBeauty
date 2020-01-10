package com.salon.controllers;

import com.salon.dto.UserMasterDto;
import com.salon.services.UserService;
import com.salon.ui.model.request.MasterRequest;
import com.salon.ui.model.request.UserMasterRequest;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/masters")
public class MasterController {


    private UserService userService;

    public MasterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping/*(name = "",consumes = {},produces = {})*/
    public void getAllMasters(){
        System.out.println("api/masters/ all masters");


    }


    @PostMapping(
            path="/created"
            ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public UserMasterRequest createMaster(
            @RequestBody UserMasterRequest userMasterRequest ){


        ModelMapper modelMapper=new ModelMapper();
        UserMasterDto userMasterDto = modelMapper.map(userMasterRequest, UserMasterDto.class);

        UserMasterDto createdUserMasterDto=userService.createUserMaster(userMasterDto);

//        PropertyMap<UserRequest,UserDto>userMap=new PropertyMap<UserRequest, UserDto>() {
//            @Override
//            protected void configure() {
//                map().setUserId(source.getUserId());
//                map().setPassword(source.getPassword());
//                map().setUserName(source.getUserName());
//                map().setClient(source.isClient());
//                map().setFirstName(source.getClientRequest().getFirstName());
//                map().setLastName(source.getClientRequest().getLastName());
//                map().setEmail(source.getClientRequest().getEmail());
//                map().setPhoneNumber(source.getClientRequest().getPhoneNumber());
//            }
//        };




        return userMasterRequest;
    }
}
