package com.gl.Java2023Session76;

import java.time.Duration;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started ... " + Thread.currentThread().getName());

        Thread thread1 = new Thread(Sample::evenNumber);
        thread1.start();
        System.out.println("---------thread1 started()-----------------by ... " + Thread.currentThread().getName());

        System.out.println("waiting of thread1 is to completed by ... " + Thread.currentThread().getName());
        thread1.join();
        System.out.println("thread1 completed by ... " + Thread.currentThread().getName());

        Thread thread2 = new Thread(Sample::oddNumber);
        thread2.start();
        System.out.println("---------thread2 started()-----------------by ... " + Thread.currentThread().getName());

        System.out.println("waiting of thread2 is to completed ... " + Thread.currentThread().getName());
        thread2.join();
        System.out.println("thread2 completed ... " + Thread.currentThread().getName());

        System.out.println("-----------------------thread1.isAlive() = " + thread1.isAlive());
        System.out.println("------------------------thread2.isAlive() = " + thread2.isAlive());

        System.out.println("Main completed ... " + Thread.currentThread().getName());

    }

    static void oddNumber() {
        // can be done using for loop
        // can be done using while loop
        // can be done using stream API
        IntStream.range(1, 20)
                .filter(i -> i % 2 != 0)
                .forEach(i -> {
                    System.out.println("Odd Number: " + i + ", printed by: " + Thread.currentThread().getName());
                    Sample.sleep(2);
                    System.out.println("------------- waiting thread name: " + Thread.currentThread().getName());
                });

    }

    static void evenNumber() {
        // can be done using for loop
        // can be done using while loop
        // can be done using stream API
        IntStream.range(1, 20)
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println("Even Number: " + i + ", printed by: " + Thread.currentThread().getName()));

    }

    static void sleep(long t) {
        try {
            Thread.sleep(Duration.ofSeconds(t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
