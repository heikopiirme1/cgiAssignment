package com.cgi.dentistapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dentist_name;
    private String visit_time;

    //TODO implementation
}
