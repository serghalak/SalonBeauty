package com.salon.controllers;

import com.salon.domain.Specialization;
import com.salon.dto.MasterDto;
import com.salon.dto.SpecializationDto;
import com.salon.dto.UserDto;
import com.salon.dto.UserMasterDto;
import com.salon.services.MasterService;
import com.salon.services.UserService;
import com.salon.ui.model.request.MasterRequest;
import com.salon.ui.model.request.UserMasterRequest;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.MasterResponse;
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
    private MasterService masterService;

    public MasterController(UserService userService, MasterService masterService) {
        this.userService = userService;
        this.masterService=masterService;
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
            path="/{userName}"
            ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public UserMasterResponse getMasterByUserName(@PathVariable String userName){

        if(userName.equals("") || userName.isEmpty() || userName==null){
            throw new RuntimeException("User name is wrong ");
        }
        UserMasterDto userMasterDto = userService.getUserMasterDto(userName);

        if(userMasterDto==null){
            throw new RuntimeException("User with user name: "+userName +" is not found");
        }


//        if(userDto.isClient()){
//            throw new RuntimeException("The userName: " + userName + " is not master");
//        }
//        MasterDto masterDto=masterService.getMaster(userDto.getUserName());
//        if(userMasterDto==null){
//            throw new RuntimeException("The userName: "+userName+" is wrong");
//        }

        ModelMapper modelMapper=new ModelMapper();
        UserMasterResponse  returnValue=  modelMapper.map(userMasterDto, UserMasterResponse.class);


        return returnValue ;
    }
}
