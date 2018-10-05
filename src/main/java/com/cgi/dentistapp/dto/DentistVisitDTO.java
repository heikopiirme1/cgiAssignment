package com.cgi.dentistapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class DentistVisitDTO {

    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    String visitTime;

    long visitId;

    public DentistVisitDTO() {
    }

    public DentistVisitDTO(long visitId, String dentistName, String visitTime) {
        this.visitId = visitId;
        this.dentistName = dentistName;
        this.visitTime = visitTime;
    }

    public long getVisitId() {
        return visitId;
    }

    public void setVisitId(long visitId) {
        this.visitId = visitId;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return String.format(
                "DentistVisitDTO[id='%d', dentistName='%s', visitTime='%s']",
                visitId, dentistName, visitTime);
    }
}
