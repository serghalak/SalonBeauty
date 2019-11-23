package com.salon.domain;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table
public class Specialization extends IdEntity  {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    //@Column
    private String specializationName;


    @ManyToMany
    @JoinTable(name="master_specialization"
            ,joinColumns = @JoinColumn(name = "specialization_id"/*,referencedColumnName = "id"*/)
            ,inverseJoinColumns = @JoinColumn(name="master_id"/*,referencedColumnName = "id"*/))
    private Set<Master> masters=new HashSet<>();

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getSpecializationName() {
        return specializationName;
    }


    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public Set<Master> getMasters() {
        return masters;
    }

    public void setMasters(Set<Master> masters) {
        this.masters = masters;
    }
}