package com.salon.services.impl;

import com.salon.domain.Master;
import com.salon.domain.Specialization;
import com.salon.domain.User;
import com.salon.dto.MasterDto;
import com.salon.dto.SpecializationDto;
import com.salon.dto.UserDto;
import com.salon.repository.SpecializationRepo;
import com.salon.repository.UserRepo;
import com.salon.services.SpecializationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SpecializationServiceImpl implements SpecializationService {


    private UserRepo userRepo;
    private SpecializationRepo specializationRepo;

    public SpecializationServiceImpl(UserRepo userRepo,SpecializationRepo specializationRepo) {
        this.userRepo = userRepo;
        this.specializationRepo=specializationRepo;
    }

    @Override
    public Set<Specialization> findAll() {
        return null;
    }

    @Override
    public Specialization findById(Long id) {
        Optional<Specialization> specialization = specializationRepo.findById(id);
        return specialization.get();
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

    @Override
    public Set<SpecializationDto> getSpecializationByMaster(MasterDto master) {
        return master.getSpecializations();
    }

    @Override
    public Set<SpecializationDto> getSpecializationByUser(UserDto user) {
        return getSpecializationMasterByUserName(user.getUserName());
    }

    @Override
    public SpecializationDto getSpecializationById(long id) {
        Specialization specialization = findById(id);
        if(specialization==null){
            throw new RuntimeException("Thre is no specialization with id: " + id);
        }
        ModelMapper modelMapper=new ModelMapper();
        SpecializationDto returnValue = modelMapper.map(specialization, SpecializationDto.class);
        return returnValue;
    }


}
