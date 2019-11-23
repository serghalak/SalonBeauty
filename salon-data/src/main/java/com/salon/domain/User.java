package com.salon.domain;

//import org.springframework.data.annotation.Id;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Entity
//@Table
public class User /*extends Person*/ /*implements UserDetails */{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String activateCode;

    //@Column(nullable = false)
    private boolean active=false;

    //@Column(nullable = false)
    private String password;

    //@Column(nullable = false,unique = true,length =100 )
    private String userName;

    //@Column(nullable = false,unique = true,length =100 )
    private String userId;

//    @Column(nullable = false,length =100 )
//    private String password;



    //@Column(nullable = false,unique = true,length =150)
    private String email;

//    @Column(nullable = false,unique = true,length =100 )
//    private String encryptedPassword;

//    @ManyToOne
//    @JoinColumn(name = "authorityId",referencedColumnName = "id")
    private Authority authority;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    /*---------------------------------------------------------------------------*/


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auth=new ArrayList<>();
//        auth.add(getAuthority());
//        return auth;
//    }



//    @Override
//    public String getUsername() {
//        return getUserName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true ;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isActive();
//    }


}
