package com.salon.services;

import com.salon.dto.SpecializationDto;
import com.salon.dto.UserClientDto;
import com.salon.dto.UserClientDto;
import com.salon.dto.UserMasterDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;


//import com.salon.dto.UserDto;


public interface UserService extends UserDetailsService {


    Set<UserClientDto> getUserClients(Integer page, Integer limit);
    UserClientDto getUserClientByUserId(String userId);
    //-----------------------------------------------------
    UserClientDto createUser(UserClientDto user);
    UserClientDto getUser(String userName);

//    UserDto getUserByUserName(String userName);
    List<UserClientDto> getListUsers();
    UserClientDto updateUser(UserClientDto user);
    UserClientDto getUserByCodeActivate(String code);

    void deleteUser(UserClientDto user);
    void deleteUserByUserId(String userId);




    UserMasterDto createUserMaster(UserMasterDto userMasterDto);
    UserMasterDto getUserMasterByUserName(String userName);
    UserMasterDto getUserMasterByUserId(String userId);

    Set<SpecializationDto> getSpecializations(String userName);
}
