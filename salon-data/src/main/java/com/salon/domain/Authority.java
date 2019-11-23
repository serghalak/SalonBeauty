package com.salon.domain;


//import org.springframework.data.annotation.Id;

//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table
public class Authority  extends IdEntity/*implements GrantedAuthority,Serializable*/ {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;

    //@Column
    private String roleName;

    @OneToMany(mappedBy = "authority")
    private Set<User> users=new HashSet<>();


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    //@Override
    public String getAuthority() {
        return getRoleName();
    }
}
