package com.salon.services.impl;

import com.salon.domain.Master;
import com.salon.dto.MasterDto;
import com.salon.repository.MasterRepo;
import com.salon.services.MasterService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MasterServiceImpl implements MasterService {

    MasterRepo masterRepo;

    public MasterServiceImpl(MasterRepo masterRepo) {
        this.masterRepo = masterRepo;
    }

    @Override
    public Set<Master> findAll() {
        return null;
    }

    @Override
    public Master findById(Long id) {
        Optional<Master> masterDb = masterRepo.findById(id);
        Master master=masterDb.get();
        if(master==null){
            throw new RuntimeException("Master with id: " + id + " not found");
        }

        return master;
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
    public MasterDto getMasterByMasterId(Long id) {
        Master master = findById(id);
        ModelMapper modelMapper=new ModelMapper();
        MasterDto returnValue = modelMapper.map(master, MasterDto.class);
        return returnValue;
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
