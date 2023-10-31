package com.gl.Java2023Session94;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        // Thread Pool via

        ExecutorService executorService_;

        Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool();
        Executors.newSingleThreadScheduledExecutor();
        Executors.newVirtualThreadPerTaskExecutor();

        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            IntStream.rangeClosed(1, 100)
                    .forEach(i -> {
                        executorService.submit(Sample::myTask);
                        executorService.submit(Sample::myTask1);
                    });
        }

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            IntStream.rangeClosed(1, 100)
                    .forEach(i -> {
                        executorService.submit(Sample::myTask);
                        executorService.submit(Sample::myTask1);
                    });
        }

        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            IntStream.rangeClosed(1, 100)
                    .forEach(i -> {
                        executorService.submit(Sample::myTask);
                        executorService.submit(Sample::myTask1);
                    });
        }

        try (ExecutorService executorService = Executors.newWorkStealingPool()) {
            IntStream.rangeClosed(1, 100)
                    .forEach(i -> {
                        executorService.submit(Sample::myTask);
                        executorService.submit(Sample::myTask1);
                    });
        }

        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        scheduled.scheduleAtFixedRate(Sample::myTask, 1, 1, TimeUnit.MINUTES);

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.rangeClosed(1, 10000)
                    .forEach(i -> {
                        executorService.submit(Sample::myTask);
                        executorService.submit(Sample::myTask1);
                    });
        }

        myTask();
        myTask1();

    }

    static void myTask() {
        System.out.println("Line 1");
    }

    static void myTask1() {
        System.out.println("Line 1");
    }
}
