package com.salon.repository;

import com.salon.domain.Master;
import com.salon.domain.Specialization;
import com.salon.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.MappedSuperclass;
import java.util.List;

@Repository
public interface MasterRepo extends CrudRepository<Master,Long> {

    List<Master> findMasterByFirstName(String firstName);
    List<Master>findMasterByLastName(String lastName);
    //List<Master>findMasterBySpecialization(Specialization specialization);
    //User findMasterByUser(Master master);

}
