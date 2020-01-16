package com.salon.controllers;

import com.salon.dto.SpecializationDto;
import com.salon.dto.UserDto;
import com.salon.services.SpecializationService;
import com.salon.services.UserService;
import com.salon.ui.model.response.SpecializationResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/specializations")
public class SpecializationController {


    private UserService userService;
    private SpecializationService specializationService;

    public SpecializationController(UserService userService, SpecializationService specializationService) {
        this.userService = userService;
        this.specializationService = specializationService;
    }

    @GetMapping(
            path="/userid/{userId}"
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Set<SpecializationResponse> getSpecializationByUserId(@PathVariable String userId){

        if(userId.equals("") || userId.isEmpty() || userId==null){
            throw new RuntimeException("User id is wronge ");
        }

        Set<SpecializationDto> specializations = specializationService.getSpecializationMasterByUserId(userId);

        if(specializations==null || specializations.isEmpty()){
            throw new RuntimeException("Specializations is not found");
        }


        ModelMapper modelMapper=new ModelMapper();
        Type listType=new TypeToken<Set<SpecializationResponse>>() {}.getType();
        Set<SpecializationResponse>returnValue= modelMapper.map(specializations, listType);

        return returnValue ;
    }

    @GetMapping(
            path="/username/{userName}"
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Set<SpecializationResponse> getSpecializationByUserName(@PathVariable String userName){

        if(userName.equals("") || userName.isEmpty() || userName==null){
            throw new RuntimeException("User name: " +userName +" is wronge ");
        }

        Set<SpecializationDto> specializations = specializationService.getSpecializationMasterByUserName(userName);

        if(specializations==null || specializations.isEmpty()){
            throw new RuntimeException("Specializations for user name: "+ userName+ " is not found");
        }


        ModelMapper modelMapper=new ModelMapper();
        Type listType=new TypeToken<Set<SpecializationResponse>>() {}.getType();
        Set<SpecializationResponse>returnValue= modelMapper.map(specializations, listType);

        return returnValue ;
    }
}
