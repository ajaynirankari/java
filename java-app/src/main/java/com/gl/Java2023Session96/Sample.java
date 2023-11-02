package com.gl.Java2023Session96;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Sample {
    public static void main(String[] args) {
        // Date & Time API
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        System.out.println("-----------------------------------------------------------------------------------------");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM/yyyy/dd");
        String formatDate = localDate.format(dateTimeFormatter);
        System.out.println("formatDate = " + formatDate);
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMMM yyyy dd")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd / MMMM / yyyy ")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMMM, dd yyyy ")));
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println("-----------------------------------------------------------------------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MMM yyyy dd hh:mm a");
        System.out.println(localDateTime.format(pattern));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("MMMM yyyy dd hh:mm a")));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy hh:mm a")));
        System.out.println("-----------------------------------------------------------------------------------------");

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);
        System.out.println("offsetDateTime = " + offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE));
        System.out.println("offsetDateTime = " + offsetDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(offsetDateTime.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy hh:mm a")));
        System.out.println("-----------------------------------------------------------------------------------------");

        // DateTimeFormatter is thread-safe class
        DateTimeFormatter dateTimeFormatter1;
        // SimpleDateFormat is not thread-safe class
        SimpleDateFormat simpleDateFormat;

        // Prefer use DateTimeFormatter class over SimpleDateFormat class;

        // ZoneId  - Region/City    (Asia/Calcutta)
        // OffSet  - Hours:Minutes  (+05:30)

        // OffSet           ZoneId
        //-----------------------------------
        // +05:30			Asia/Calcutta
        // -07:00			America/Los_Angeles
        // -04:00			America/Toronto
        // -04:00			America/New_York
        // +10:00			Australia/Brisbane
        // +11:00			Australia/Canberra
        // -06:00			Canada/Mountain
        //-----------------------------------

        System.out.println("-----------------------------------------------------------------------------------------");

        LocalDateTime ldt = LocalDateTime.now();

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        for (String zone : availableZoneIds) {
            ZonedDateTime zonedDateTime = ldt.atZone(ZoneId.of(zone));
            ZoneOffset offset = zonedDateTime.getOffset();
            System.out.println("\t\t" + offset + "\t\t\t" + zone);
        }
        System.out.println("availableZoneIds.size() = " + availableZoneIds.size());
        System.out.println("-----------------------------------------------------------------------------------------");

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("localDateTime1 = " + localDateTime1);

        Instant utc = Instant.now();
        System.out.println("utc = " + utc);
        System.out.println("-----------------------------------------------------------------------------------------");

        LocalDateTime dateTime = LocalDateTime.of(2022, Month.APRIL, 24, 20, 12, 8);
        System.out.println("dateTime = " + dateTime);

        Instant instant = dateTime.toInstant(ZoneOffset.UTC);
        System.out.println("instant = " + instant);
        System.out.println("-----------------------------------------------------------------------------------------");

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);

        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        System.out.println("offsetDateTime1 = " + offsetDateTime1);
        System.out.println("-----------------------------------------------------------------------------------------");

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(zonedDateTime.toLocalDateTime(), ZoneOffset.UTC);
        System.out.println("zonedDateTime1 = " + zonedDateTime1.toInstant());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC).toInstant());
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+08:00")));
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+08:00")).toInstant());
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-07:00")));
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-07:00")).toInstant());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Singapore")));
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Singapore")).toInstant());
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York")));
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York")).toInstant());
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant());
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}

class Transaction {
    Instant startAt;
    Instant completionAt;
}