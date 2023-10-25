package com.gl.Java2023Session90;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) {
        job();
        job();
        job();
        System.out.println("------------------------------------------------------------");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                job();
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 2000);
        System.out.println("------------------------------------------------------------");

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(Sample::job, 1, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(Sample::job, 1, 1, TimeUnit.SECONDS);

        System.out.println("------------------------------------------------------------");

        ThreadSleep.sleep(Duration.ofSeconds(5));
        scheduledExecutorService.shutdownNow();
        System.out.println("------------------------------------------------------------");
    }

    static void job() {
        System.out.println("Time: " + Instant.now() + " at job executed by: " + Thread.currentThread().getName());
        ThreadSleep.sleep(Duration.ofSeconds(new Random().nextInt(5)));
        System.out.println("Time: " + Instant.now() + " at job execution completed by: " + Thread.currentThread().getName());
    }
}