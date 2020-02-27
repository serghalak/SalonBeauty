package com.salon.services.impl;

import com.salon.common.MailSender;
import com.salon.domain.Authority;
import com.salon.domain.Person;
import com.salon.domain.User;
import com.salon.dto.UserDto;
import com.salon.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepo userRepo;
    @Mock
    MessageSource messageSource;
    @Mock
    ModelMapper modelMapper;
    @Mock
    MailSender mailSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void activateUser() {
        User userByCodeActivate=new User();
        userByCodeActivate.setId(1L);
        userByCodeActivate.setActivateCode("123456");
        userByCodeActivate.setActive(false);
        userByCodeActivate.setPassword("123");
        userByCodeActivate.setUserName("serg");
        userByCodeActivate.setUserId("123f");

        Authority authority=new Authority();
        authority.setId(1L);
        authority.setRoleName("USER");

        Person person=new Person();

        userByCodeActivate.setPerson(person);
        userByCodeActivate.setAuthority(authority);

        when(userRepo.findByActivateCode(anyString())).thenReturn(userByCodeActivate);

        userByCodeActivate.setActive(true);
        userByCodeActivate.setActivateCode("");
        when(userRepo.save(userByCodeActivate)).thenReturn(userByCodeActivate);
        ModelMapper mapper=new ModelMapper();
        UserDto userDto = mapper.map(userByCodeActivate, UserDto.class);
        when(modelMapper.map(userByCodeActivate,UserDto.class)).thenReturn(userDto);

        UserDto returnValue = userService.activateUser("returnValue");
        assertEquals("",userByCodeActivate.getActivateCode());
        assertEquals(true,userByCodeActivate.isActive());
        assertNotNull(returnValue);
        assertEquals(1L,returnValue.getId());
        assertEquals("123f",returnValue.getUserId());
        assertEquals("serg",returnValue.getUserName());
        assertEquals("123",returnValue.getPassword());
        assertEquals("",returnValue.getActivateCode());
        assertEquals(true,returnValue.getActive());
        assertEquals(1L,returnValue.getAuthority().getId());
        assertEquals("USER",returnValue.getAuthority().getRoleName());
    }


    @Test()
    void activateUser_UserNotFound() {
        when(userRepo.findByActivateCode(anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class,
                ()->{
                    userService.activateUser("returnValue");
                });
    }
}