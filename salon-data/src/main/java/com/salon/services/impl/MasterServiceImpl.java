package com.salon.services.impl;

import com.salon.domain.Master;
import com.salon.dto.MasterDto;
import com.salon.services.MasterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MasterServiceImpl implements MasterService {
    @Override
    public Set<Master> findAll() {
        return null;
    }

    @Override
    public Master findById(Long aLong) {
        return null;
    }

    @Override
    public Master save(Master object) {
        return null;
    }

    @Override
    public void delete(Master object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Set<Master> findBySpesialization(String specialization) {
        return null;
    }

    @Override
    public MasterDto createMaster(MasterDto master) {
        return null;
    }

    @Override
    public MasterDto getMaster(String masterName) {
        return null;
    }

    @Override
    public MasterDto getMasterByMasterId(String MasterIdId) {
        return null;
    }

    @Override
    public List<MasterDto> getListMasters() {
        return null;
    }

    @Override
    public MasterDto updateMaster(MasterDto user) {
        return null;
    }

    @Override
    public void deleteMaster(MasterDto user) {

    }

    @Override
    public void deleteMasterByMasterId(String masterId) {

    }

    @Override
    public List<MasterDto> getMasters(Integer page, Integer limit) {
        return null;
    }
}
