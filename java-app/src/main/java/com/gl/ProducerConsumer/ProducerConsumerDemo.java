package com.gl.ProducerConsumer;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Data d = new Data();
        new Thread(() -> {
            IntStream.iterate(1, i -> i + 1).limit(10).forEach(n -> {
                try {
                    d.produce(n);
                } catch (Exception e) {
                }
            });
        }).start();
        new Thread(() -> {
            IntStream.rangeClosed(1, 10).forEach(n -> {
                try {
                    d.consume();
                } catch (Exception e) {
                }
            });
        }).start();
    }
}

class Data {
    private volatile int x;
    private volatile boolean isProduced;

    public synchronized void produce(int n) throws Exception {
        while (isProduced) wait();
        x = n;
        isProduced = true;
        notify();
    }

    public synchronized void consume() throws Exception {
        while (!isProduced) wait();
        System.out.println(x);
        TimeUnit.SECONDS.sleep(1);
        isProduced = false;
        notify();
    }
}