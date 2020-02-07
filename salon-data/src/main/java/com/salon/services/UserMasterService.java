package com.salon.services;


import com.salon.domain.Master;
import com.salon.dto.SpecializationDto;
import com.salon.dto.UserMasterDto;

import java.util.Set;

public interface UserMasterService extends CrudService<UserMasterDto,Long> {



    UserMasterDto getUserMasterByMasterId(long masterId);
    UserMasterDto createUserMaster(UserMasterDto userMasterDto);
    UserMasterDto getUserMasterByUserName(String userName);
    UserMasterDto getUserMasterByUserId(String userId);
    Set<SpecializationDto> getSpecializations(String userName);
}
