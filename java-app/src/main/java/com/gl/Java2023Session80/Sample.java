package com.gl.Java2023Session80;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample {
    public static void main(String[] args) {
        // Multi-threading

        Resource resource1 = new Resource();
        Resource resource2 = new Resource();
        Resource resource3 = new Resource();


        // synchronized is keyword
        // it can be used in two way
        // 1. at method level
        // 2. at block of code level

        // Lock is an interface
        // 1. via lock() method
        // 2. via tryLock() method

    }
}

class Resource {
    int instanceVar = 100;
    static int staticVar = 100;

    void readMethod() {
        System.out.println("readMethod instruction 1 ....");
        System.out.println("readMethod instruction 2 ....");
        System.out.println("readMethod instruction 3 ....");
        System.out.println("readMethod instruction 4 ....");
    }

    synchronized void writeMethod() {
        System.out.println("writeMethod instruction 1 ....");
        System.out.println("writeMethod instruction 2 ....");
        System.out.println("writeMethod instruction 3 ....");
        System.out.println("writeMethod instruction 4 ....");
    }

    void writeMethod1() {
        System.out.println("writeMethod instruction 1 ....");
        synchronized (this) {
            System.out.println("writeMethod instruction 2 ....");
            System.out.println("writeMethod instruction 3 ....");
        }
        System.out.println("writeMethod instruction 4 ....");
    }

    void writeMethod2() {
        System.out.println("writeMethod instruction 1 ....");

        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            //boolean b = lock.tryLock();
            //boolean b1 = lock.tryLock(15, TimeUnit.MINUTES);

            System.out.println("writeMethod instruction 2 ....");
            for (int i = 0; i < 100000; i++) {
                System.out.println("calculate");
            }
            System.out.println("writeMethod instruction 3 ....");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }


        System.out.println("writeMethod instruction 4 ....");
    }


    static synchronized void writeStaticMethod() {
        System.out.println("writeMethod instruction 1 ....");
        System.out.println("writeMethod instruction 2 ....");
        System.out.println("writeMethod instruction 3 ....");
        System.out.println("writeMethod instruction 4 ....");
    }

    static void readStaticMethod() {
        System.out.println("readMethod instruction 1 ....");
        System.out.println("readMethod instruction 2 ....");
        System.out.println("readMethod instruction 3 ....");
        System.out.println("readMethod instruction 4 ....");
    }
}
