package com.gl.JavaSession02;

import java.util.concurrent.*;

public class Sample {
    public static void main(String[] args) throws Exception {
        System.out.println("Start main " + Thread.currentThread());
        method1();
        method2();

        Thread thread = new Thread();
        MyThreadClass myThreadClass = new MyThreadClass("MyThread-1");
        myThreadClass.start();
        myThreadClass.run();

        MyRunnable runnable = new MyRunnable();
        Thread threadR = new Thread(runnable);
        threadR.start();

        Thread threadA = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Runnable Anonymous run() is executing ..." + i + " " + Thread.currentThread());
                            Sample.sleep(i * 1000);
                        }
                    }
                }
        );
        threadA.start();

        Thread thread_ = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Runnable Lambda Expression run() is executing ..." + i + " " + Thread.currentThread());
                        Sample.sleep(i * 1000);
                    }
                }
        );
        thread_.start();

        Thread thread0 = new Thread(Sample::method1);
        thread0.start();
        Thread thread1 = new Thread(Sample::method2);
        thread1.start();
        Thread thread2 = new Thread(Sample::method3);
        thread2.start();

        MyCallable myCallable = new MyCallable();
        //Thread thread = new Thread(myCallable); NOT Allowed

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(myCallable);
        String result = future.get();
        System.out.println("result = " + result);
        executorService.shutdown();

        String result1 = Executors.newCachedThreadPool().submit(Sample::method3).get();
        System.out.println("result1 = " + result1);

        Integer integer = Executors.newCachedThreadPool().submit(
                () -> {
                    System.out.println("Code executed from Lambda Expression by ..." + Thread.currentThread());
                    return 123;
                }
        ).get();
        System.out.println("integer = " + integer);

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread());
            method3();
            return 34;
        }).get();

        CompletableFuture.supplyAsync(Sample::method3).get();

        System.out.println("End main " + Thread.currentThread());
    }

    static String method3() {
        System.out.println("method3..." + Thread.currentThread());
        return "Hello ..." + Thread.currentThread();
    }

    static void method1() {
        for (int i = 1; i < 5; i++) {
            System.out.println("method1() is executing ..." + i + " " + Thread.currentThread());
            sleep(i * 1000);

        }
    }

    static void method2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("method2() is executing ..." + i + " " + Thread.currentThread());
            sleep(i * 1000);
        }
    }

    static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyRunnable run() is executing ..." + i + " " + Thread.currentThread());
            Sample.sleep(i * 1000);
        }
    }
}


class MyThreadClass extends Thread {
    MyThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThreadClass run() is executing ..." + i + " " + Thread.currentThread());
            Sample.sleep(i * 1000);
        }
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Return value from Callable " + Thread.currentThread();
    }
}
