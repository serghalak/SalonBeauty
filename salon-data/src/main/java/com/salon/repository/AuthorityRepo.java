package com.salon.repository;

import com.salon.domain.Authority;
import com.salon.domain.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepo extends CrudRepository<Authority,Long> {
}
