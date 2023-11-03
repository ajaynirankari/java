package com.gl.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* GMT or UTC Date Conversion */
public class DateConversionUtil {

    private static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm:ss";

    public static void main(String[] args) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date = calendar.getTime();

        Date convertedDate = convertDateInUTC(date, getZoneIdByName("Australia/Sydney"), getZoneIdByName("UTC"));
        DateConversionUtil.convertDateFromUTC(convertedDate, getZoneIdByName("UTC"), getZoneIdByName("Australia/Sydney"));
        System.out.println("-----------------------------------------------------------------------------");

        convertedDate = convertDateInUTC(new Date(), getZoneIdByName("Asia/Calcutta"), getZoneIdByName("UTC"));
        DateConversionUtil.convertDateFromUTC(convertedDate, getZoneIdByName("UTC"), getZoneIdByName("Asia/Calcutta"));
        System.out.println("-----------------------------------------------------------------------------");

        convertedDate = convertDateInUTC(new Date(), getZoneIdByName("America/New_York"), getZoneIdByName("UTC"));
        convertDateFromUTC(convertedDate, getZoneIdByName("UTC"), getZoneIdByName("America/New_York"));
        System.out.println("-----------------------------------------------------------------------------");

        convertDateFromUTCtoAgainNewCompnayTimezone(new Date(), "Asia/Singapore", "Asia/Calcutta");
    }

    public static Date convertDateInUTC(Date date, TimeZone fromTimeZone, TimeZone toTimeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date = calendar.getTime();
        DateFormat simpleDateFormate = new SimpleDateFormat(DATE_FORMATTER);
        date = getLocalTimestamp(simpleDateFormate.format(date), fromTimeZone, toTimeZone);
        return date;
    }

    public static Date convertDateFromUTC(Date date, TimeZone fromTimeZone, TimeZone toTimeZone) {
        DateFormat simpleDateFormate = new SimpleDateFormat(DATE_FORMATTER);
        date = getLocalTimestamp(simpleDateFormate.format(date), fromTimeZone, toTimeZone);
        return date;
    }

    public static Date convertDateFromUTCtoAgainNewCompnayTimezone(Date date, String oldZoneId, String newZoneId) {
        TimeZone fromTimeZone = getZoneIdByName("UTC");
        TimeZone toTimeZone = getZoneIdByName(oldZoneId);
        DateFormat simpleDateFormate = new SimpleDateFormat(DATE_FORMATTER);
        date = getLocalTimestamp(simpleDateFormate.format(date), fromTimeZone, toTimeZone);
        fromTimeZone = getZoneIdByName(newZoneId);
        toTimeZone = getZoneIdByName("UTC");
        simpleDateFormate = new SimpleDateFormat(DATE_FORMATTER);
        date = getLocalTimestamp(simpleDateFormate.format(date), fromTimeZone, toTimeZone);
        return date;
    }

    public static Date getLocalTimestamp(String localDate, TimeZone fromTimeZone, TimeZone toTimeZone) {
        System.out.println("    input date = " + localDate + ", fromTimeZone = " + fromTimeZone.toZoneId() + "[" + LocalDateTime.now().atZone(fromTimeZone.toZoneId()).getOffset() + "], toTimeZone = " + toTimeZone.toZoneId() + "[" + LocalDateTime.now().atZone(toTimeZone.toZoneId()).getOffset() + "]");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.parse(localDate, dateTimeFormatter);
        ZonedDateTime fromZonedDateTime = localDateTime.atZone(fromTimeZone.toZoneId());
        ZonedDateTime toZonedDateTime = fromZonedDateTime.withZoneSameInstant(toTimeZone.toZoneId());
        String dateStr = toZonedDateTime.format(dateTimeFormatter);
        Date utcDate = null;
        try {
            utcDate = dateFormat.parse(dateStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println("converted date = " + utcDate);
        return utcDate;
    }

    public static TimeZone getZoneIdByName(String zoneName) {
        if (zoneName == null) {
            zoneName = "UTC";
        }
        if (zoneName.contains("GMT")) {
            zoneName = zoneName.split(" GMT")[0];
        }
        return TimeZone.getTimeZone(zoneName);
    }
}