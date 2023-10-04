package com.gl.Java2023Session73;

public class Sample {
    public static void main(String[] args) {
        // Concept of Multi-threading
        // Since Java 1 - supported the concept of Multi-threading
        // What is Thread ?
        // Why we need Thread ?

        // Process - like a service the offer by the OS
        // JVM - is a Process

        // install the JRE software process (as a OS - the JVM is a process)
        // install the JDK software process (as a OS - the JVM is a process)

        // Process internal
        //  -> Memory
        //   Primary memory - RAM memory (Memory is used for running the process)
        //   Secondary memory - Hard dish (Permanent storage device)

        // JVM as process
        //  Memory
        // JVM can two mode
        // 1 - Can be running
        // 2 - Can be not running

        // Automatically released all the allocated memory
        // Garbage collection

        System.out.println("Line 1 "+Thread.currentThread());
        System.out.println("Line 2 "+Thread.currentThread());

        m1();
        m2();

        System.out.println("main DONE by "+Thread.currentThread());
    }

    static void m1(){
        System.out.println("m1() Line 1 "+Thread.currentThread());
        System.out.println("m1() Line 2 "+Thread.currentThread());
        System.out.println("m1() Line 3 "+Thread.currentThread());
    }

    static void m2(){
        System.out.println("m2() Line 1 "+Thread.currentThread());
        System.out.println("m2() Line 2 "+Thread.currentThread());
        System.out.println("m2() Line 3 "+Thread.currentThread());
    }
}
