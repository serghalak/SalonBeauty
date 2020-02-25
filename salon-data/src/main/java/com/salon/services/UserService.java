package com.salon.services;

import com.salon.domain.Client;
import com.salon.dto.*;
import com.salon.dto.UserClientDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;


//import com.salon.dto.UserDto;


public interface UserService extends UserDetailsService,CrudService<UserDto,Long> {

    UserDto getUser(String userName);
    Set<UserDto> getUserSet();
    UserDto getUserByUserId(String userId);
//    Set<UserClientDto> getUserClients(Integer page, Integer limit);
//
//    ClientDto getClientByClientId(Long clientId);
//    UserClientDto getUserClientByClientId(long clientId) ;
//    UserClientDto createUser(UserClientDto user);
//    UserClientDto getUser(String userName);

//    UserClientDto updateUser(UserClientDto user);
      UserDto getUserByCodeActivate(String code);
      //void deleteUser(UserClientDto user);
    //-----------------------------------------------------

//    UserMasterDto getUserMasterByMasterId(long masterId);
//    UserMasterDto createUserMaster(UserMasterDto userMasterDto);
//    UserMasterDto getUserMasterByUserName(String userName);
//    UserMasterDto getUserMasterByUserId(String userId);
//    Set<SpecializationDto> getSpecializations(String userName);

    //void deleteUserByUserId(String userId);
}
