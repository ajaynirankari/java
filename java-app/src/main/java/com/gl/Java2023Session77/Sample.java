package com.gl.Java2023Session77;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Multi-threading
        // 1. extends from Thread
        // 2. implements Runnable interface
        // 3. Executor service

        System.out.println("Main Line 1 is executed by :" + Thread.currentThread().getName());

        Runnable task = () -> System.out.println("my task executed by :" + Thread.currentThread().getName());

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        Thread thread1 = new Thread(Sample::myTask);
        thread1.start();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        Thread thread2 = new Thread(Sample::myTask1);
        thread2.start();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        Thread thread3 = new Thread(Sample::myTask2);
        thread3.start();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(task);
        executor.execute(Sample::myTask);
        executor.execute(Sample::myTask1);
        executor.execute(Sample::myTask2);
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(task);
        executorService.submit(Sample::myTask);
        executorService.submit(Sample::myTask1);
        executorService.submit(Sample::myTask2);
        executorService.submit(Sample::myTask);
        executorService.submit(Sample::myTask1);
        executorService.submit(Sample::myTask2);

        executorService.shutdown();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        int calculate = calculate();
        System.out.println("calculate = " + calculate);
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        Callable<String> callableTask = () -> {
            System.out.println("CallableTask Hello executed by: " + Thread.currentThread().getName());
            return "Callable return value as Hello";
        };

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);

        Future<Integer> future = executorService1.submit(Sample::calculate);
        System.out.println("main got future object= " + future);
        Future<String> future1 = executorService1.submit(callableTask);
        System.out.println("main got future1 object= " + future1);

        System.out.println("main call future.get() ");
        Integer cal = future.get();
        System.out.println("calculate value = " + cal + " received by:  " + Thread.currentThread().getName());

        String string = future1.get();
        System.out.println("string = " + string);

        executorService1.shutdownNow();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        try (ExecutorService executorService2 = Executors.newFixedThreadPool(3)) {
            executorService2.submit(Sample::notReturnValue);
            executorService2.submit(Sample::myTask);
            executorService2.submit(Sample::myTask2);
            executorService2.submit(callableTask);
        }
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        myTask();
        myTask2();
        System.out.println("---------------------------------------------------------------- by: " + Thread.currentThread().getName());

        System.out.println("Main completed is executed by :" + Thread.currentThread().getName());
    }

    static void myTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ") Method myTask() executed by :" + Thread.currentThread().getName());
        }
    }

    static void myTask1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ") Method myTask1() executed by :" + Thread.currentThread().getName());
        }
    }

    static void myTask2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ") Method myTask2() executed by :" + Thread.currentThread().getName());
        }
    }


    static int calculate() throws InterruptedException {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ") Method calculate() executed by :" + Thread.currentThread().getName());
            sum = sum + i;
            Thread.sleep(Duration.ofSeconds(i));
        }

        System.out.println("calculate value = " + sum + " return by :" + Thread.currentThread().getName());
        return sum;
    }

    static void notReturnValue() {
        System.out.println("notReturnValue executed by :" + Thread.currentThread().getName());
    }

}
