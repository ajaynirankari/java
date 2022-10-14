package com.gl.VirtualThread;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(" Task1 thread - " + Thread.currentThread());
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println(" Task1 thread - " + Thread.currentThread());
                } catch (InterruptedException e) {
                }

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(runnable);
        executorService.shutdown();

        Thread vThread = Thread.ofVirtual().unstarted(runnable);
        vThread.start();
        vThread.join();

        Thread pThread = Thread.ofPlatform().unstarted(runnable);
        pThread.start();
        pThread.join();


        List<Thread> pThreads = IntStream.range(0, 100)
                .mapToObj(i ->
                        {
                            Thread thread_ = Thread.ofPlatform().unstarted(() -> {
                                try {
                                    if (i == 0) {
                                        System.out.println("Before = " + Thread.currentThread());
                                    }
                                    Thread.sleep(Duration.ofSeconds(2));
                                    if (i == 0) {
                                        System.out.println("After = " + Thread.currentThread());
                                    }
                                } catch (InterruptedException e) {
                                }
                            });

                            return thread_;
                        }
                ).toList();

        pThreads.forEach(Thread::start);
        for (Thread t : pThreads) {
            t.join();
        }

        List<Thread> vThreads = IntStream.range(0, 100)
                .mapToObj(i ->
                        {
                            Thread thread_ = Thread.ofVirtual().unstarted(() -> {
                                try {
                                    if (i == 0) {
                                        System.out.println("Before = " + Thread.currentThread());
                                    }
                                    Thread.sleep(Duration.ofSeconds(2));
                                    if (i == 0) {
                                        System.out.println("After = " + Thread.currentThread());
                                    }
                                } catch (InterruptedException e) {
                                }
                            });

                            return thread_;
                        }
                ).toList();

        vThreads.forEach(Thread::start);
        for (Thread t : vThreads) {
            t.join();
        }

    }
}
