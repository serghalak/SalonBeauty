package com.salon.services.impl;


import com.salon.common.MailSender;
import com.salon.common.RegistrationLink;
import com.salon.common.Utils;
import com.salon.domain.*;
import com.salon.dto.*;
import com.salon.exceptions.UserServiceException;
import com.salon.repository.ClientRepo;
import com.salon.repository.MasterRepo;
import com.salon.repository.UserRepo;
import com.salon.services.UserService;
import com.salon.dto.UserClientDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.*;

//@Service
public class UserServiceImplKop /*implements UserService*/ {

    @Autowired
    private RegistrationLink registrationLink;


//    //@Autowired
      protected UserRepo userRepo;
//    private ClientRepo clientRepo;
//    private MasterRepo masterRepo;
    @Autowired
    private Utils utils;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private MailSender mailSender;
//
//    @Autowired
    protected MessageSource messageSource;

    public UserServiceImplKop(UserRepo userRepo, MessageSource messageSource) {
        this.userRepo = userRepo;
        this.messageSource = messageSource;
    }

    //    public UserServiceImpl(UserRepo userRepo,ClientRepo clientRepo, MasterRepo masterRepo,Utils utils
//            , BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepo = userRepo;
//        this.clientRepo=clientRepo;
//        this.masterRepo=masterRepo;
//        this.utils = utils;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

//    @Override
//    public UserClientDto createUser(UserClientDto user) {
//
////        if(userRepo.findUserByEmail(user.getEmail())!= null){
////            throw new RuntimeException("user with email: " + user.getEmail()
////                    +" is already exists. Change your email address");
////        }
//
//        User userByUserName = userRepo.findUserByUserName(user.getUserName());
//        if(userByUserName!= null ){
////            throw new RuntimeException("user with nick: " + user.getUserName()
////                    +" is already exists. Change your nickname!!!");
//            String[] params=new String[]{user.getUserName()};
//
//            throw new RuntimeException(
//                    messageSource.getMessage("registration.user.exists"
//                            ,params
//                            , LocaleContextHolder.getLocale()));
//        }
//
//
////        if(user.getPhoneNumber() != null && userRepo.findUserByPhoneNumber(user.getPhoneNumber())!=null ){
////            throw new RuntimeException("user with phone number: " + user.getPhoneNumber()
////                    +" is already exists. Change your phone number");
////        }
//
//
//        //BeanUtils.copyProperties(user,userCreate);
//        ModelMapper modelMapper=new ModelMapper();
//        User userCreate=modelMapper.map(user, User.class);
//        //userCreate.setPassword(user.getPassword());
//        userCreate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//
//        userCreate.setUserId(utils.generateUserId(30));
//        //userCreate.setUserName(utils.getRandomUserName());
//        Client client=null;
//        Authority authority=null;
//        //if(user.isClient()){
//            client=new Client();
//            authority=new Authority();
//            authority.setId(1L);
//            authority.setRoleName("USER");
//            userCreate.setAuthority(authority);
//        //}
//
//
//        userCreate.setActivateCode(UUID.randomUUID().toString());
//
//        BeanUtils.copyProperties(user,client);
//        userCreate.setClient(client);
//
//        User userDb=userRepo.save(userCreate);
//
//        //if email is exist
//        //if(user.isClient()){
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
//            //}
//        }
//
//
//        UserClientDto userReturn=new UserClientDto();
//        //modelMapper.map(userDb,)
//
////        if(userDb==null){
////            throw new Exception("Cannot create user");
////        }
//
//        BeanUtils.copyProperties(userDb,userReturn);
//        //if(user.isClient()){
//            BeanUtils.copyProperties(userDb.getClient(),userReturn);
//
//
//        //}
//
//        return userReturn;
//    }

