package com.gl.Java2023Session83;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {
        // Multi-threading
        // For thread communication
        // we can use the following
        //  for getting a lock - synchronized Keyword
        //  for waiting  - wait()
        //  for informing  - notify()

        // Lock as an interface

        System.out.println("Main started ...");

        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer), "ProducerThread").start();
        new Thread(new Consumer(buffer), "ConsumerThread").start();

        // lock is an interface vs synchronized is keyword
        // Virtual thread is not worked on synchronized lock

        // boolean isLocked = lock.tryLock();
        // isLocked == true ->  you got the lock & go use the object
        // isLocked == false ->  you Are NOT got the lock & wait to get lock, or go back if you do not to wait
        // boolean b = lock.tryLock(5, TimeUnit.MINUTES);

        System.out.println("Main completed ...");
    }
}

class Producer implements Runnable {
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        IntStream.range(1, 10)
                .forEach(n -> {
                    String message = " message " + n;
                    try {
                        buffer.produceMessage(message);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ThreadSleep.sleep(Duration.ofSeconds(2));
                });
    }
}

class Consumer implements Runnable {
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        IntStream.range(1, 10)
                .forEach(n -> {
                    try {
                        buffer.consumeMessage();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

class Buffer {
    private final List<String> data = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void produceMessage(String msg) throws InterruptedException {
        lock.lock();
        while (data.size() == 1) {
            condition.await();
        }

        data.add(msg);
        System.out.println("Message: " + msg + ", produced by: " + Thread.currentThread().getName());
        condition.signalAll();
        lock.unlock();
    }

    public void consumeMessage() throws InterruptedException {
        lock.lock();
        while (data.isEmpty()) {
            condition.await();
        }

        String msg = data.remove(0);
        System.out.println("Message: " + msg + ", consumed by: " + Thread.currentThread().getName());
        condition.signalAll();
        lock.unlock();
    }
}
