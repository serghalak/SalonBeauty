package com.salon.services.impl;

import com.salon.common.MailSender;
//import com.salon.common.RegistrationLink;
import com.salon.common.Utils;
import com.salon.domain.Authority;
import com.salon.domain.Client;
import com.salon.domain.Person;
import com.salon.domain.User;
import com.salon.dto.*;
import com.salon.repository.AuthorityRepo;
import com.salon.repository.ClientRepo;
import com.salon.repository.UserRepo;
import com.salon.services.UserClientService;
import org.modelmapper.ModelMapper;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserClientServiceImpl /*extends UserServiceImpl*/   implements UserClientService {

    private ClientRepo clientRepo;
    private AuthorityRepo authorityRepo;
    //private RegistrationLink registrationLink;
    private Utils utils;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MailSender mailSender;
    private UserRepo userRepo;
    private MessageSource messageSource;
    private ModelMapper modelMapper;


    public UserClientServiceImpl(ClientRepo clientRepo, AuthorityRepo authorityRepo
            /*,RegistrationLink registrationLink*/
            , Utils utils, BCryptPasswordEncoder bCryptPasswordEncoder
            , MailSender mailSender, UserRepo userRepo, MessageSource messageSource
            ,ModelMapper modelMapper  ) {
        this.clientRepo = clientRepo;
        this.authorityRepo=authorityRepo;
        //this.registrationLink = registrationLink;
        this.utils = utils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mailSender = mailSender;
        this.userRepo = userRepo;
        this.messageSource = messageSource;
        this.modelMapper=modelMapper;
    }

    @Override
    public Set<UserClientDto> findAll() {
        return null;
    }

    @Override
    public UserClientDto findById(Long aLong) {
        return null;
    }



    @Override
    public void delete(UserClientDto object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public UserClientDto update(UserClientDto object) {
        return null;
    }



    @Override
    public UserClientDto save(UserClientDto userClientDto) {
        if(userRepo.findByPerson_Email(userClientDto.getPerson().getEmail())!= null){
            String[] params=new String[]{userClientDto.getPerson().getEmail()};
            throw new RuntimeException(
                    messageSource.getMessage("registration.email.exists"
                            ,params,LocaleContextHolder.getLocale()));
        }

        User userByUserName = userRepo.findByUserName(userClientDto.getPerson().getUser().getUserName());
            if(userByUserName!= null ){
                String[] params=new String[]{userClientDto.getPerson().getUser().getUserName()};
                throw new RuntimeException(
                        messageSource.getMessage("registration.user.exists"
                                ,params
                                , LocaleContextHolder.getLocale()));
            }


        if(userRepo.findByPerson_PhoneNumber(userClientDto.getPerson().getPhoneNumber())!=null ){

            String[] params=new String[]{userClientDto.getPerson().getPhoneNumber()};
            throw new RuntimeException(
                    messageSource.getMessage("registration.phonenumber.exists"
                            ,params
                            , LocaleContextHolder.getLocale()));
        }

         //ModelMapper modelMapper=new ModelMapper();



         //Client client=modelMapper.map(userClientDto, Client.class);
        Client client = convertToClient(userClientDto);
        //userCreate.setPassword(user.getPassword());
        //user.getPerson().setClient(userClientDto.getClient());
//        Person personClient=new Person();
//        Client client = modelMapper.map(userClientDto.getClient(), Client.class);
//        personClient.setClient(client);
//        user.setPerson(personClient);

        client.getPerson().getUser().setPassword(bCryptPasswordEncoder.encode(userClientDto.getPerson().getUser().getPassword()));
         client.getPerson().getUser().setUserId(utils.generateUserId(30));
         //user.setUserName(utils.getRandomUserName());
//            Client client=new Client();
//            Authority authority=new Authority();
//            authority.setId(1L);
//            authority.setRoleName("USER");
//            userCreate.setAuthority(authority);


         client.getPerson().getUser().setActivateCode(UUID.randomUUID().toString());
        //modelMapper.map(user.getClient(),client);

          //userCreate.setClient(client);

         Client clientDb=clientRepo.save(client);

         mailSender.sendEmailActivation(clientDb.getPerson().getEmail()
                 ,clientDb.getPerson().getUser().getActivateCode()
                 ,client.getPerson().getFirstName());



          //  UserClientDto userReturn=new UserClientDto();
          //UserClientDto returnValue = modelMapper.map(clientDb, UserClientDto.class);
        UserClientDto returnValue = convertToDto(clientDb);

//        if(userDb==null){
//            throw new Exception("Cannot create user");
//        }

            //BeanUtils.copyProperties(userDb,userReturn);
            //if(user.isClient()){
            //BeanUtils.copyProperties(userDb.getClient(),userReturn);


            //}

            return returnValue;
    }



    private Client convertToClient(UserClientDto userClientDto) {

        PersonDto personDto = userClientDto.getPerson();
        UserDto userDto = personDto.getUser();
        AuthorityDto authorityDto = userDto.getAuthority();

        Authority authority = authorityRepo.findById(authorityDto.getId()).get();/*modelMapper.map(authorityDto, Authority.class);*/
        User user = modelMapper.map(userDto, User.class);


        Set<User> users = authority.getUsers();
        users.add(user);
        authority.setUsers(users);
        user.setAuthority(authority);

        Person person = modelMapper.map(personDto, Person.class);

        user.setPerson(person);
        person.setUser(user);

        Client client=new Client();
        client.setPerson(person);
        person.setClient(client);


        //Authority authority = authorityRepo.findById(userClientDto.getPerson().getUser().getAuthority().getId()).get();


        //Client client = modelMapper.map(userClientDto, Client.class);
//        client.getPerson().getUser().setAuthority(authority);
        //Set<User> users=authority.getUsers();
        //users.add(client.getPerson().getUser());
        //authority.setUsers(users);

        return client;
    }

    private UserClientDto convertToDto(Client client)  {
        UserClientDto userClientDto = modelMapper.map(client, UserClientDto.class);
        return userClientDto;
    }

//    private void sendEmail(Client clientDb){
//
//        if (clientDb.getPerson().getEmail() !=null){
//            String link= registrationLink.getAppHost()
//                    +registrationLink.getAppName()
//                    +registrationLink.getAppActivatePath()+clientDb.getPerson().getUser().getActivateCode();
//
//
//            String[] params=new String[]{clientDb.getPerson().getFirstName() ,link};
//            String messageLink=messageSource.getMessage("registration.user.emaillink"
//                    ,params,LocaleContextHolder.getLocale());
////                        String message=String.format("Hello, %s! \n"+
////                            "Welcome to Salon Beauty. Please, visit next link: http://localhost:8080/api/users/activate/%s",
////                                clientDb.getPerson().getFirstName(),
////                                clientDb.getPerson().getUser().getActivateCode());
//            String messageSubject=messageSource.getMessage("registration.user.activationcode"
//                    ,null,LocaleContextHolder.getLocale());
//            mailSender.send(clientDb.getPerson().getEmail(),messageSubject,messageLink);
//            //}
//        }
//
//    }


}
