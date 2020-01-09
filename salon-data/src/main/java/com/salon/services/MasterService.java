package com.salon.services;

import com.salon.domain.Master;
import com.salon.dto.MasterDto;


import java.util.List;
import java.util.Set;


public interface MasterService extends CrudService<Master,Long> {

    Set<Master> findBySpesialization(String specialization);

    MasterDto createMaster(MasterDto master);
    MasterDto getMaster(String masterName);
    MasterDto getMasterByMasterId(String MasterIdId);
    //    UserDto getUserByUserName(String userName);
    List<MasterDto> getListMasters();
    MasterDto updateMaster(MasterDto user);
    //MasterDto getMasterByCodeActivate(String code);

    void deleteMaster(MasterDto user);
    void deleteMasterByMasterId(String masterId);

    List<MasterDto> getMasters(Integer page, Integer limit);

}
