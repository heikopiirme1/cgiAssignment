package com.cgi.dentistapp;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.service.DentistVisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class DentistAppApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DentistVisitService repository;

    public static void main(String[] args) {
        SpringApplication.run(DentistAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All visits 1 -> {}", repository.findAll());
        logger.info("Delete visit id 2 -> {}", repository.delete(2));
        logger.info("Update 3 -> {}", repository.update(new DentistVisitDTO(3, "Uuendatud nimi", "2018-10-25T22:30")));
        logger.info("Visit id 2 -> {}", repository.findById(3));
    }
}
