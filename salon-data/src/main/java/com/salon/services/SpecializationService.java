package com.salon.services;

import com.salon.domain.Specialization;
import com.salon.dto.SpecializationDto;

import java.util.Set;


public interface SpecializationService
        extends CrudService<Specialization,Long> {

    Set<SpecializationDto> getSpecializationMasterByUserId(String userId);
    Set<SpecializationDto> getSpecializationMasterByUserName(String userName);


}
