package com.gl.StructuredConcurrency;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.concurrent.Future;

public class Sample {
    public static void main(String[] args) throws Exception {
        // --enable-preview --add-modules jdk.incubator.concurrent

        System.out.println("main = "+Thread.currentThread());
        try (var scope = new StructuredTaskScope<>()) {
            Future<String> fork1 = scope.fork(() -> "task 1 return " + Thread.currentThread());
            Future<String> fork2 = scope.fork(()->"task 2 return "+Thread.currentThread());
            scope.join();
            System.out.println("Result1 = "+fork1.resultNow());
            System.out.println("Result2 = "+fork2.resultNow());
        }
        System.out.println("main done = "+Thread.currentThread());
    }
}
