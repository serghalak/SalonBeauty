package com.salon.services.impl;

import com.salon.common.Utils;
import com.salon.domain.Master;
import com.salon.dto.UserMasterDto;
import com.salon.repository.ClientRepo;
import com.salon.repository.MasterRepo;
import com.salon.repository.UserRepo;
import com.salon.services.UserMasterService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

//@Service
public abstract class UserMasterServiceImpl /*extends UserServiceImpl implements UserMasterService*/ {

    private MasterRepo masterRepo;

//    public UserMasterServiceImpl(
//            UserRepo userRepo, ClientRepo clientRepo, MasterRepo masterRepo,
//            Utils utils, BCryptPasswordEncoder bCryptPasswordEncoder, MasterRepo masterRepo1) {
//        super(userRepo, clientRepo, masterRepo, utils, bCryptPasswordEncoder);
//        this.masterRepo = masterRepo;
//    }

    //@Override
    public Set<UserMasterDto> findAll() {
        return null;
    }

    //@Override
    public UserMasterDto findById(Long aLong) {
        return null;
    }

    //@Override
    public UserMasterDto save(UserMasterDto object) {
        return null;
    }

    //@Override
    public void delete(UserMasterDto object) {

    }

    //@Override
    public void deleteById(Long aLong) {

    }
}
