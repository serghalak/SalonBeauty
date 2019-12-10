package com.salon.services.impl;


import com.salon.common.Utils;
import com.salon.domain.Authority;
import com.salon.domain.Client;
import com.salon.domain.User;
import com.salon.repository.UserRepo;
import com.salon.services.UserService;
import com.salon.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //@Autowired
    private UserRepo userRepo;
    //@Autowired
    private Utils utils;
    //@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepo userRepo, Utils utils
            , BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.utils = utils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto createUser(UserDto user) {

//        if(userRepo.findUserByEmail(user.getEmail())!= null){
//            throw new RuntimeException("user with email: " + user.getEmail()
//                    +" is already exists. Change your email address");
//        }
        if(userRepo.findUserByUserName(user.getUserName())!= null){
            throw new RuntimeException("user with nick: " + user.getUserName()
                    +" is already exists. Change your nickname!!!");
        }
//        if(user.getPhoneNumber() != null && userRepo.findUserByPhoneNumber(user.getPhoneNumber())!=null ){
//            throw new RuntimeException("user with phone number: " + user.getPhoneNumber()
//                    +" is already exists. Change your phone number");
//        }

        User userCreate=new User();
        BeanUtils.copyProperties(user,userCreate);
        //userCreate.setPassword(user.getPassword());
        userCreate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userCreate.setUserId(utils.generateUserId(30));
        //userCreate.setUserName(utils.getRandomUserName());
        Client client=null;
        Authority authority=null;
        if(user.isClient()){
            client=new Client();
            authority=new Authority();
            authority.setId(1L);
            authority.setRoleName("USER");
            userCreate.setAuthority(authority);
        }


        BeanUtils.copyProperties(user,client);
        userCreate.setClient(client);

        User userDb=userRepo.save(userCreate);
        UserDto userReturn=new UserDto();

//        if(userDb==null){
//            throw new Exception("Cannot create user");
//        }

        BeanUtils.copyProperties(userDb,userReturn);
        if(user.isClient()){
            BeanUtils.copyProperties(userDb.getClient(),userReturn);


        }

        return userReturn;
    }

    @Override
    public UserDto getUserByUserId(String userId) {

        User byUserId = userRepo.findByUserId(userId);
        if(byUserId==null){
            throw new RuntimeException("User with userId not found");
        }
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(byUserId,userDto);
        if(byUserId.getClient()!=null){
            BeanUtils.copyProperties(byUserId.getClient(),userDto);
        }else{
            BeanUtils.copyProperties(byUserId.getMaster(),userDto);
        }

        return userDto;

    }

    @Override
    public UserDto getUser(String userName) {
        User userByUserName = userRepo.findUserByUserName(userName);
        if(userByUserName==null){
            //throw new UsernameNotFoundException("User with email: "+userName+" not found");
            throw new RuntimeException("User with user name: "+userName+" not found");
        }

        //UserDetails userDetails = loadUserByUsername(email);
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userByUserName,userDto);
        return userDto;
    }

    @Override
    public List<UserDto> getListUsers() {
        Iterable<User> users = userRepo.findAll();
//        //System.out.println(new ArrayList<User>());
        List<UserDto>returnListUsers=new ArrayList<>();
//
        for (User user:users){
            UserDto userDto=new UserDto();
            //System.out.println(user);
            if(user.getClient()!=null){
                BeanUtils.copyProperties(user.getClient(),userDto);
            }else {
                BeanUtils.copyProperties(user.getMaster(),userDto);
            }
            BeanUtils.copyProperties(user,userDto);
            returnListUsers.add(userDto);
        }
        return returnListUsers;
  //      return null;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        if(user == null){
            throw new RuntimeException("user is null");
        }


        User userDb =userRepo.findUserByUserId(user.getUserId());
        if(userDb == null){
            throw new RuntimeException("User "+user.getUserName()+" not found in db");
        }


        if(user.isClient()){
            userDb.getClient().setFirstName(user.getFirstName());
            userDb.getClient().setLastName(user.getLastName());
            userDb.getClient().setEmail(user.getEmail());
            userDb.getClient().setPhoneNumber(user.getPhoneNumber());
        }else{
            userDb.getMaster().setFirstName(user.getFirstName());
            userDb.getMaster().setLastName(user.getLastName());
            userDb.getMaster().setEmail(user.getEmail());
            userDb.getMaster().setPhoneNumber(user.getPhoneNumber());
        }

        if(user.getPassword()==null
                || user.getPassword().isEmpty()
                || user.getPassword()==""
                || user.getPassword().equals("")){

        }else{
            userDb.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        //BeanUtils.copyProperties(user,userDb);
        userDb.setUserName(user.getUserName());
        User updatedUser = userRepo.save(userDb);
        if(updatedUser==null){
            throw new RuntimeException("User: " + user.getUserName()+" did not updated");
        }
        UserDto returnUserDto=new UserDto();
        BeanUtils.copyProperties(updatedUser,returnUserDto);

        if(user.getClient()!=null){
            BeanUtils.copyProperties(updatedUser.getClient(),returnUserDto);
        }else{
            BeanUtils.copyProperties(updatedUser.getMaster(),returnUserDto);
        }

        return returnUserDto;

        //return null;
    }
//
//    @Override
//    public void deleteUser( UserDto user) {
//        if(user==null){
//            throw new RuntimeException("user is empty");
//        }
//        User userDb=userRepo.findUserByUserId(user.getUserId());
//        if(userDb==null){
//            throw new RuntimeException("User: " + user.getUserName()+"is not exists");
//        }
//
//        //User userDb=new User();
//        //BeanUtils.copyProperties(user,userDb);
//
//        userRepo.delete(userDb);
//
//        //return null;
//    }
//
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User userByUserName = userRepo.findUserByUserName(userName);
        if(userByUserName==null){
            throw new UsernameNotFoundException("User with user name: "+userName+" not found");
        }

        return new org.springframework.security.core.userdetails.User(
         userByUserName.getUserName(),userByUserName.getPassword(),new ArrayList<>());
        //return userByEmail;
    }
}
