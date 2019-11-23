package com.salon.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table
public class Status extends IdEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    //@Column
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List<Appointment> appointments=new ArrayList<>();


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
