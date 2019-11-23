package com.salon.controllers;

//import com.salon.service.UserService;
//import com.salon.shared.dto.UserDto;
//import com.salon.ui.model.request.UserRequest;
//import com.salon.ui.model.response.UserResponse;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

//    @Autowired
//    private UserService userService;

    @GetMapping
    public /*List<UserResponse>*/String getAllListUsers(){

//        List<UserResponse>userResponseList=new ArrayList<>();
//        List<UserDto> listUsers = userService.getListUsers();
//        if(listUsers.isEmpty() || listUsers==null){
//            throw new RuntimeException("List of users is empty");
//        }
//        for (UserDto userDto:listUsers){
//            UserResponse userResponse=new UserResponse();
//            BeanUtils.copyProperties(userDto,userResponse);
//            userResponseList.add(userResponse);
//        }
//        return userResponseList;
        return "get some user !!!...";
    }

    @PostMapping
    public /*UserResponse*/String createUser(
            /*@RequestBody UserRequest userRequest*/){
//        UserResponse userResponse=new UserResponse();
//        UserDto userDto = new UserDto();
//        BeanUtils.copyProperties(userRequest,userDto);
//
//        UserDto createdUser=userService.createUser(userDto);
//
//        BeanUtils.copyProperties(createdUser,userResponse);
//
//        return userResponse;
        return "post some user !!!...";
    }

    @PutMapping
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

    @DeleteMapping
    public /*void*/String deleteUser(/*@RequestBody UserRequest user*/){
//        if(user==null){
//            throw new RuntimeException("user is wronge");
//        }
//        UserDto userDto=new UserDto();
//        BeanUtils.copyProperties(user,userDto);
//        userService.deleteUser(userDto);
        return "delete delete some user ...";
    }
}
