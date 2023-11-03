package com.gl.Java2023Session97;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Sample {
    public static void main(String[] args) {
        // Convert Date from one ZoneId to UTC

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("----------------------------------------------------------");

        ZoneId defaultAsiaCalcuttaZoneId = ZoneId.systemDefault();
        System.out.println("defaultAsiaCalcuttaZoneId = " + defaultAsiaCalcuttaZoneId);
        System.out.println("----------------------------------------------------------");

        ZonedDateTime zonedDateTime = localDateTime.atZone(defaultAsiaCalcuttaZoneId);
        System.out.println("zonedDateTime = " + zonedDateTime);

        ZonedDateTime utcDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("utcDateTime1 = " + utcDateTime1);
        ZonedDateTime localDateTime1 = utcDateTime1.withZoneSameInstant(defaultAsiaCalcuttaZoneId);
        System.out.println("localDateTime1 = " + localDateTime1);
        System.out.println("----------------------------------------------------------");

        ZoneId fromAsiaSingaporeZoneId = ZoneId.of("Asia/Singapore");
        ZoneId toUTCZoneId = ZoneId.of("UTC");

        LocalDateTime localDateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = localDateTime2.atZone(fromAsiaSingaporeZoneId);
        System.out.println("zonedDateTime1 = " + zonedDateTime1);
        ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameInstant(toUTCZoneId);
        System.out.println("zonedDateTime2 = " + zonedDateTime2);
        ZonedDateTime zonedDateTime3 = zonedDateTime2.withZoneSameInstant(fromAsiaSingaporeZoneId);
        System.out.println("zonedDateTime3 = " + zonedDateTime3);
        System.out.println("----------------------------------------------------------");

        ZonedDateTime zonedDateTime4 = zonedDateTime3.withZoneSameInstant(defaultAsiaCalcuttaZoneId);
        System.out.println("zonedDateTime4 = " + zonedDateTime4);

        System.out.println("----------------------------------------------------------");
        ZoneId.getAvailableZoneIds().forEach(z->System.out.println("\t\t\t"+LocalDateTime.now().atZone(ZoneId.of(z)).getOffset()+"\t\t\t\t"+z));
        System.out.println("----------------------------------------------------------");
    }
}
