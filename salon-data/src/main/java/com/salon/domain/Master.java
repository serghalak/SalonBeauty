package com.salon.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Master extends Person {



    @ManyToMany
    @JoinTable(name = "master_specialization"
            ,joinColumns = @JoinColumn(name = "master_id"/*,referencedColumnName = "id"*/)
            ,inverseJoinColumns = @JoinColumn(name="specialization_id"/*,referencedColumnName = "id"*/))
    private Set<Specialization> specializations=new HashSet<>();



//    @OneToMany(mappedBy = "master")
//    private List<Appointment>appointments=new ArrayList<>();

//    public Long getId() {
//        return getId();
//    }
//
//    public void setId(Long id) {
//        this.setId(id);
//    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }
}
