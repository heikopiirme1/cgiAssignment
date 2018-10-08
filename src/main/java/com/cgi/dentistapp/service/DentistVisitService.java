package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //Mapib visiidi andmed, et need hiljem listi lisada
    class DentistVisitRowMapper implements RowMapper<DentistVisitDTO> {
        @Override
        public DentistVisitDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            DentistVisitDTO dentistVisitDTO = new DentistVisitDTO();
            dentistVisitDTO.setVisitId(Long.parseLong(rs.getString("id")));
            dentistVisitDTO.setDentistName(rs.getString("dentist_name"));
            dentistVisitDTO.setVisitTime(rs.getString("visit_time"));
            return dentistVisitDTO;
        }

    }

    //Kõik visiidid
    public List<DentistVisitDTO> findAll() {
        return jdbcTemplate.query("SELECT * FROM DENTIST_VISIT ORDER BY VISIT_TIME", new DentistVisitRowMapper());
    }

    //Üks visiit ID järgi
    public DentistVisitDTO findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM DENTIST_VISIT where id=?", new Object[] { id },
                new DentistVisitRowMapper());
    }

    //Visiidi lisamine
    public void addVisit(String dentistName, String visitTime) {
        //TODO implementation
        jdbcTemplate.update("INSERT INTO DENTIST_VISIT(ID, DENTIST_NAME, VISIT_TIME) VALUES(DEFAULT, ?, ?)", dentistName, visitTime);
    }

    //Visiidi muutmine
    public void updateVisit(long visitId, String dentistName, String visitTime) {
        //TODO implementation
        jdbcTemplate.update("UPDATE DENTIST_VISIT SET DENTIST_NAME = ?, VISIT_TIME = ? WHERE ID = ?", dentistName, visitTime, visitId);
    }

    //Visiidi kustutamine
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM DENTIST_VISIT where id=?", new Object[] { id });
    }






    //List, et HTMLis kõiki visiite kuvada
    public List<DentistVisitDTO> listAll() {
        List<DentistVisitDTO> visits = new ArrayList<>();
        this.findAll().forEach(visits::add);
        return visits;
    }
}
