package com.cgi.dentistapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String dentist_name, visit_time;

    //TODO implementation

    public DentistVisitEntity(long id, String dentist_name, String visit_time) {
        this.id = id;
        this.dentist_name = dentist_name;
        this.visit_time = visit_time;
    }
}
