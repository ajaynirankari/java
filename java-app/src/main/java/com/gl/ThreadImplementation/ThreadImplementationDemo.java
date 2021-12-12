package com.gl.ThreadImplementation;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class ThreadImplementationDemo {
    public static void main(String[] args) throws Exception {

        System.out.println("Started ..." + Thread.currentThread());

        Thread thread = new MyThread();
        thread.start();

        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Anonymous class started in new thread ... " + Thread.currentThread());
                    }
                }
        );
        thread2.start();


        Thread thread3 = new Thread(
                () -> {
                    System.out.println("Lambda expression started in new thread ... " + Thread.currentThread());
                }
        );
        thread3.start();

        new Thread(() -> System.out.println("Signal line Lambda expression started in new thread ... " + Thread.currentThread())).start();
        new Thread(MyClass::execute).start();

        Executors.newCachedThreadPool().submit(new MyRunnable()).get();
        Executors.newCachedThreadPool().submit(new MyCallable()).get();
        Executors.newCachedThreadPool().submit(MyClass::execute).get();
        Executors.newCachedThreadPool().submit(MyClass::callReturnValue).get();

        CompletableFuture.runAsync(new MyRunnable()).get();
        CompletableFuture.supplyAsync(() -> {
            new MyRunnable().run();
            MyClass.execute();
            return 12;
        }).get();
        CompletableFuture.supplyAsync(MyClass::callReturnValue).get();

        System.out.println("Completed ..." + Thread.currentThread());

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread class started in new thread " + Thread.currentThread());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable class started in new thread ... " + Thread.currentThread());
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable class started in new thread ... " + Thread.currentThread());
        return 123;
    }
}

class MyClass {
    static void execute() {
        System.out.println("MyClass executed() in new thread ... " + Thread.currentThread());
    }

    static int callReturnValue() {
        System.out.println("MyClass callReturnValue() in new thread ... " + Thread.currentThread());
        return 1244;
    }
}
