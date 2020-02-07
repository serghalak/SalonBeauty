package com.salon.services.impl;

import com.salon.common.MailSender;
import com.salon.common.RegistrationLink;
import com.salon.common.Utils;
import com.salon.domain.Authority;
import com.salon.domain.Client;
import com.salon.domain.User;
import com.salon.dto.*;
import com.salon.repository.ClientRepo;
import com.salon.repository.UserRepo;
import com.salon.services.UserClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

//@Service
public class UserClientServiceImpl /*extends UserServiceImpl*/   /*implements UserClientService*/ {


//    private ClientRepo clientRepo;
//    private RegistrationLink registrationLink;
//    private Utils utils;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private MailSender mailSender;
//
//    public UserClientServiceImpl(UserRepo userRepo, MessageSource messageSource
//            , BCryptPasswordEncoder bCryptPasswordEncoder, Utils utils
//            , RegistrationLink registrationLink, ClientRepo clientRepo
//            , RegistrationLink registrationLink1, Utils utils1
//            , BCryptPasswordEncoder bCryptPasswordEncoder1, MailSender mailSender) {
//        super(userRepo, messageSource, bCryptPasswordEncoder, utils, registrationLink);
//        this.clientRepo = clientRepo;
//        this.registrationLink = registrationLink1;
//        this.utils = utils1;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder1;
//        this.mailSender = mailSender;
//    }
//
//
//    @Override
//    public UserClientDto findById(Long aLong) {
//        return null;
//    }
//
//    //@Override
//    public UserClientDto save(UserClientDto user) {
//        if(userRepo.findByEmail(user.getClient().getEmail())!= null){
//            String[] params=new String[]{user.getClient().getEmail()};
//            throw new RuntimeException(
//                    messageSource.getMessage("registration.email.exists"
//                            ,params,LocaleContextHolder.getLocale()));
//        }
//
//        User userByUserName = userRepo.findUserByUserName(user.getUserName());
//            if(userByUserName!= null ){
//                String[] params=new String[]{user.getUserName()};
//                throw new RuntimeException(
//                        messageSource.getMessage("registration.user.exists"
//                                ,params
//                                , LocaleContextHolder.getLocale()));
//            }
//
//
//        if(userRepo.findUserByPhoneNumber(user.getClient().getPhoneNumber())!=null ){
//
//            String[] params=new String[]{user.getClient().getPhoneNumber()};
//            throw new RuntimeException(
//                    messageSource.getMessage("registration.phonenumber.exists"
//                            ,params
//                            , LocaleContextHolder.getLocale()));
//        }
//
//
//
//            ModelMapper modelMapper=new ModelMapper();
//            User userCreate=modelMapper.map(user, User.class);
//            //userCreate.setPassword(user.getPassword());
//            userCreate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//
//            userCreate.setUserId(utils.generateUserId(30));
//            //userCreate.setUserName(utils.getRandomUserName());
//            Client client=new Client();
//            Authority authority=new Authority();
//            authority.setId(1L);
//            authority.setRoleName("USER");
//            userCreate.setAuthority(authority);
//
//
//            userCreate.setActivateCode(UUID.randomUUID().toString());
//            modelMapper.map(user.getClient(),client);
//
//            userCreate.setClient(client);
//
//            User userDb=userRepo.save(userCreate);
//
//
//            if (userCreate.getClient().getEmail() !=null){
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
//                mailSender.send(userCreate.getClient().getEmail(),messageSubject,messageLink);
//                //}
//            }
//
//
//            UserClientDto userReturn=new UserClientDto();
//            //modelMapper.map(userDb,)
//
////        if(userDb==null){
////            throw new Exception("Cannot create user");
////        }
//
//            BeanUtils.copyProperties(userDb,userReturn);
//            //if(user.isClient()){
//            BeanUtils.copyProperties(userDb.getClient(),userReturn);
//
//
//            //}
//
//            return userReturn;
//    }


}
