package com.salon.repository;


import com.salon.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    //User findUserByEmail(String email);
    User findUserById(Long id);
    //User findUserByUserName(String userName);
    User findUserByUserId(String userId);
    User findUserByUserName(String userName);
    User findByUserId(String userId);
    User findByActivateCode(String code);
    //User findUserByPhoneNumber(String phoneNumber);

}
