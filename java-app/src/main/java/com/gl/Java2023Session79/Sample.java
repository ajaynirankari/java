package com.gl.Java2023Session79;

import java.time.Duration;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        // Java multi-threading
        System.out.println("main started by :" + Thread.currentThread().getName());

        Thread thread = new Thread(Sample::task1);
        thread.start();

        Thread thread1 = new Thread(Sample::task1);
        thread1.start();

        Thread.State state = thread1.getState();
        System.out.println("state = " + state);

        System.out.println("--------------- All Possible Java Thread States --------------------------");

        Arrays.stream(Thread.State.values())
                .toList()
                .forEach(d -> System.out.println(d.ordinal() + "\t" + d.name()));

        System.out.println("-------------------------------------------------------------");

        // What are the possible state of a Thread

        enum ThreadState {
            NEW,             // ---- Ready to Run
            RUNNABLE,        // ---- Running
            BLOCKED,         // ---- Not runnable, Waiting until other thread released object lock
            WAITING,         // ---- Not runnable, Waiting until other thread notify, notifyAll
            TIMED_WAITING,   // ---- Not runnable, Waiting until time is not completed
            TERMINATED       // ---- Terminated or Dead or stop
        }

        final String MONDAY = "Monday";
        final String TUESDAY = "Tuesday";
        final String WEDNESDAY = "Wednesday";
        final String THURSDAY = "Thursday";
        final String FRIDAY = "Friday";
        final String SATURDAY = "Saturday";
        final String SUNDAY = "Sunday";

        enum Week {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
        System.out.println(Week.MONDAY);
        Week tuesdayObject = Week.TUESDAY;
        System.out.println("tuesdayObject = " + tuesdayObject);
        System.out.println("tuesdayObject.name() = " + tuesdayObject.name());
        System.out.println("tuesdayObject.ordinal() = " + tuesdayObject.ordinal());
        System.out.println("-------------------------------------------------------------");

        Arrays.stream(Week.values())
                .toList()
                .forEach(d -> System.out.println(d.ordinal() + "\t" + d.name()));
        System.out.println("-------------------------------------------------------------");

        enum WeekN {
            MONDAY("Mon"), TUESDAY("Tue"), WEDNESDAY("Wed"), THURSDAY("Thu"), FRIDAY("Fri"), SATURDAY("Sat"), SUNDAY("Sun");

            final String shotName;

            WeekN(String s) {
                shotName = s;
            }
        }

        Arrays.stream(WeekN.values())
                .toList()
                .forEach(d -> System.out.println(d.ordinal() + "\t" + d.name() + "\t\t\t\t ShortName\t:\t" + d.shotName));
        System.out.println("-------------------------------------------------------------");

        // Thread safe object means the immutable object
        // All the objects of enum is thread safe object

        enum Direction {NORTH, SOUTH, EAST, WEST}

        Arrays.stream(Direction.values())
                .toList()
                .forEach(d -> System.out.println(d.ordinal() + "\t" + d.name()));
        System.out.println("-------------------------------------------------------------");

        System.out.println("main completed by :" + Thread.currentThread().getName());
    }

    static void task1() {
        System.out.println("task1 executed by :" + Thread.currentThread().getName());
        sleep(2);
        System.out.println("task2 executed by :" + Thread.currentThread().getName());
        sleep(1);
        System.out.println("task3 executed by :" + Thread.currentThread().getName());
        sleep(3);
        System.out.println("task4 executed by :" + Thread.currentThread().getName());
        sleep(1);
    }

    static void sleep(long t) {
        try {
            Thread.sleep(Duration.ofSeconds(t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
