package com.gl.Java2023Session82;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        System.out.println("Stated .. " + Thread.currentThread().getName());

        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer), "ProducerThread").start();
        new Thread(new Consumer(buffer), "ConsumerThread").start();


        new Thread(Sample::task, "MyThreadOne").start();

        new Thread(() -> Sample.task(), "MyThreadTwo").start();

        Runnable task = () -> Sample.task();
        new Thread(task, "MyThreadThree").start();

        Sample sampleObject = new Sample();
        new Thread(sampleObject::instanceTask, "MyThreadFour").start();


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                sampleObject.instanceTask();
            }
        };

        new Thread(runnable1, "MyThreadFive").start();

        class MyThread implements Runnable {

            @Override
            public void run() {
                sampleObject.instanceTask();
            }
        }
        MyThread myThread = new MyThread();
        new Thread(myThread, "MyThreadSix").start();


        class MyThreadClass extends Thread {
            @Override
            public void run() {
                sampleObject.instanceTask();
            }
        }
        MyThreadClass myThreadClass = new MyThreadClass();

        new Thread(myThreadClass, "MyThreadSeven").start();

        System.out.println("Completed .. " + Thread.currentThread().getName());
    }


    static void task() {
        IntStream.range(1, 5)
                .forEach(n -> {
                    ThreadSleep.sleep(Duration.ofSeconds(1));
                    System.out.println(n + ", print by Thread : " + Thread.currentThread().getName());
                });
    }

    void instanceTask() {
        IntStream.range(1, 5)
                .forEach(n -> {
                    ThreadSleep.sleep(Duration.ofSeconds(1));
                    System.out.println(n + ", print by Thread : " + Thread.currentThread().getName());
                });
    }
}

class Producer implements Runnable {
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        IntStream.range(1, 10)
                .forEach(i -> {
                    try {
                        buffer.produce(i);
                        ThreadSleep.sleep(Duration.ofSeconds(2));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

class Consumer implements Runnable {
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        IntStream.range(1, 10)
                .forEach(i -> {
                    try {
                        buffer.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

class Buffer {
    private final List<Integer> list = new ArrayList<>();

    public void produce(int x) throws InterruptedException {
        synchronized (list) {
            while (list.size() == 1) {
                list.wait();
            }

            list.add(x);
            System.out.println("Producer added data in list = " + list + " Thread by: " + Thread.currentThread().getName());
            list.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (list) {
            while (list.isEmpty()) {
                list.wait();
            }

            Integer remove = list.remove(0);
            System.out.println("Consumed data from list = " + remove + ", list = " + list + " Thread by: " + Thread.currentThread().getName());
            list.notifyAll();
        }
    }
}

class NewBuffer {
    private final List<Integer> list = new ArrayList<>();

    public synchronized void produce(int x) throws InterruptedException {
        while (list.size() == 1) {
            wait();
        }
        list.add(x);
        System.out.println("Producer added data in list = " + list + " Thread by: " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (list.isEmpty()) {
            wait();
        }

        Integer remove = list.remove(0);
        System.out.println("Consumed data from list = " + remove + ", list = " + list + " Thread by: " + Thread.currentThread().getName());
        notifyAll();
    }
}