package com.salon.services.impl;

import com.salon.domain.Specialization;
import com.salon.domain.User;
import com.salon.dto.SpecializationDto;
import com.salon.repository.UserRepo;
import com.salon.services.SpecializationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@Service
public class SpecializationServiceImpl implements SpecializationService {


    private UserRepo userRepo;

    public SpecializationServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Set<Specialization> findAll() {
        return null;
    }

    @Override
    public Specialization findById(Long aLong) {
        return null;
    }

    @Override
    public Specialization save(Specialization object) {
        return null;
    }

    @Override
    public void delete(Specialization object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Set<SpecializationDto> getSpecializationMasterByUserId(String userId) {

        User userDb = userRepo.findByUserId(userId);
        if(userDb==null || !userDb.isActive()){
            throw new RuntimeException("user with userId not found");
        }
        if(userDb.getMaster()==null){
            throw new RuntimeException("User is not master");

        }
        Set<Specialization> specializations = userDb.getMaster().getSpecializations();
        if(specializations==null || specializations.isEmpty()){
            throw new RuntimeException("This master does not have any specializations");
        }

        ModelMapper modelMapper=new ModelMapper();

        Set<SpecializationDto>returnValue= new HashSet<>();

        Type listType=new TypeToken<Set<SpecializationDto>>() {}.getType();
        returnValue = modelMapper.map(specializations, listType);

        return returnValue;
    }


    @Override
    public Set<SpecializationDto> getSpecializationMasterByUserName(String userName) {
        User userDb = userRepo.findUserByUserName(userName);
        if(userDb==null || !userDb.isActive()){
            throw new RuntimeException("user with userId not found");
        }
        if(userDb.getMaster()==null){
            throw new RuntimeException("User is not master");

        }
        Set<Specialization> specializations = userDb.getMaster().getSpecializations();
        if(specializations==null || specializations.isEmpty()){
            throw new RuntimeException("This master does not have any specializations");
        }

        ModelMapper modelMapper=new ModelMapper();

        Set<SpecializationDto>returnValue= new HashSet<>();

        Type listType=new TypeToken<Set<SpecializationDto>>() {}.getType();
        returnValue = modelMapper.map(specializations, listType);

        return returnValue;
    }


}
