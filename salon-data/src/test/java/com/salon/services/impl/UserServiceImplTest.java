package com.salon.services.impl;

import com.salon.domain.Authority;
import com.salon.domain.Person;
import com.salon.domain.User;
import com.salon.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepo userRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserByCodeActivate() {
        User user=new User();
        user.setId(1L);
        user.setUserName("serg");
        user.setPassword("123");
        user.setPerson(new Person());
        user.setAuthority(new Authority());

        when(userRepo.findByActivateCode(anyString())).thenReturn(user);
        assertEquals(user.getUserName(),"serg");
    }

}