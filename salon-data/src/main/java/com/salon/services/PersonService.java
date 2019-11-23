package com.salon.services;

import ch.qos.logback.core.net.server.Client;
import com.salon.domain.Person;

import java.util.Set;


public interface PersonService extends CrudService<Person,Long> {

    Set<Client> findByFirstName(String firstName);
    Set<Client>findByLastName(String lastName);
    //when you know only part of phoneNumber or email
    Set<Client>findByPhoneNumber(String phoneNumber);
    Set<Client>findByEmail(String email);
}
