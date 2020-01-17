package com.salon.repository;

import com.salon.domain.Master;
import com.salon.domain.Specialization;
import com.salon.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpecializationRepo extends CrudRepository<Specialization,Long> {
//    Set<Specialization>findAllByMaster(Master master);
//    Set<Specialization>findAllByUser(User user);
}
