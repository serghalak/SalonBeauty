package com.salon.controllers;

//import com.salon.service.UserService;
//import com.salon.shared.dto.UserDto;
//import com.salon.ui.model.request.UserRequest;
//import com.salon.ui.model.response.UserResponse;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import com.salon.dto.UserDto;
import com.salon.exceptions.OperationStatusModel;
import com.salon.ui.model.request.RequestOperationName;
import com.salon.exceptions.UserServiceException;
import com.salon.services.UserService;
import com.salon.ui.model.request.RequestOperationStatus;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.UserResponse;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.CollectionModel;

@RestController
@RequestMapping("api/users")
public class UserController {

    //@Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(
//            produces = {MediaType.APPLICATION_JSON_VALUE
//                    ,MediaType.APPLICATION_XML_VALUE})
//    public List<UserResponse> getAllListUsers(){
//
//        List<UserResponse>userResponseList=new ArrayList<>();
//        List<UserDto> listUsers = userService.getListUsers();
//        if(listUsers.isEmpty() || listUsers==null){
//            //throw new RuntimeException("List of users is empty");
//
//            String  message=messageSource.getMessage("user.userlistempty"
//                    ,null, LocaleContextHolder.getLocale());
//            throw new UserServiceException(message);
//        }
//        for (UserDto userDto:listUsers){
//            UserResponse userResponse=new UserResponse();
//            BeanUtils.copyProperties(userDto,userResponse);
//            userResponseList.add(userResponse);
//        }
//        return userResponseList;
//        //return "get some user !!!...";
//    }

    //get users with query string /users?page=1&limit=10
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE
            ,MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public /*List<UserResponse>*/CollectionModel<UserResponse>getUsers(
            @RequestParam(value = "page",defaultValue = "0")Integer page
            ,@RequestParam(value = "limit" , defaultValue = "10")Integer limit){


        List<UserResponse>returnValue=new ArrayList<>();

        List<UserDto>userResponses=userService.getUsers(page,limit);

        if(userResponses.isEmpty() || userResponses==null){
            String  message=messageSource.getMessage("user.userlistempty"
                    ,null, LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }

        Link userLink=null;

        for (UserDto userDto : userResponses){
            UserResponse userResponse=new UserResponse();
            BeanUtils.copyProperties(userDto,userResponse);

            //for link uses hateoas
            userLink=linkTo(UserController.class).slash(userResponse.getUserId()).withSelfRel();
            //userLink=linkTo(methodOn(UserController.class).getUsersAuthentication()).slash(userResponse.getUserId()).withSelfRel();
            userResponse.add(userLink);

            returnValue.add(userResponse);
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
    public UserResponse getUserByUserId(@PathVariable("userId")String userId){
        UserDto userDb=userService.getUserByUserId(userId);
        if(userDb==null){
            String message=messageSource.getMessage(
                    "user.usernotfound",null,LocaleContextHolder.getLocale());
            throw new UsernameNotFoundException(message);
        }
        UserResponse userResponse=new UserResponse();
        BeanUtils.copyProperties(userDb,userResponse);
        return userResponse;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public UserResponse createUser(
            @RequestBody UserRequest userRequest){

        if(userRequest==null){
            String message=messageSource.getMessage(
                    "user.usernotset",null
                    ,LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }
        if(userRequest.getLastName()==null
                || userRequest.getLastName().equals("")){
            String message=messageSource.getMessage(
                    "registration.user.lastnameisempty",null
                    ,LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }

        if(userRequest.getUserName().equals("")
                || userRequest.getFirstName().equals("")
                || userRequest.getEmail().equals("")
                || userRequest.getPhoneNumber().equals("")
                || userRequest.getPassword().equals("")
                || userRequest.getLastName().equals("")){
            String message=messageSource.getMessage(
                    "registration.user.requiredfields",null
                    ,LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }


        UserResponse userResponse=new UserResponse();

        //replace these two lines on the ModelMapper
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);



//        ModelMapper modelMapper=new ModelMapper();
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
//
//        UserDto userDto=modelMapper.map(userRequest,UserDto.class);


        //System.out.println("-------------------------------");
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

    @PutMapping(
            /*path = "/{id}",*/
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public UserResponse  updateUser(
            @RequestBody UserRequest userRequest
            /*,@PathVariable("id")String id*/){

        if(userRequest==null){
            //throw new RuntimeException("User for update is wrong");
            String message=messageSource.getMessage("user.usernotset"
                    ,null,LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);
        UserDto userUpdated= userService.updateUser(userDto);
        if(userUpdated==null){
            //throw new RuntimeException("Error during updating");
            String[] params=new String[]{userRequest.getUserName()};
            String message=messageSource.getMessage("user.usernotupdate"
                    ,params,LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }
        UserResponse userReturn=new UserResponse();
        BeanUtils.copyProperties(userUpdated,userReturn);
        return userReturn;
        //return "put update some user ...";
    }

    @DeleteMapping(
            path = "/{id}"
            /*,consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}*/
            ,produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public OperationStatusModel deleteUser(
            @PathVariable("id")String id
            ,@RequestBody UserRequest user){
        if(user==null){
            String message=messageSource.getMessage("usernotfound",null,
                    LocaleContextHolder.getLocale()  );
            throw new UsernameNotFoundException(message);
        }


        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        userService.deleteUser(userDto);
        //userService.getUserByUserId(id);

        //userService.getUserByUserId(id);
        OperationStatusModel operationStatusModel=new OperationStatusModel();
        operationStatusModel.setOperationName(RequestOperationName.DELETE.name());
        operationStatusModel.setOperationResult(RequestOperationStatus.SUCCES.name());

        //return "delete delete some user ...";

        return operationStatusModel;
    }


    @GetMapping("/activate/{code}")
    public UserResponse activate(@PathVariable("code")String code){
        UserResponse userResponse=new UserResponse();
        if(code==null){
            //throw new RuntimeException("code activation is wrong");
            String message=messageSource.getMessage(
                    "registration.user.activationcodewrong"
                    ,null,LocaleContextHolder.getLocale());
            throw new UserServiceException(message);
        }

        UserDto userByCodeActivate = userService.getUserByCodeActivate(code);
        BeanUtils.copyProperties(userByCodeActivate,userResponse);

        return userResponse;
    }




    @PutMapping("/put")
    public String testPut(){
        return "from /put";
    }
}
