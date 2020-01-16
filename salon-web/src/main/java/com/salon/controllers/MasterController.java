package com.salon.controllers;

import com.salon.domain.Specialization;
import com.salon.dto.SpecializationDto;
import com.salon.dto.UserDto;
import com.salon.dto.UserMasterDto;
import com.salon.services.UserService;
import com.salon.ui.model.request.MasterRequest;
import com.salon.ui.model.request.UserMasterRequest;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.SpecializationResponse;
import com.salon.ui.model.response.UserMasterResponse;
import com.salon.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public UserMasterResponse createMaster(
            @RequestBody UserMasterRequest userMasterRequest ){


        ModelMapper modelMapper=new ModelMapper();
        UserMasterDto userMasterDto = modelMapper.map(userMasterRequest, UserMasterDto.class);

        UserMasterDto createdUserMasterDto=userService.createUserMaster(userMasterDto);

        UserMasterResponse userMasterResponse=modelMapper.map(createdUserMasterDto,UserMasterResponse.class);
        return userMasterResponse;



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




        //return userMasterRequest;
    }

    @GetMapping(
            path="/{userName}/specializations"
            ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Set<SpecializationResponse> createMaster(@PathVariable String userName){

        if(userName.equals("") || userName.isEmpty() || userName==null){
            throw new RuntimeException("User name is wronge ");
        }
        UserDto userDto = userService.getUser(userName);
        if(userDto==null){
            throw new RuntimeException("User with user name: "+userName +" is not found");
        }


        Set<SpecializationDto> specializations=userService.getSpecializations(userName);

        if(specializations.isEmpty()){
            throw new RuntimeException("For master: " + userName+" specializations not founded");
        }
        Set<SpecializationResponse>returnValue=new HashSet<>();
        ModelMapper modelMapper=new ModelMapper();
        for (SpecializationDto specializationDto:specializations ) {
            SpecializationResponse specializationResponse =
                    modelMapper.map(specializationDto, SpecializationResponse.class);
            returnValue.add(specializationResponse);
        }

        return returnValue ;
    }
}
