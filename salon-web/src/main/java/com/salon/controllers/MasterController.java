package com.salon.controllers;

import com.salon.domain.Specialization;
import com.salon.dto.*;
import com.salon.services.MasterService;
import com.salon.services.UserService;
import com.salon.ui.model.request.MasterRequest;
import com.salon.ui.model.request.UserMasterRequest;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

//@RestController
//@RequestMapping("api/masters")
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


//    @PostMapping(
//            path="/created"
//            ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
//            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//    public UserMasterResponse createMaster(
//            @RequestBody UserMasterRequest userMasterRequest ){
//
//
//        ModelMapper modelMapper=new ModelMapper();
//        UserMasterDto userMasterDto = modelMapper.map(userMasterRequest, UserMasterDto.class);
//
//        UserMasterDto createdUserMasterDto=userService.createUserMaster(userMasterDto);
//
//        UserMasterResponse userMasterResponse=modelMapper.map(createdUserMasterDto,UserMasterResponse.class);
//        return userMasterResponse;
////        PropertyMap<UserRequest,UserDto>userMap=new PropertyMap<UserRequest, UserDto>() {
////            @Override
////            protected void configure() {
////                map().setUserId(source.getUserId());
////                map().setPassword(source.getPassword());
////                map().setUserName(source.getUserName());
////                map().setClient(source.isClient());
////                map().setFirstName(source.getClientRequest().getFirstName());
////                map().setLastName(source.getClientRequest().getLastName());
////                map().setEmail(source.getClientRequest().getEmail());
////                map().setPhoneNumber(source.getClientRequest().getPhoneNumber());
////            }
////        };
//
//
//
//
//        //return userMasterRequest;
//    }

//    @GetMapping(
//            path="/{userName}"
//            ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
//            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//    public UserMasterResponse getUserMasterByUserName(@PathVariable String userName){
//
//        if(userName.equals("") || userName.isEmpty() || userName==null){
//            throw new RuntimeException("User name is wrong ");
//        }
//        UserMasterDto userMasterDto = userService.getUserMasterByUserName(userName);
//
//        if(userMasterDto==null){
//            throw new RuntimeException("User with user name: "+userName +" is not found");
//        }
//
//
////        if(userDto.isClient()){
////            throw new RuntimeException("The userName: " + userName + " is not master");
////        }
////        MasterDto masterDto=masterService.getMaster(userDto.getUserName());
////        if(userMasterDto==null){
////            throw new RuntimeException("The userName: "+userName+" is wrong");
////        }
//
//        ModelMapper modelMapper=new ModelMapper();
//        UserMasterResponse  returnValue=  modelMapper.map(userMasterDto, UserMasterResponse.class);
//
//
//        return returnValue ;
//    }

//    @GetMapping(
//            path="/user/{userId}"
//            ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
//            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//    public UserMasterResponse getUserMasterByUserId(@PathVariable String userId){
//        if(userId.equals("") || userId.isEmpty() || userId==null){
//            throw new RuntimeException("User id is wrong ");
//        }
//        UserMasterDto userMasterDto = userService.getUserMasterByUserId(userId);
//
//        if(userMasterDto==null){
//            throw new RuntimeException("User with user id: "+userId +" is not found");
//        }
//
//
////        if(userDto.isClient()){
////            throw new RuntimeException("The userName: " + userName + " is not master");
////        }
////        MasterDto masterDto=masterService.getMaster(userDto.getUserName());
////        if(userMasterDto==null){
////            throw new RuntimeException("The userName: "+userName+" is wrong");
////        }
//
//        ModelMapper modelMapper=new ModelMapper();
//        UserMasterResponse  returnValue=  modelMapper.map(userMasterDto, UserMasterResponse.class);
//        Link masterLink=linkTo(MasterController.class)
//                .slash(returnValue.getMaster().getId()).slash("master").withSelfRel();
//         returnValue.add(masterLink);
//        return returnValue ;
//    }

    @GetMapping(path = "/{masterId}/master"
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public MasterResponse getMasterResponse(@PathVariable Long masterId){
        MasterDto master = masterService.getMasterByMasterId(masterId);
        Set<SpecializationResponse> specializationResponses=new HashSet<>();
        ModelMapper modelMapper=new ModelMapper();
        for(SpecializationDto specializationDto : master.getSpecializations() ){

            Link specializationLink=linkTo(SpecializationController.class)
                    .slash(specializationDto.getId()).withSelfRel();
            SpecializationResponse specializationResponse = modelMapper.map(specializationDto, SpecializationResponse.class);
            specializationResponse.add(specializationLink);
            specializationResponses.add(specializationResponse);

        }

        MasterResponse returnValue = modelMapper.map(master, MasterResponse.class);
        returnValue.setSpecializations(specializationResponses);
        return returnValue;
    }


//    @GetMapping(path = "/{masterId}"
//            ,produces = {MediaType.APPLICATION_JSON_VALUE
//            ,MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
//    public MasterResponse getMasterById(@PathVariable Long masterId){
//
//        UserMasterDto userMaster = userService.getUserMasterByMasterId(masterId);
//        MasterDto master = userMaster.getMaster();
//        if(master==null){
//            throw new RuntimeException("Master not found");
//        }
//        if(userMaster==null){
//            throw new RuntimeException("User for master: "
//                    + userMaster.getMaster().getFirstName()
//                    +" " +userMaster.getMaster().getLastName()+" not found");
//        }
//
//
//        ModelMapper modelMapper=new ModelMapper();
//
//        MasterResponse returnValue = modelMapper.map(master, MasterResponse.class);
//        Link link=linkTo(MasterController.class).slash(masterId).withSelfRel();
//        Link userLink=linkTo(UserMasterController.class).slash(userMaster.getUserId()).withRel("user");
//        returnValue.add(link,userLink);
//
//        return returnValue;
//    }
}
