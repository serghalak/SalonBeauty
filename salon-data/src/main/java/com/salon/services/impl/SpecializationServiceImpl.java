package com.salon.services.impl;

import com.salon.domain.Specialization;
import com.salon.dto.SpecializationDto;
import com.salon.services.SpecializationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecializationServiceImpl implements SpecializationService {
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
        return null;
    }

    @Override
    public Set<SpecializationDto> getSpecializationMasterByUserName(String userName) {
        return null;
    }

    @Override
    public Set<SpecializationDto> getAllSpecialization() {
        return null;
    }
}
