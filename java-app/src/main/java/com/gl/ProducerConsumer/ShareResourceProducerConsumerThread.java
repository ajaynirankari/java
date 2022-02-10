package com.gl.ProducerConsumer;

import java.util.stream.IntStream;


public class ShareResourceProducerConsumerThread {


    public static void main(String[] args) throws Exception {
        ShareResource shareResource = new ShareResource();
        new Thread(new Producer(shareResource)).start();
        new Thread(new Consumer(shareResource)).start();
    }
}

class Producer implements Runnable {
    ShareResource shareResource;

    public Producer(ShareResource shareResource) {
        this.shareResource = shareResource;
    }

    @Override
    public void run() {
        IntStream.range(0, 10).forEach(e -> {
            try {
                shareResource.produce(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}

class Consumer implements Runnable {
    ShareResource shareResource;

    Consumer(ShareResource shareResource) {
        this.shareResource = shareResource;
    }

    @Override
    public void run() {
        IntStream.range(0, 10).forEach(e -> {
            try {
                shareResource.consume();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}

class ShareResource {
    private volatile int data;
    private volatile boolean isProcess;

    public synchronized void produce(int n) throws Exception {
        while (isProcess) wait();
        data = n;
        System.out.println("Produced data = [" + data + "] " + Thread.currentThread());
        isProcess = true;
        notify();
    }

    public synchronized void consume() throws Exception {
        while (!isProcess) wait();
        System.out.println("Consumed data = [" + data + "] " + Thread.currentThread());
        isProcess = false;
        notify();
    }
}
