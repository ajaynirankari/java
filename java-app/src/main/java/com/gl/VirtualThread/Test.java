package com.gl.VirtualThread;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("main Thread - " + Thread.currentThread());
        Thread thread = new Thread(Test::runnableTask);
        thread.start();
        thread.join();

        Thread vThread = Thread.ofVirtual().unstarted(Test::runnableTask);
        vThread.start();
        vThread.join();

        Thread pThread = Thread.ofPlatform().unstarted(Test::runnableTask);
        pThread.start();
        pThread.join();

        Thread vThread1 = Thread.ofVirtual().start(Test::runnableTask);
        vThread1.join();


        Thread vThread2 = Thread.startVirtualThread(Test::runnableTask);
        vThread2.join();

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(Test::runnableTask);
        executor.shutdown();


        List<Thread> threadList = IntStream.range(0, 1000)
                .mapToObj(i -> {
                    return Thread.ofVirtual().unstarted(() -> {
                        try {
                            if (i == 0) {
                                System.out.println(i+") Task running = " + Thread.currentThread());
                            }
                            Thread.sleep(Duration.ofSeconds(2));
                            if (i == 0) {
                                System.out.println(i+") Task running = " + Thread.currentThread());
                            }
                        } catch (Exception e) {
                        }
                    });
                }).toList();

        threadList.forEach(Thread::start);
        for (Thread t : threadList) {
            t.join();
        }

        System.out.println("main Thread - " + Thread.currentThread());

    }

    static void runnableTask() {
        System.out.println("Start runnableTask Thread - " + Thread.currentThread());
        System.out.println("Running business logic ....");
        System.out.println("Running business logic ....");
        System.out.println("End runnableTask Thread - " + Thread.currentThread());
    }
}
