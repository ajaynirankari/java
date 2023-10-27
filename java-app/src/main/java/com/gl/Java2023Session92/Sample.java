package com.gl.Java2023Session92;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        // Java Virtual Thread
        // Java Thread-safe collection
        // BlockingQueue is thread-safe collection
        // BlockingQueue is an interface
        // BlockingQueue can be two form
        //              - Bounded Queue means set initial capacity
        //              - UnBounded Queue means NOT set any initial capacity

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        BlockingQueue<Integer> boundedQueue = new ArrayBlockingQueue<>(5);
        BlockingQueue<Integer> unBoundedQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> unBoundedQueueWithCapacity = new LinkedBlockingQueue<>(10);
        System.out.println("----------------------------------------------------");

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        System.out.println("queue = " + queue);
        //queue.put(null);
        //System.out.println("second queue.take() = " + queue.take());
        queue.put(23);
        System.out.println("queue = " + queue);
        //queue.put(24);
        System.out.println("first queue.take() = " + queue.take());
        System.out.println("queue = " + queue);
        //System.out.println("second queue.take() = " + queue.take());
        System.out.println("queue = " + queue);
        System.out.println("----------------------------------------------------");

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        Thread.ofVirtual().name("Produce").start(producer);
        Thread.ofVirtual().name("Consumer").start(consumer);
        System.out.println("----------------------------------------------------");

        //Thread.ofVirtual().start(producer).join();
        //Thread.ofVirtual().start(consumer).join();

        System.out.println("Main is waiting");
        ThreadSleep.sleep(Duration.ofSeconds(15));
        System.out.println("Main is done");
        System.out.println("----------------------------------------------------");
    }
}

class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + ", threadId: " + Thread.currentThread().threadId());
        IntStream.rangeClosed(1, 10).forEach(n -> {
            try {
                System.out.println("produced number = " + n);
                queue.put(n);
                ThreadSleep.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + ", threadId: " + Thread.currentThread().threadId());
        IntStream.rangeClosed(1, 10).forEach(n -> {
            try {
                System.out.println("consumed number = " + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}