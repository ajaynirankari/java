package com.gl.CreateFutureDateByAddingNoOfDaysInCurrentDate;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Sample {
    public static void main(String[] args) {

        Instant currentDate = Instant.now();
        System.out.println("currentDate = " + currentDate);

        Instant futureDate = Instant.now().plus(365, ChronoUnit.DAYS);
        System.out.println("futureDate = " + futureDate);

        String stringFutureDate = Instant.now().plus(365, ChronoUnit.DAYS).toString();
        System.out.println("stringFutureDate = " + stringFutureDate);

        Instant plusPeriodOfDays = Instant.now().plus(Period.ofDays(365));
        System.out.println("plusPeriodOfDays = " + plusPeriodOfDays);

        String stringPlusPeriodOfDays = Instant.now().plus(Period.ofDays(365)).toString();
        System.out.println("stringPlusPeriodOfDays = " + stringPlusPeriodOfDays);

    }
}
