package com.salon.dto;


import com.salon.domain.Specialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MasterDto extends PersonDto{

    private Set<SpecializationDto> specializations
            =new HashSet<>();//specializationDtoList;

    public Set<SpecializationDto> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationDto> specializations) {
        this.specializations = specializations;
    }


}
