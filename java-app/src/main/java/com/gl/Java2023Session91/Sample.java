package com.gl.Java2023Session91;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    public static void main(String[] args) throws Exception {
        // Type of Thread
        // 1. Platform Thread or OS Thread
        // 2. Virtual Thread or Java Thread

        Thread thread = Thread.startVirtualThread(Sample::myTask);
        thread.join();
        System.out.println("------------------------------------------------------------");

        Thread thread1 = Thread.ofVirtual().start(Sample::myTask);
        thread1.join();
        System.out.println("------------------------------------------------------------");

        Thread unstarted = Thread.ofVirtual().unstarted(Sample::myTask);
        unstarted.start();
        unstarted.join();
        System.out.println("------------------------------------------------------------");

        Thread.Builder.OfVirtual ofVirtual1 = Thread.ofVirtual();
        Thread unstarted1 = ofVirtual1.unstarted(Sample::myTask);
        unstarted1.start();
        unstarted1.join();
        System.out.println("------------------------------------------------------------");

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(Sample::myTask);
            executorService.submit(Sample::myTask);
            executorService.submit(Sample::myTask);
            executorService.submit(Sample::myTask);
        }

        // Never do pool of virtual threads.
        // if possible do not use synchronized keyword, use Reentrant Lock
        // Lets the Lock interface for locking

        Thread.Builder.OfVirtual ofVirtual = Thread.ofVirtual();
        Thread.Builder.OfPlatform ofPlatform = Thread.ofPlatform();

        System.out.println("main completed by: Thread Id:"+Thread.currentThread().threadId());
    }

    static void myTask() {
        System.out.println("myTask executed ....executed by: Thread Id:"+Thread.currentThread().threadId());
        ThreadSleep.sleep(Duration.ofSeconds(new Random().nextInt(5)));
        System.out.println("myTask completed ....executed by: Thread Id:"+Thread.currentThread().threadId());
    }
}
