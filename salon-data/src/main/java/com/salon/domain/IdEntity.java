package com.salon.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class IdEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
