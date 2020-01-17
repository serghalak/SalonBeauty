package com.salon.services;

import com.salon.domain.Master;
import com.salon.domain.Specialization;
import com.salon.domain.User;
import com.salon.dto.MasterDto;
import com.salon.dto.SpecializationDto;
import com.salon.dto.UserDto;

import java.util.Set;


public interface SpecializationService
        extends CrudService<Specialization,Long> {

    Set<SpecializationDto> getSpecializationMasterByUserId(String userId);
    Set<SpecializationDto> getSpecializationMasterByUserName(String userName);

    Set<SpecializationDto>getSpecializationByMaster(MasterDto master);
    Set<SpecializationDto>getSpecializationByUser(UserDto user);




}
