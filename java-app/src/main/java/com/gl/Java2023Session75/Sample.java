package com.gl.Java2023Session75;

public class Sample {
    public static void main(String[] args) {
        // Different programming model
        // 1 - multi-threading programming
        // 2 - concurrency programming / processing (multi-threading)
        // 3 - parallel programming / processing    (multitasking supported OS)

        // Parallel vs Concurrency (multi-threading)

        // How to create thread ?
        // 1. approach - by extends Thread class, means inheritance

        System.out.println("main start printed by: " + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        //myThread.run();
        myThread.start();
        //myThread.start(); // Not allow to start the thread again
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        MyThread myThread2 = new MyThread();
        myThread2.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        MyThread myThread3 = new MyThread();
        myThread3.start();

        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        // 2. approach to create Thread - by implements Runnable interface

        //Runnable runnable = new Runnable(); // Can not create an object of interface
        //runnable.run();

        // Runnable is a FunctionalInterface, can be implemented by the following way
        // 1. by Implementation class
        // 2. by Anonymous class
        // 3. by Lambda expression
        // 4. by Method reference

        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("---------MyRunnable thread going to start--------- " + Thread.currentThread().getName());
                Sample.processMessage(5);
                System.out.println("---------MyRunnable going to stop--------- " + Thread.currentThread().getName());
            }
        }

        MyRunnable myRunnableTask = new MyRunnable();
        Thread thread1 = new Thread(myRunnableTask);
        thread1.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Runnable runnableByAnonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("---------runnableByAnonymous thread going to start--------- " + Thread.currentThread().getName());
                Sample.processMessage(5);
                System.out.println("---------runnableByAnonymous going to stop--------- " + Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread(runnableByAnonymous);
        thread2.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("---------runnableByAnonymous thread going to start--------- " + Thread.currentThread().getName());
                Sample.processMessage(5);
                System.out.println("---------runnableByAnonymous going to stop--------- " + Thread.currentThread().getName());
            }
        });
        thread3.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread4 = new Thread(() -> {
            System.out.println("---------Lambda expression thread going to start--------- " + Thread.currentThread().getName());
            Sample.processMessage(5);
            System.out.println("---------Lambda expression going to stop--------- " + Thread.currentThread().getName());
        });
        thread4.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread5 = new Thread(() -> System.out.println("Lambda expression by " + Thread.currentThread().getName()));
        thread5.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread6 = new Thread(() -> Sample.processMessage(5));
        thread6.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread7 = new Thread(Sample::processMessageMethod);
        thread7.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread8 = new Thread(Sample::methodRunInSeparateThread);
        thread8.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        Thread thread9 = new Thread(Sample::methodRunInSeparateThread);
        thread9.start();
        System.out.println("------------------------- by: " + Thread.currentThread().getName());

        System.out.println("main done printed by: " + Thread.currentThread().getName());
    }

    static void methodRunInSeparateThread() {
        System.out.println("anyMethodName 1 printed by: " + Thread.currentThread().getName());
        System.out.println("anyMethodName 2 printed by: " + Thread.currentThread().getName());
        System.out.println("anyMethodName 3 printed by: " + Thread.currentThread().getName());
    }

    static void processMessage(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Message " + i + ", processed by :" + Thread.currentThread().getName());
        }
    }

    static void processMessageMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Message " + i + ", processed by :" + Thread.currentThread().getName());
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        Sample.processMessage(5);
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        Sample.processMessage(5);
    }
}