package com.salon.controllers;

import com.salon.dto.MasterDto;
import com.salon.dto.SpecializationDto;
import com.salon.dto.UserMasterDto;
import com.salon.services.MasterService;
import com.salon.services.UserService;
import com.salon.ui.model.response.MasterResponse;
import com.salon.ui.model.response.SpecializationResponse;
import com.salon.ui.model.response.UserMasterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/users/master")
public class UserMasterController {
    private UserService userService;
    private MessageSource messageSource;
    private MasterService masterService;

    public UserMasterController(UserService userService, MasterService masterService,MessageSource messageSource) {
        this.userService = userService;
        this.masterService=masterService;
        this.messageSource = messageSource;
    }

    @GetMapping(
            path="/username/{userName}"
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public EntityModel<UserMasterResponse> getUserMasterByUserName(@PathVariable String userName){

        if(userName.equals("") || userName.isEmpty() || userName==null){
            throw new RuntimeException("User name is wrong ");
        }
        UserMasterDto userMasterDto = userService.getUserMasterByUserName(userName);

        if(userMasterDto==null){
            throw new RuntimeException("User with user name: "+userName +" is not found");
        }

        UserMasterResponse returnValue = getUserMaster(userMasterDto);


        return new EntityModel<>(returnValue);


    }

    @GetMapping(
            path="/userid/{userId}"
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public EntityModel<UserMasterResponse> getUserMasterByUserId(@PathVariable String userId) {

        if (userId.equals("") || userId.isEmpty() || userId == null) {
            throw new RuntimeException("User id is wrong ");
        }
        UserMasterDto userMasterDto = userService.getUserMasterByUserId(userId);

        if (userMasterDto == null) {
            throw new RuntimeException("User with user id: " + userId + " is not found");
        }

        UserMasterResponse returnValue = getUserMaster(userMasterDto);
        return new EntityModel<>(returnValue);
    }

    private UserMasterResponse getUserMaster(UserMasterDto userMasterDto){

        Set<SpecializationResponse> specializationResponses=new HashSet<>();
        ModelMapper modelMapper=new ModelMapper();
        for(SpecializationDto specializationDto : userMasterDto.getMaster().getSpecializations() ){

            Link specializationLink=linkTo(
                    methodOn(SpecializationController.class)
                            .getSpecialization(specializationDto.getId())).withSelfRel();
                    //.slash(specializationDto.getId()).withSelfRel();
            SpecializationResponse specializationResponse = modelMapper.map(specializationDto, SpecializationResponse.class);
            specializationResponse.add(specializationLink);
            specializationResponses.add(specializationResponse);

        }

        MasterResponse masterResponse= modelMapper.map(userMasterDto.getMaster(), MasterResponse.class);
        masterResponse.setSpecializations(specializationResponses);
        Link masterLink=linkTo(methodOn(MasterController.class).getMasterResponse(masterResponse.getId()))
                .withRel("masterResponse");
        masterResponse.add(masterLink);
        UserMasterResponse returnValue = modelMapper.map(userMasterDto, UserMasterResponse.class);
        returnValue.setMaster(masterResponse);
        Link userMasterLink=linkTo(methodOn(UserMasterController.class).getUserMasterByUserName(returnValue.getUserName()))
                .withSelfRel();
        returnValue.add(userMasterLink);
        return returnValue;
    }

}






