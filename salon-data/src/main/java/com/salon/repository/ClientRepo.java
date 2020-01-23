package com.salon.repository;

import com.salon.domain.Client;
import com.salon.domain.Master;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends PagingAndSortingRepository<Client,Long> {

}
