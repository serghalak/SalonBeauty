package com.salon.services;

import com.salon.dto.SpecializationDto;
import com.salon.dto.UserDto;
import com.salon.dto.UserMasterDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;


import com.salon.dto.UserDto;



public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUser(String userName);
    UserDto getUserByUserId(String userId);
//    UserDto getUserByUserName(String userName);
    List<UserDto> getListUsers();
    UserDto updateUser(UserDto user);
    UserDto getUserByCodeActivate(String code);

    void deleteUser(UserDto user);
    void deleteUserByUserId(String userId);

    List<UserDto> getUsers(Integer page, Integer limit);


    UserMasterDto createUserMaster(UserMasterDto userMasterDto);
    UserMasterDto getUserMasterByUserName(String userName);
    UserMasterDto getUserMasterByUserId(String userId);

    Set<SpecializationDto> getSpecializations(String userName);
}
