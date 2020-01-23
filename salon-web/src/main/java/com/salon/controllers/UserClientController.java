package com.salon.controllers;

import com.salon.dto.UserClientDto;
import com.salon.exceptions.UserServiceException;
import com.salon.services.UserService;
import com.salon.ui.model.response.UserClientResponse;
import com.salon.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("api/users/client")
public class UserClientController {

    private UserService userService;
    private MessageSource messageSource;

    public UserClientController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE
            ,MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public /*List<UserResponse>*/CollectionModel<UserClientResponse> getUserClients(
            @RequestParam(value = "page",defaultValue = "0")Integer page
            ,@RequestParam(value = "limit" , defaultValue = "10")Integer limit){

        Set<UserClientResponse> returnValue=new HashSet<>();
        Set<UserClientDto>userClientResponses=userService.getUserClients(page,limit);

        if(userClientResponses.isEmpty() || userClientResponses==null){
            String  message=messageSource.getMessage("user.userlistempty"
                    ,null, LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }

        Link userLink=null;
        ModelMapper modelMapper=new ModelMapper();
        for (UserClientDto userClientDto : userClientResponses){
            //UserResponse userResponse=new UserResponse();
            //BeanUtils.copyProperties(userDto,userResponse);
            UserClientResponse userClientResponse=modelMapper.map(userClientDto,UserClientResponse.class);
            //for link uses hateoas
            userLink=linkTo(UserClientController.class).slash(userClientResponse.getUserId()).withSelfRel();
            //userLink=linkTo(methodOn(UserController.class).getUsersAuthentication()).slash(userResponse.getUserId()).withSelfRel();
            userClientResponse.add(userLink);

            returnValue.add(userClientResponse);
        }

        //it's the same that previous loop but using ModelMapper library
//        java.lang.reflect.Type listType=new TypeToken<List<UserResponse>>() {}.getType();
//        ModelMapper modelMapper=new ModelMapper();
//        returnValue=modelMapper.map(userResponses,listType);

        //return returnValue;

        //for ne hateoas
        //ResourceSupport is now RepresentationModel
        //Resource<T> is now EntityModel<T>
        //Resources<T> is now CollectionModel<T>
        //PagedResources<T> is now PagedModel<T>
        return new CollectionModel<>(returnValue);
    }

    @GetMapping(value = "/{userId}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public UserClientResponse getUserClientByUserId(@PathVariable("userId")String userId){
        UserClientDto userDb=userService.getUserClientByUserId(userId);
        if(userDb==null){
            String message=messageSource.getMessage(
                    "user.usernotfound",null,LocaleContextHolder.getLocale());
            throw new UsernameNotFoundException(message);
        }
//        if(userDb.getClient()==null){
//            throw new RuntimeException("user is not client");
//        }
        ModelMapper modelMapper=new ModelMapper();
        UserClientResponse userClientResponse = modelMapper.map(userDb, UserClientResponse.class);
        return userClientResponse;
    }

}
