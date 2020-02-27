package com.salon.services.impl;


import com.salon.common.MailSender;
import com.salon.common.RegistrationLink;
import com.salon.common.Utils;
import com.salon.domain.User;
import com.salon.dto.UserClientDto;
import com.salon.dto.UserDto;
import com.salon.repository.UserRepo;
import com.salon.services.CrudService;
import com.salon.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    protected UserRepo userRepo;
    protected MessageSource messageSource;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Utils utils;
    //private RegistrationLink registrationLink;
    private MailSender mailSender;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, MessageSource messageSource
            ,BCryptPasswordEncoder bCryptPasswordEncoder
            ,Utils utils, /*RegistrationLink registrationLink,*/ MailSender mailSender,ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.messageSource = messageSource;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.utils=utils;
        /*this.registrationLink=registrationLink;*/
        this.mailSender=mailSender;
        this.modelMapper=modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User userByUserName=getUserByUserName(userName);
        return new org.springframework.security.core.userdetails.User(
                userByUserName.getUserName(),userByUserName.getPassword(),new ArrayList<>());
    }

    @Override
    public UserDto getUser(String userName) {
//        User userByUserName=getUserByUserName(userName);
//
//        UserDto userDto=new UserDto();
//        ModelMapper modelMapper=new ModelMapper();
//        UserDto returnValue = modelMapper.map(userByUserName, UserDto.class);
//
//        return returnValue;
        return null;
    }

    @Override
    public Set<UserDto> getUserSet() {
        Iterable<User> users = userRepo.findAll();
        if(users==null){
            throw new RuntimeException("List of users is empty");
        }
        Set<UserDto>returnValue=new HashSet<>();
        java.lang.reflect.Type listType=new TypeToken<Set<UserDto>>() {}.getType();
        ModelMapper modelMapper=new ModelMapper();
        returnValue=modelMapper.map(users,listType);
        return returnValue;
        //return null;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
//        User userDb = userRepo.findUserByUserId(userId);
//        if(userDb==null){
//            throw new RuntimeException("User by userId not found");
//        }
//        return getUser(userDb.getUserName());
        return null;
    }

    @Override
    public UserDto activateUser(String activateCode) {
        User userByCodeActivate = getUserByCodeActivate(activateCode);
        User userActivated = saveChange(userByCodeActivate);
        sendLetter(userActivated.getPerson().getEmail());
        UserDto returnValue=convertToUserDto(userActivated);
        return returnValue;
    }


    private User saveChange(User userByActivateCode){
        userByActivateCode.setActivateCode("");
        userByActivateCode.setActive(true);
        User userActivated=userRepo.save(userByActivateCode);
        if(userActivated==null){
            String message = messageSource.getMessage(
                    "registration.user.activationerror"
                    ,null,LocaleContextHolder.getLocale());
            throw new UsernameNotFoundException(message);
        }
        return userActivated;
    }

    private void  sendLetter(String email){
        mailSender.sendEmailSuccessRegistation(email);
    }
    private User getUserByCodeActivate(String code) {
        User byActivateCode = userRepo.findByActivateCode(code);
        if(byActivateCode==null){
            String message = messageSource.getMessage(
                    "registration.user.activationcodewrong"
                    ,null,LocaleContextHolder.getLocale());
            throw new UsernameNotFoundException(message);

        }
        return byActivateCode;
    }

    @Override
    public Set<UserDto> findAll() {
//        Iterable<User> users = userRepo.findAll();
//        if(users==null ){
//            throw  new RuntimeException("Threre is no any user");
//        }
//        Set<UserDto> returnValue=new HashSet<>();
//        UserDto userDto=null;
//        ModelMapper modelMapper=new ModelMapper();
//        for (User user:users){
//            if(user.isActive()){
//                userDto=new UserDto();
////                if(user.getClient()!=null){
////                    BeanUtils.copyProperties(user.getClient(),userDto);
////                }else {
////                    BeanUtils.copyProperties(user.getMaster(),userDto);
////                }
//
//                //BeanUtils.copyProperties(user,userDto);
//                userDto = modelMapper.map(user, UserDto.class);
//                returnValue.add(userDto);
//            }
//
//        }
//        return returnValue;
        return null;
    }

    @Override
    public UserDto findById(Long id) {
//        User userDb = userRepo.findUserById(id);
//        if(userDb==null){
//            throw new RuntimeException("User by userId not found");
//        }
//        return getUser(userDb.getUserName());
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {
//        Boolean userIsClient=null;
//        if(userDto.getUserIsClient()){
//            userIsClient=true;
//        }else {
//            userIsClient=false;
//        }
//
//        if(userRepo.findUserByEmail(userDto.getUser().getEmail())!= null){
//            String[] params=new String[]{userDto.getUser().getEmail()};
//            throw new RuntimeException(
//                    messageSource.getMessage("registration.email.exists"
//                            ,params,LocaleContextHolder.getLocale()));
//        }
//
//        if(userRepo.findUserByUserName(userDto.getUserName())!= null ){
//            String[] params=new String[]{userDto.getUserName()};
//            throw new RuntimeException(
//                    messageSource.getMessage("registration.user.exists"
//                            ,params
//                            , LocaleContextHolder.getLocale()));
//        }
//
//        if(userRepo.findUserByPhoneNumber(userDto.getUser().getPhoneNumber())!=null ){
//            String[] params=new String[]{userDto.getUser().getPhoneNumber()};
//            throw new RuntimeException(
//                    messageSource.getMessage("registration.phonenumber.exists"
//                            ,params
//                            , LocaleContextHolder.getLocale()));
//        }
//
//        ModelMapper modelMapper=new ModelMapper();
//        User userCreate=modelMapper.map(userDto, User.class);
//        userCreate.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        userCreate.setUserId(utils.generateUserId(30));
//
////        //userCreate.setUserName(utils.getRandomUserName());
////        Client client=null;
////        Authority authority=null;
////        //if(user.isClient()){
////            client=new Client();
////            authority=new Authority();
////            authority.setId(1L);
////            authority.setRoleName("USER");
////            userCreate.setAuthority(authority);
////        //}
//
//
//        userCreate.setActivateCode(UUID.randomUUID().toString());
//
////        BeanUtils.copyProperties(user,client);
////        userCreate.setClient(client);
//
//        User userDb=userRepo.save(userCreate);
//
//        //if email is exist
//        //if(user.isClient()){
////        if(userIsClient){
////            userCreate.getClient().getEmail()
////        }
//        //if (userCreate..getUser().getEmail() !=null){
//                String link= registrationLink.getAppHost()
//                        +registrationLink.getAppName()
//                        +registrationLink.getAppActivatePath()+userDb.getActivateCode();
//
//
//                String[] params=new String[]{userDb.getClient().getFirstName() ,link};
//                String messageLink=messageSource.getMessage("registration.user.emaillink"
//                        ,params,LocaleContextHolder.getLocale());
////                String message=String.format("Hello, %s! \n"+
////                    "Welcome to Salon Beauty. Please, visit next link: http://localhost:8080/api/users/activate/%s",
////                        userDb.getClient().getFirstName(),
////                        userDb.getActivateCode());
//                String messageSubject=messageSource.getMessage("registration.user.activationcode"
//                        ,null,LocaleContextHolder.getLocale());
//                mailSender.send(userDto.getUser().getEmail(),messageSubject,messageLink);
//            //}
//        //}
//
//
//        UserDto returnValue=new UserDto();
//        //modelMapper.map(userDb,)
//
////        if(userDb==null){
////            throw new Exception("Cannot create user");
////        }
//
//        //BeanUtils.copyProperties(userDb,userReturn);
//        //if(user.isClient()){
////            BeanUtils.copyProperties(userDb.getClient(),userReturn);
//
//
//        //}
//        modelMapper.map(userCreate,UserDto.class);
//        return returnValue;

        return null;
    }

    @Override
    public void delete(UserDto userDto) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public UserDto update(UserDto object) {
        return null;
    }


    private User getUserByUserName(String userName){
//        User userByUserName = userRepo.findUserByUserName(userName);
//        if(userByUserName==null){
//            String[] params=new String[]{userName};
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,params,LocaleContextHolder.getLocale());
//
//            throw new RuntimeException(message);
//        }
//
//        if(!userByUserName.isActive()){
//            String[] params=new String[]{userName};
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,params,LocaleContextHolder.getLocale());
//
//            throw new RuntimeException(message);
//        }
//        return userByUserName;
        return null;
    }

    private User convertToUser(UserDto userDto){
        return modelMapper.map(userDto,User.class);
    }

    private UserDto convertToUserDto(User user){
        return modelMapper.map(user,UserDto.class);
    }
}
