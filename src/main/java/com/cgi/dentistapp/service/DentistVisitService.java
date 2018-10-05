package com.cgi.dentistapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addVisit(String dentistName, Date visitTime) {
        //TODO implementation
        jdbcTemplate.update("INSERT INTO DENTIST_VISIT(ID, DENTIST_NAME, VISIT_TIME) VALUES(DEFAULT, ?, ?)", dentistName, visitTime);
    }

}
