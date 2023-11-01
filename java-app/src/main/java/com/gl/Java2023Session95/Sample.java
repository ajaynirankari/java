package com.gl.Java2023Session95;

import com.gl.util.ThreadSleep;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Sample {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("date = " + date);
        ThreadSleep.sleep(Duration.ofSeconds(1));
        Date date1 = new Date();
        System.out.println("date1 = " + date1);
        System.out.println("--------------------------------------------------------------------------");

        Calendar calender = Calendar.getInstance();
        System.out.println("calender = " + calender);

        Date time = calender.getTime();
        System.out.println("time = " + time);
        System.out.println("calender.getTimeZone() = " + calender.getTimeZone());
        System.out.println("calender.getCalendarType() = " + calender.getCalendarType());
        System.out.println("--------------------------------------------------------------------------");

        calender.set(1995, 0, 27);
        System.out.println("set date & time = " + calender.getTime());
        System.out.println("--------------------------------------------------------------------------");

        calender.set(1990, 1, 27);
        System.out.println("set date & time = " + calender.getTime());
        System.out.println("--------------------------------------------------------------------------");

        long timeMillis = System.currentTimeMillis();
        System.out.println("timeMillis = " + timeMillis);

        Date cdate = new Date(timeMillis);
        System.out.println("cdate = " + cdate);
        System.out.println("Calendar.getInstance().getTime() = " + Calendar.getInstance().getTime());
        System.out.println("--------------------------------------------------------------------------");

        Calendar dob = Calendar.getInstance();
        System.out.println("---- dobTime = " + dob.getTime());
        dob.set(1990, 7, 23);
        Date dobTime = dob.getTime();
        System.out.println("dobTime = " + dobTime);
        dob.set(1990, 7, 23, 5, 36, 25);
        System.out.println("dobTime = " + dob.getTime());

        dob.add(Calendar.MONTH, 12);
        System.out.println("dobTime = " + dob.getTime());

        dob.add(Calendar.YEAR, 3);
        System.out.println("dobTime = " + dob.getTime());

        dob.add(Calendar.DATE, 2);
        System.out.println("dobTime = " + dob.getTime());
        System.out.println("--------------------------------------------------------------------------");


        Arrays.stream(DayOfWeek.values()).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------");

        Arrays.stream(DayOfWeek.values()).forEach(d -> System.out.println(d.getDisplayName(TextStyle.FULL, Locale.getDefault())));
        Arrays.stream(DayOfWeek.values()).forEach(d -> System.out.println(d.getDisplayName(TextStyle.SHORT, Locale.getDefault())));
        Arrays.stream(DayOfWeek.values()).forEach(d -> System.out.println(d.getDisplayName(TextStyle.NARROW, Locale.getDefault())));
        System.out.println("--------------------------------------------------------------------------");

        Arrays.stream(Month.values()).forEach(System.out::println);
        Arrays.stream(Month.values()).forEach(d -> System.out.println(d.getDisplayName(TextStyle.FULL, Locale.getDefault())));
        Arrays.stream(Month.values()).forEach(d -> System.out.println(d.getDisplayName(TextStyle.SHORT, Locale.getDefault())));
        Arrays.stream(Month.values()).forEach(d -> System.out.println(d.getDisplayName(TextStyle.NARROW, Locale.getDefault())));
        System.out.println("--------------------------------------------------------------------------");

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);

        OffsetTime offsetTime = OffsetTime.now();
        System.out.println("offsetTime = " + offsetTime);

        Instant now = Instant.now();
        System.out.println("now = " + now);

        LocalDate epoch = LocalDate.EPOCH;
        System.out.println("epoch = " + epoch);

        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

        Instant epoch1 = Instant.EPOCH;
        System.out.println("epoch1 = " + epoch1);

        System.out.println("ZoneOffset.systemDefault() = " + ZoneOffset.systemDefault());
        System.out.println("--------------------------------------------------------------------------");

        ZoneId.getAvailableZoneIds()
                .stream()
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("ZoneId.getAvailableZoneIds().stream().count() = " + ZoneId.getAvailableZoneIds().stream().count());

        Instant now1 = Instant.now();
        System.out.println("now = " + now1);
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
    }
}