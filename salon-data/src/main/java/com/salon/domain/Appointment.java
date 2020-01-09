package com.salon.domain;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
///@Table
public class Appointment extends IdEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    //@Column
    private Date startDate;
    //@Column
    private Date endDate;
    //@Column
    private String room;
    //@Column
    private String description;



    @ManyToOne
    @JoinColumn(name="master_id",referencedColumnName = "id")
    private Master master;

    @ManyToOne
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="status_id",referencedColumnName = "id")
    private Status status;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
