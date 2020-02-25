package com.salon.dto;


import java.io.Serializable;

public class AuthorityDto implements Serializable {

    private Long id;
    private String roleName;
    private UserDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
