package com.company;

import java.text.ParseException;
import java.time.LocalDate;


import static java.time.temporal.ChronoUnit.DAYS;

public class TimeCalc {

    public long calculateTime(String license) throws ParseException {
        String[] y = license.split(" ");
        LocalDate startDate= LocalDate.parse(y[1]);
        LocalDate endDate= LocalDate.parse(y[2]);
        return DAYS.between(startDate, endDate);
    }
}
