package com.salon.services;

import com.salon.domain.Master;

import java.util.Set;


public interface MasterService extends CrudService<Master,Long> {

    Set<Master> findBySpesialization(String specialization);

}
