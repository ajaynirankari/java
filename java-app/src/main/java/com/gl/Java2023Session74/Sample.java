package com.gl.Java2023Session74;

public class Sample {
    public static void main(String[] args) {

        System.out.println("start Line 1: " + Thread.currentThread().getName());
        anotherMethod1();
        System.out.println("main Line 2: " + Thread.currentThread().getName());
        anotherMethod2();


        Thread thread; // Thread is class
        Runnable runnable; // Runnable is an interface, Thread class implement Runnable interface.

        System.out.println("main starting new thread Line 3: " + Thread.currentThread().getName());

        MyThread thread1 = new MyThread("MyOwnThread");
        thread1.start(); // --> start are internally call run method on Runnable interface
        //thread1.run(); // --> do not call run method manually if you want run is executed by separate thread

        System.out.println("main Line 4: " + Thread.currentThread().getName());
        System.out.println("main Line 5: " + Thread.currentThread().getName());

    }

    static void anotherMethod1() {
        System.out.println("anotherMethod1 Line 1: " + Thread.currentThread().getName());
        System.out.println("anotherMethod1 Line 2: " + Thread.currentThread().getName());
    }

    static void anotherMethod2() {
        System.out.println("anotherMethod2 Line 1: " + Thread.currentThread().getName());
        System.out.println("anotherMethod2 Line 2: " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Hello : " + Thread.currentThread().getName());
        Sample.anotherMethod2();
        System.out.println("Hello Done : " + Thread.currentThread().getName());
    }
}
