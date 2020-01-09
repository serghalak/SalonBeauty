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

    //User findUserByEmail(String email);
    User findUserById(Long id);
    //User findUserByUserName(String userName);
    User findUserByUserId(String userId);
    User findUserByUserName(String userName);
    User findByUserId(String userId);
    User findByActivateCode(String code);
    //User findUserByPhoneNumber(String phoneNumber);
    Page<User> findByActive(Boolean isActive, Pageable pageable);
}
