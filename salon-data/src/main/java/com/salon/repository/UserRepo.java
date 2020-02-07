package com.salon.repository;


import com.salon.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long> {

    User findByMaster_Email(String email);
    User findByClient_Email(String email);

    //User findById(Long id);
    User findByUserName(String userName);
    User findByUserId(String userId);
    User findByActivateCode(String code);
    User findByMaster_PhoneNumber(String phoneNumber);
    User findByClient_PhoneNumber(String phoneNumber);
    Page<User> findByActive(Boolean isActive, Pageable pageable);
}