    //@Override
//   public UserClientDto getUserClientByUserId(String userId) {
//
//        User byUserId = userRepo.findByUserId(userId);
//        if(byUserId==null ){
//
//            String message=messageSource.getMessage("user.usernotfound"
//                    ,null,LocaleContextHolder.getLocale());
//            throw new UserServiceException(message);
//        }
//        if(!byUserId.isActive()){
//            String message=messageSource.getMessage("user.usernotfound"
//                    ,null,LocaleContextHolder.getLocale());
//            throw new UserServiceException(message);
//        }
//        if(byUserId.getClient()==null){
//            throw new RuntimeException("User is not client");
//        }
//
//        //UserDto userDto=new UserDto();
//
//        ModelMapper modelMapper=new ModelMapper();
//        UserClientDto userClientDto = modelMapper.map(byUserId, UserClientDto.class);
////        if(byUserId.getMaster()!=null && byUserId.getClient()==null){
////            //userDto.setClient(false);
////            throw new RuntimeException("User is not master");
////        }
//
//        //BeanUtils.copyProperties(byUserId,userDto);
////        if(byUserId.getClient()!=null){
////            BeanUtils.copyProperties(byUserId.getClient(),userDto);
////        }else{
////            BeanUtils.copyProperties(byUserId.getMaster(),userDto);
////        }
//
//        return userClientDto;
//
//    }



//    //@Override
//    public List<UserClientDto> getListUsers() {
//        Iterable<User> users = userRepo.findAll();
////        //System.out.println(new ArrayList<User>());
//        List<UserClientDto>returnListUsers=new ArrayList<>();
////
//        for (User user:users){
//            if(user.isActive()){
//                UserClientDto userDto=new UserClientDto();
//                if(user.getClient()!=null){
//                    BeanUtils.copyProperties(user.getClient(),userDto);
//                }else {
//                    BeanUtils.copyProperties(user.getMaster(),userDto);
//                }
//                BeanUtils.copyProperties(user,userDto);
//                returnListUsers.add(userDto);
//            }
//
//        }
//        return returnListUsers;
//    }
//
//    //@Override
//    public Set<UserClientDto> getUserClients(Integer page, Integer limit) {
//        Set<UserClientDto>returnValue=new HashSet<>();
//        Pageable pageableRequest= PageRequest.of(page,limit);
//
//        Page<User>usersPage = userRepo.findByActive(true, pageableRequest);
//        List<User> users = usersPage.getContent() ;
//
//        ModelMapper modelMapper=new ModelMapper();
//        for (User user:users  ) {
//            if(user.getClient()==null){
//                continue;
//            }
//            UserClientDto userClientDto = modelMapper.map(user, UserClientDto.class);
//            returnValue.add(userClientDto);
//        }
//        return returnValue;
//    }
//
//    //@Override
//    public UserMasterDto createUserMaster(UserMasterDto userMasterDto) {
//
//
//////        if(userRepo.findUserByEmail(user.getEmail())!= null){
//////            throw new RuntimeException("user with email: " + user.getEmail()
//////                    +" is already exists. Change your email address");
//////        }
////
////        User userByUserName = userRepo.findUserByUserName(userMasterDto.getUserName());
////        if(userByUserName!= null ){
//////            throw new RuntimeException("user with nick: " + user.getUserName()
//////                    +" is already exists. Change your nickname!!!");
////            String[] params=new String[]{user.getUserName()};
////
////            throw new RuntimeException(
////                    messageSource.getMessage("registration.user.exists"
////                            ,params
////                            , LocaleContextHolder.getLocale()));
////        }
////
////
//////        if(user.getPhoneNumber() != null && userRepo.findUserByPhoneNumber(user.getPhoneNumber())!=null ){
//////            throw new RuntimeException("user with phone number: " + user.getPhoneNumber()
//////                    +" is already exists. Change your phone number");
//////        }
//
//
//        //User userCreate=new User();
//
////        BeanUtils.copyProperties(user,userCreate);
////        //userCreate.setPassword(user.getPassword());
//
//        ModelMapper modelMapper=new ModelMapper();
//        User user = modelMapper.map(userMasterDto, User.class);
//        user.setPassword(bCryptPasswordEncoder.encode(userMasterDto.getPassword()));
////
//        user.setUserId(utils.generateUserId(30));
//        //user.setUserName(utils.getRandomUserName());
//        //user.setUserName(userMasterDto.getUserName());
//        //Client client=null;
//        //Master master=new MasterServiceImpl()
//        Authority authority=null;
//        if(!userMasterDto.getUserIsClient()){
//            //client=new Client();
//            user.setClient(null);
//            authority=new Authority();
//            authority.setId(2L);
//            authority.setRoleName("MASTER");
//            user.setAuthority(authority);
//
//            Master master=modelMapper.map(userMasterDto.getMaster(),Master.class);
//            user.setMaster(master);
//
//        }
//        User savedUser = userRepo.save(user);
//        UserMasterDto userMasterReturn = modelMapper.map(savedUser, UserMasterDto.class);
//        return userMasterReturn;
//
//
////
////
////        userCreate.setActivateCode(UUID.randomUUID().toString());
////
////        BeanUtils.copyProperties(user,client);
////        userCreate.setClient(client);
////
////        User userDb=userRepo.save(userCreate);
////
////        //if email is exist
////        if(userMasterDto.isClient()){
////            if (userCreate.getClient().getEmail() !=null){
////                String link= registrationLink.getAppHost()
////                        +registrationLink.getAppName()
////                        +registrationLink.getAppActivatePath()+userDb.getActivateCode();
////
////
////                String[] params=new String[]{userDb.getClient().getFirstName() ,link};
////                String messageLink=messageSource.getMessage("registration.user.emaillink"
////                        ,params,LocaleContextHolder.getLocale());
//////                String message=String.format("Hello, %s! \n"+
//////                    "Welcome to Salon Beauty. Please, visit next link: http://localhost:8080/api/users/activate/%s",
//////                        userDb.getClient().getFirstName(),
//////                        userDb.getActivateCode());
////                String messageSubject=messageSource.getMessage("registration.user.activationcode"
////                        ,null,LocaleContextHolder.getLocale());
////                mailSender.send(userCreate.getClient().getEmail(),messageSubject,messageLink);
////            }
////        }
////
////
////        UserDto userReturn=new UserDto();
////
//////        if(userDb==null){
//////            throw new Exception("Cannot create user");
//////        }
////
////        BeanUtils.copyProperties(userDb,userReturn);
////        if(userMasterDto.isClient()){
////            BeanUtils.copyProperties(userDb.getClient(),userReturn);
////
////
////        }
//
//       // return userReturn;
//
//      // return null;
//    }
//
//    //@Override
//    public UserMasterDto getUserMasterByUserName(String userName) {
//        User userDb = userRepo.findUserByUserName(userName);
//        if(userDb==null){
//            throw new RuntimeException("User by userName: " + userName + " not found");
//        }
//
//        Master master = userDb.getMaster();
//        if(master==null){
//            throw new RuntimeException("User is not master");
//        }
//
////        Set<Specialization> specializations = master.getSpecializations();
////        if(specializations==null || specializations.isEmpty() || specializations.size()==0){
////            throw new RuntimeException("The master: "
////                    + master.getFirstName()+" "
////                    + master.getLastName()+" does not have any specialization");
////        }
//        ModelMapper modelMapper=new ModelMapper();
//        UserMasterDto returnValue = modelMapper.map(userDb, UserMasterDto.class);
//        returnValue.setUserIsClient(false);
//        return returnValue;
//    }
//
//
//    //@Override
//    public UserMasterDto getUserMasterByUserId(String userId) {
//        User userDb = userRepo.findUserByUserId(userId);
//        if(userDb==null){
//            throw new RuntimeException("User by userId not found");
//        }
//        return getUserMasterByUserName(userDb.getUserName());
//    }
//
//
//    //@Override
//    public Set<SpecializationDto> getSpecializations(String userName) {
//
//
//        User userByUserName = userRepo.findUserByUserName(userName);
//        if(userByUserName==null){
//            String[] params=new String[]{userName};
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,params,LocaleContextHolder.getLocale());
//            //throw new UsernameNotFoundException("User with email: "+userName+" not found");
//            //throw new RuntimeException("User with user name: "+userName+" not found");
//            throw new RuntimeException(message);
//        }
//
//        if(!userByUserName.isActive()){
//            String[] params=new String[]{userName};
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,params,LocaleContextHolder.getLocale());
//            //throw new UsernameNotFoundException("User with email: "+userName+" not found");
//            //throw new RuntimeException("User with user name: "+userName+" not found");
//            throw new RuntimeException(message);
//        }
//
//
//
//        ModelMapper modelMapper=new ModelMapper();
//        Set<Specialization> specializations = userByUserName.getMaster().getSpecializations();
//        if(specializations == null || specializations.isEmpty()){
//            throw new RuntimeException("List of specializations for master: " + userName +" is empty");
//        }
//        Set<SpecializationDto>returnValue= new HashSet<>();
//
//        Type listType=new TypeToken<Set<SpecializationDto>>() {}.getType();
//        returnValue = modelMapper.map(specializations, listType);
//
////
//
////        for (Specialization specialization:specializations ) {
////             specializationDtos.add( modelMapper.map(specialization, SpecializationDto.class));
////        }
////
//
//
//        return returnValue;
//
//
//    }
//
//
//    //@Override
//    public UserClientDto updateUser(UserClientDto user) {
//        if(user == null){
//            //throw new RuntimeException("user is null");
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,null,LocaleContextHolder.getLocale());
//            //throw new UsernameNotFoundException("User with email: "+userName+" not found");
//            //throw new RuntimeException("User with user name: "+userName+" not found");
//            throw new UserServiceException(message);
//        }
//
//
//        User userDb =userRepo.findUserByUserId(user.getUserId());
//        if(userDb == null){
//            //throw new RuntimeException("User "+user.getUserName()+" not found in db");
//
//            String[] params=new String[]{user.getUserName()};
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,params,LocaleContextHolder.getLocale());
//            throw new UsernameNotFoundException(message);
//        }
//        if(!userDb.isActive()){
//            String[] params=new String[]{user.getUserName()};
//            String message = messageSource.getMessage("user.usernamenotfound"
//                    ,params,LocaleContextHolder.getLocale());
//            throw new UsernameNotFoundException(message);
//        }
//
//
//        if(true /*user.isClient()*/){
//            userDb.getClient().setFirstName(user.getClient().getFirstName());
//            userDb.getClient().setLastName(user.getClient().getLastName());
//            userDb.getClient().setEmail(user.getClient().getEmail());
//            userDb.getClient().setPhoneNumber(user.getClient().getPhoneNumber());
//        //}else{
////            userDb.getMaster().setFirstName(user..getFirstName());
////            userDb.getMaster().setLastName(user.getLastName());
////            userDb.getMaster().setEmail(user.getEmail());
////            userDb.getMaster().setPhoneNumber(user.getPhoneNumber());
//            throw new RuntimeException("User is not master");
//        }
//
//        if(user.getPassword()==null
//                || user.getPassword().isEmpty()
//                || user.getPassword()==""
//                || user.getPassword().equals("")){
//
//        }else{
//            userDb.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        }
//        //BeanUtils.copyProperties(user,userDb);
//        userDb.setUserName(user.getUserName());
//        User updatedUser = userRepo.save(userDb);
//        if(updatedUser==null){
//            //throw new RuntimeException("User: " + user.getUserName()+" did not update");
//
//            String[] params=new String[]{user.getUserName()};
//            String message = messageSource.getMessage("user.usernotupdate"
//                    ,params,LocaleContextHolder.getLocale());
//            throw new UsernameNotFoundException(message);
//
//
//        }
//        UserClientDto returnUserDto=new UserClientDto();
//        BeanUtils.copyProperties(updatedUser,returnUserDto);
//
//        if(user.getClient()!=null){
//            BeanUtils.copyProperties(updatedUser.getClient(),returnUserDto);
//        }else{
//            BeanUtils.copyProperties(updatedUser.getMaster(),returnUserDto);
//        }
//
//        return returnUserDto;
//
//        //return null;
//    }
//
//    //@Override
//    public void deleteUser( UserClientDto user) {
//        if(user==null){
//            throw new RuntimeException("user is empty");
//        }
//        User userDb=userRepo.findUserByUserId(user.getUserId());
//        if(userDb==null){
//            String[] params=new String[]{user.getUserName()};
//            String message=messageSource.getMessage("user.usernotfound",params,
//                    LocaleContextHolder.getLocale());
//            throw new UsernameNotFoundException(message);
//        }
//
//        if(!userDb.isActive()){
//            String[] params=new String[]{user.getUserName()};
//            String message=messageSource.getMessage("user.usernotfound",params,
//                    LocaleContextHolder.getLocale());
//            throw new UsernameNotFoundException(message);
//        }
//
//        userDb.setActive(false);
//        User deleteUser = userRepo.save(userDb);
//        if(deleteUser.isActive()){
//            String message=messageSource.getMessage("user.usernotdelete",null
//                    ,LocaleContextHolder.getLocale());
//            throw new UserServiceException(message);
//        }
//
//
//        //User userDb=new User();
//        //BeanUtils.copyProperties(user,userDb);
//
//        //userRepo.delete(userDb);
//
//        //return null;
//    }
//
//    //@Override
//    public void deleteUserByUserId(String userId) {
////        UserClientDto userByUserId = getUserByUserId(userId);
////        deleteUser(userByUserId);
//    }
//
//    //
//
//
//    //@Override
////    public UserClientDto getUserByCodeActivate(String code) {
////        User byActivateCode = userRepo.findByActivateCode(code);
////        if(byActivateCode==null){
////            //throw new RuntimeException("Activation code is wrong");
////
////            String message = messageSource.getMessage(
////                    "registration.user.activationcodewrong"
////                    ,null,LocaleContextHolder.getLocale());
////            throw new RuntimeException(message);
////
////        }
////
////        byActivateCode.setActivateCode("");
////        byActivateCode.setActive(true);
////        User userActivated=userRepo.save(byActivateCode);
////        if(userActivated==null){
////            //throw new RuntimeException("Error during activatiion");
////
////            String message = messageSource.getMessage(
////                    "registration.user.activationerror"
////                    ,null,LocaleContextHolder.getLocale());
////            throw new RuntimeException(message);
////        }
////
////
////        UserClientDto userDto=new UserClientDto();
////
////        BeanUtils.copyProperties(userActivated,userDto);
////        if(userActivated.getClient()!=null){
////            BeanUtils.copyProperties(userActivated.getClient(),userDto);
////        }else{
////            BeanUtils.copyProperties(userActivated.getMaster(),userDto);
////        }
////
////
////        return userDto;
////    }
//
//
//
//
//    //@Override
////    public ClientDto getClientByClientId(Long clientId) {
////        Optional<Client> clientOptional = clientRepo.findById(clientId);
////        if(!clientOptional.isPresent()){
////            throw new RuntimeException("Client not found");
////        }
////        Client client = clientOptional.get();
////        ModelMapper modelMapper=new ModelMapper();
////        ClientDto returnValue = modelMapper.map(client, ClientDto.class);
////        return returnValue;
////    }
//
//    //@Override
////    public UserClientDto getUserClientByClientId(long clientId){
////        Optional<Client> clientOptional = clientRepo.findById(clientId);
////        if(!clientOptional.isPresent()){
////            throw new RuntimeException("Client not found");
////        }
////        Client client = clientOptional.get();
////        User clientUser = client.getUser();
////        if (clientUser==null){
////            throw new RuntimeException("User not found");
////        }
////        ModelMapper modelMapper=new ModelMapper();
////        UserClientDto returnValue = modelMapper.map(clientUser, UserClientDto.class);
////        return returnValue;
////    }
//
//    //@Override
////    public UserMasterDto getUserMasterByMasterId(long masterId) {
////        Optional<Master> masterOptional = masterRepo.findById(masterId);
////        if(!masterOptional.isPresent()){
////            throw new RuntimeException("Client not found");
////        }
////
////        Master master=masterOptional.get();
////        User masterUser = master.getUser();
////        if (masterUser==null){
////            throw new RuntimeException("User not found");
////        }
////        ModelMapper modelMapper=new ModelMapper();
////        UserMasterDto returnValue = modelMapper.map(masterUser, UserMasterDto.class);
////        return returnValue;
////    }
}
