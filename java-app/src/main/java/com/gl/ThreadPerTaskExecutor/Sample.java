package com.gl.ThreadPerTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            IntStream.range(1, 10)
                    .mapToObj(id -> executorService.submit(() -> process(id)))
                    .toList();

        }


        try (ExecutorService executorService = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory())) {

            IntStream.range(20,30)
                    .mapToObj(id->executorService.submit(()->process(id)))
                    .toList();
        }

        try (ExecutorService executorService = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {

            IntStream.range(50,60)
                    .mapToObj(id->executorService.submit(()->process(id)))
                    .toList();
        }
    }

    static void process(int id) {
        System.out.println("process() id = " + id + " " + Thread.currentThread());
    }
}
