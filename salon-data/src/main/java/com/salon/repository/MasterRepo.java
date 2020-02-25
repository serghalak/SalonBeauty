package com.salon.repository;

import com.salon.domain.Master;
import com.salon.domain.Specialization;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.MappedSuperclass;
import java.util.List;

@Repository
public interface MasterRepo extends PagingAndSortingRepository<Master,Long> {

//    List<Master> findMasterByFirstName(String firstName);
//    List<Master>findMasterByLastName(String lastName);
//    List<Master>findMasterBySpecializations(Specialization specialization);
    //User findMasterByUser(Master master);

}
