package com.example.final_project.Models;

import java.util.Date;
import java.util.List;

public class ReservationData {
    private Date fromDate;
    private Date toDate;
    private List<String> checkboxChoices;

    public ReservationData(Date fromDate, Date toDate, List<String> checkboxChoices) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.checkboxChoices = checkboxChoices;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<String> getCheckboxChoices() {
        return checkboxChoices;
    }

    public void setCheckboxChoices(List<String> checkboxChoices) {
        this.checkboxChoices = checkboxChoices;
    }
}