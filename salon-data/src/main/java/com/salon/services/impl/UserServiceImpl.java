package com.salon.services.impl;


//import com.salon.common.Utils;
//import com.salon.domain.User;
//import com.salon.repository.impl.UserRepo;
//import com.salon.service.UserService;
//import com.salon.shared.dto.UserDto;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;

//@Service
public class UserServiceImpl /*implements UserService*/ {
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private Utils utils;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public UserDto createUser(UserDto user) {
//
//        if(userRepo.findUserByEmail(user.getEmail())!= null){
//            throw new RuntimeException("user with email: " + user.getEmail()
//                    +" is already exists. Change your email address");
//        }
//        if(userRepo.findUserByUserName(user.getUserName())!= null){
//            throw new RuntimeException("user with nick: " + user.getUserName()
//                    +" is already exists. Change your nickname address");
//        }
//        if(user.getPhoneNumber() != null && userRepo.findUserByPhoneNumber(user.getPhoneNumber())!=null ){
//            throw new RuntimeException("user with phone number: " + user.getPhoneNumber()
//                    +" is already exists. Change your phone number");
//        }
//
//        User userCreate=new User();
//        BeanUtils.copyProperties(user,userCreate);
//
//        userCreate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userCreate.setUserId(utils.generateUserId(30));
//        userCreate.setUserName(utils.getRandomUserName());
//
//        User userDb=userRepo.save(userCreate);
//        UserDto userReturn=new UserDto();
//
////        if(userDb==null){
////            throw new Exception("Cannot create user");
////        }
//
//        BeanUtils.copyProperties(userDb,userReturn);
//        return userReturn;
//    }
//
//    @Override
//    public UserDto getUser(String email) {
//        User userByEmail = userRepo.findUserByEmail(email);
//        if(userByEmail==null){
//            throw new UsernameNotFoundException("User with email: "+email+" not found");
//        }
//
//        //UserDetails userDetails = loadUserByUsername(email);
//        UserDto userDto=new UserDto();
//        BeanUtils.copyProperties(userByEmail,userDto);
//        return userDto;
//    }
//
//    @Override
//    public List<UserDto> getListUsers() {
//        Iterable<User> users = userRepo.findAll();
////        //System.out.println(new ArrayList<User>());
//        List<UserDto>returnListUsers=new ArrayList<>();
////
//        for (User user:users){
//            UserDto userDto=new UserDto();
//            //System.out.println(user);
//            BeanUtils.copyProperties(user,userDto);
//            returnListUsers.add(userDto);
//        }
//        return returnListUsers;
//  //      return null;
//    }
//
//    @Override
//    public UserDto updateUser(UserDto user) {
//        if(user == null){
//            throw new RuntimeException("user is null");
//        }
//
//
//        User userDb =userRepo.findUserByUserId(user.getUserId());
//        if(userDb == null){
//            throw new RuntimeException("User "+user.getUserName()+" not found in db");
//        }
//
//
//        userDb.setFirstName(user.getFirstName());
//        userDb.setLastName(user.getLastName());
//        userDb.setEmail(user.getEmail());
//        if(user.getPassword()==null
//                || user.getPassword().isEmpty()
//                || user.getPassword()==""
//                || user.getPassword().equals("")){
//
//        }else{
//            userDb.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        }
//        //BeanUtils.copyProperties(user,userDb);
//
//        User updatedUser = userRepo.save(userDb);
//        if(updatedUser==null){
//            throw new RuntimeException("User: " + user.getUserName()+" did not updated");
//        }
//        UserDto returnUserDto=new UserDto();
//        BeanUtils.copyProperties(updatedUser,returnUserDto);
//        return returnUserDto;
//
//        //return null;
//    }
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
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        User userByEmail = userRepo.findUserByEmail(email);
//        if(userByEmail==null){
//            throw new UsernameNotFoundException("User with email: "+email+" not found");
//        }
//        return new org.springframework.security.core.userdetails.User(
//         userByEmail.getEmail(),userByEmail.getPassword(),new ArrayList<>());
//        //return userByEmail;
//    }
}
