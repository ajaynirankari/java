package com.gl.Java2023Session85;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("App is started by : " + Thread.currentThread().getName());

        Worker worker = new Worker();
        System.out.println("App is starting three threads by : " + Thread.currentThread().getName());

        Thread thread1 = new Thread(worker);
        thread1.start();
        Thread thread2 = new Thread(worker);
        thread2.start();
        Thread thread3 = new Thread(worker);
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("App waiting of thread1,2,3 is completed by : " + Thread.currentThread().getName());

        CountDownLatch countDownLatch = new CountDownLatch(5);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("taskExecutor is started our own work 0 by: " + Thread.currentThread().getName());
                System.out.println("taskExecutor is waiting of to completion of other (" + countDownLatch.getCount() + ") threads, by: " + Thread.currentThread().getName());
                countDownLatch.await();
                System.out.println("taskExecutor is started our own work 1 by: " + Thread.currentThread().getName());
                System.out.println("taskExecutor is started our own work 2 by: " + Thread.currentThread().getName());
                System.out.println("taskExecutor is started our own work 3 by: " + Thread.currentThread().getName());
                System.out.println("taskExecutor is started our own work 4 by: " + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();

        System.out.println("App is going to do his own work by : " + Thread.currentThread().getName());

        TaskExecutor taskExecutor = new TaskExecutor(countDownLatch);
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            IntStream.rangeClosed(1, 5).forEach(i -> executorService.submit(taskExecutor));
        }
        System.out.println("App is again going to do his own work by : " + Thread.currentThread().getName());
        System.out.println("App is go to wait of t1 thread by : " + Thread.currentThread().getName());
        t1.join();

        System.out.println("App is completed by : " + Thread.currentThread().getName());
    }
}

class TaskExecutor implements Runnable {
    CountDownLatch countDownLatch;

    public TaskExecutor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        IntStream.range(1, 5)
                .forEach(i -> {
                    System.out.println("TaskExecutor completed instruction_" + i + ". by :" + Thread.currentThread().getName());
                    ThreadSleep.sleep(Duration.ofSeconds(1));
                });
        countDownLatch.countDown();
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        IntStream.range(1, 5)
                .forEach(i -> {
                    System.out.println("Worker completed instruction_" + i + ". by :" + Thread.currentThread().getName());
                    ThreadSleep.sleep(Duration.ofSeconds(1));
                });
    }
}
