package com.gl.jdk19;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class VirtualThreadDemo {
    static int counter=0;
    public static void main(String[] args) throws Exception {
/*
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.rangeClosed(0, 10)
                    .forEach(i -> {
                        executor.submit(() -> {
                            System.out.println(i+")---> Thread.currentThread().threadId() = " + Thread.currentThread());
                            Thread.sleep(Duration.ofSeconds(1));
                            return i;
                        });
                    });
        }

        Thread thread = Thread.startVirtualThread(() -> {
            System.out.println("Thread.currentThread() = " + Thread.currentThread());
        });

        Thread pThread = Thread.ofPlatform()
                .unstarted(() -> System.out.println("ofPlatform Thread.currentThread() = " + Thread.currentThread()));
        pThread.start();
        pThread.join();

        Thread vThread = Thread.ofVirtual()
                .unstarted(() -> System.out.println("ofVirtual Thread.currentThread() = " + Thread.currentThread()));
        vThread.start();
        vThread.join();
        System.out.println("vThread = " + vThread.getClass());

        ForkJoinTask<?> forkJoinTask = ForkJoinPool.commonPool().submit(() -> System.out.println("ForkJoinPool Thread.currentThread() = " + Thread.currentThread()));
        forkJoinTask.join();
*/
        //final Integer[] counter = {0};
        //Object lock = new Object();
        ReentrantLock lock = new ReentrantLock();
        List<Thread> threads = IntStream.range(0, 5)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    if (i == 0) {
                        System.out.println("Started Thread.currentThread() = " + Thread.currentThread());
                    }
                    //synchronized (lock) {
                      lock.lock();
                        try {
                            Thread.sleep(Duration.ofSeconds(1));
                            counter++;
                        } catch (Exception e) {
                        }finally {
                            lock.unlock();
                        }
                    //}

                    if (i == 0) {
                        System.out.println("Completed Thread.currentThread() = " + Thread.currentThread());
                    }
                    //synchronized (lock) {
                    lock.lock();
                        try {
                            Thread.sleep(Duration.ofSeconds(1));
                            counter++;
                        } catch (Exception e) {
                        }finally {
                            lock.unlock();
                    }
                })).toList();

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        synchronized (lock) {
            System.out.println("counter = " + counter);
        }

    }
}
