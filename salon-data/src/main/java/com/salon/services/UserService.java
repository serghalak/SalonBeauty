package com.salon.services;

import com.salon.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


import com.salon.dto.UserDto;



public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    List<UserDto> getListUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(UserDto user);
}
