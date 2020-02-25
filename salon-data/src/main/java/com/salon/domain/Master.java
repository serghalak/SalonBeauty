package com.salon.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Master extends IdEntity {

    @ManyToMany
    @JoinTable(name = "master_specialization"
            ,joinColumns = @JoinColumn(name = "master_id",referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name="specialization_id",referencedColumnName = "id"))
    private Set<Specialization> specializations=new HashSet<>();


//    @OneToOne(mappedBy = "master")
//    private User user;

    @OneToMany(mappedBy = "master")
    private List<Appointment> appointments=new ArrayList<>();

//    public Long getId() {
//        return getId();
//    }
//
//    public void setId(Long id) {
//        this.setId(id);
//    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
