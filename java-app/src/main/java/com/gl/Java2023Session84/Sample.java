package com.gl.Java2023Session84;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        System.out.println("Started ... " + Thread.currentThread().getName());

        Semaphore semaphore = new Semaphore(3, true);
        Worker worker = new Worker(semaphore);

        try (ExecutorService executorService = Executors.newFixedThreadPool(6)) {
            IntStream.range(1, 10).forEach(i -> executorService.submit(worker));
        }

        IntStream.range(1, 10).forEach(i -> new Thread(worker).start());

        System.out.println("Completed ... " + Thread.currentThread().getName());
    }
}

class Worker implements Runnable {
    private final Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("semaphore.availablePermits = " + semaphore.availablePermits() + " by: " + Thread.currentThread().getName());

        try {
            semaphore.acquire();

            //boolean b = semaphore.tryAcquire();
            //boolean b1 = semaphore.tryAcquire(2, TimeUnit.SECONDS);

            for (int i = 1; i <= 3; i++) {
                int d = i + i;
                System.out.println("Number (" + i + ") double it (" + d + ") done by: " + Thread.currentThread().getName());
                ThreadSleep.sleep(Duration.ofSeconds(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
