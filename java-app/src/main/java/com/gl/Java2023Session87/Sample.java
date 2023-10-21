package com.gl.Java2023Session87;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample {
    public static void main(String[] args) {
        // There are 9 ways to create Thread
        // 1. extends Thread class
        // 2. implements Runnable interface
        // 3. Anonymous class
        // 4. Lambda expression
        // 5. Method reference
        // 6. Executor services
        // 7. implements Callable interface
        // 8. Completable Future
        // 9. Virtual Thread

        System.out.println("------------------------------------------------------");
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("MyThread extends Thread Code is executed by Thread " + Thread.currentThread().getName());
            }
        }
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("------------------------------------------------------");

        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("MyRunnable implements Runnable Code is executed by Thread " + Thread.currentThread().getName());
            }
        }
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        System.out.println("------------------------------------------------------");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Code is executed by Thread " + Thread.currentThread().getName());
            }
        };
        new Thread(runnable).start();
        System.out.println("------------------------------------------------------");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Anonymous Code is executed by Thread " + Thread.currentThread().getName());
            }
        }).start();
        System.out.println("------------------------------------------------------");

        new Thread(() -> {
            System.out.println("Lambda expression Code is executed by Thread " + Thread.currentThread().getName());
        }).start();
        System.out.println("------------------------------------------------------");

        new Thread(Sample::myProcess).start();

        System.out.println("------------------------------------------------------");

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            executorService.submit(Sample::myProcess);
            executorService.submit(() -> {
                System.out.println("Lambda expression Code is executed by Thread " + Thread.currentThread().getName());
            });
            executorService.submit(runnable);
            executorService.submit(myRunnable);
            executorService.submit(myThread);
        }
        System.out.println("------------------------------------------------------");

        // Callable is a @FunctionalInterface
        // it can be implement as a following
        // 1. implementation class
        // 2. anonymous class
        // 3. Lambda expression
        // 4. Method reference

        class MyCallable implements Callable<String> {

            @Override
            public String call() throws Exception {
                return "Hello return value from call() " + Thread.currentThread().getName();
            }
        }
        System.out.println("------------------------------------------------------");

        Callable<Integer> integerCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 105;
            }
        };
        System.out.println("------------------------------------------------------");

        MyCallable myCallable = new MyCallable();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            Future<String> future = executorService.submit(myCallable);
            String resultValueFromThread = future.get();
            System.out.println("resultValueFromThread = " + resultValueFromThread);

            Future<Integer> future1 = executorService.submit(integerCallable);
            Integer intVale = future1.get();
            System.out.println("intVale = " + intVale);

            Future<Integer> future2 = executorService.submit(() -> {
                System.out.println("Executing callable from lambda expression " + Thread.currentThread().getName());
                return 45;
            });

            Integer lambdaExpressionValue = future2.get();
            System.out.println("lambdaExpressionValue = " + lambdaExpressionValue);

            Future<Double> future3 = executorService.submit(Sample::myProcessCal);
            Double returnDoubleValue = future3.get();
            System.out.println("returnDoubleValue = " + returnDoubleValue);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------------------------------------");

        System.out.println("Main completed ..." + Thread.currentThread().getName());
    }

    static void myProcess() {
        System.out.println("Method Reference myProcess Code is executed by Thread " + Thread.currentThread().getName());
    }

    static double myProcessCal() {
        System.out.println("Method Reference myProcessCal Code is executed by Thread " + Thread.currentThread().getName());
        return 45.6;
    }
}