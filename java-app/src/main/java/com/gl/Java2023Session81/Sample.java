package com.gl.Java2023Session81;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {
        // Multi-threading
        // Asynchronous communication via Multi-threading
        // Synchronous communication via Signal-threaded or sequential programming model

        System.out.println("Main App is started by Thread: " + Thread.currentThread().getName());

        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        Thread producerThread = new Thread(producer, "producerThread");
        producerThread.start();
        //producerThread.run();

        Thread consumerThread = new Thread(consumer, "consumerThread");
        consumerThread.start();
        // consumerThread.run();

        System.out.println("Main App is still doing his own work by Thread: " + Thread.currentThread().getName());
        IntStream.range(1, 10)
                .forEach(n -> {
                    System.out.println("n = " + n + " printing by Thread: " + Thread.currentThread().getName());
                    ThreadSleep.sleep(Duration.ofSeconds(1));
                });
        System.out.println("Main App is completed by Thread: " + Thread.currentThread().getName());
    }
}

class Producer implements Runnable {
    Data data;

    public Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        int value = 100;
        while (true) {
            if (!data.flag) {
                data.setValue(value);
                System.out.println("Producer is produced the data(" + value + "), by Thread: " + Thread.currentThread().getName());
                data.flag = true;
                if (value >= 110) {
                    break;
                }
                value++;
            }
            ThreadSleep.sleep(Duration.ofSeconds(1));
        }
    }
}

class Consumer implements Runnable {
    Data data;

    public Consumer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            if (data.flag) {
                int value = data.getValue();
                System.out.println("Consumer is consumed the data(" + value + "), by Thread: " + Thread.currentThread().getName());
                data.flag = false;
                if (value >= 110) {
                    break;
                }
            }
            ThreadSleep.sleep(Duration.ofSeconds(1));
        }
    }
}

class Data {
    boolean flag;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}