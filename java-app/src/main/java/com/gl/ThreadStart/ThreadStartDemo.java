package com.gl.ThreadStart;

public class ThreadStartDemo {
    public static void main(String[] args) {

        System.out.println("Main() Started ... "+Thread.currentThread());
        Thread thread = new MyThread();
        thread.start();
        //thread.run(); DO NOT invoke run() method manually
        System.out.println("Main() Completed ... "+Thread.currentThread());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am in run() executed by ... " + Thread.currentThread());
    }

    //Never override the start() method
    /*
    @Override
    public synchronized void start() {
        System.out.println("i am in start() executed by ... "+Thread.currentThread());
        run();
    }
    */
}
