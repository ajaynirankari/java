package com.gl.ThreadLocal;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    static final InheritableThreadLocal<String> INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        RunnableTask runnableTask = new RunnableTask();

        Thread thread1 = new Thread(runnableTask, "User-1");
        thread1.start();

        Thread thread2 = new Thread(runnableTask, "User-2");
        thread2.start();

        Thread thread3 = new Thread(runnableTask, "User-3");
        thread3.start();

        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(runnableTask);
            executorService.submit(runnableTask);
            executorService.submit(runnableTask);
        }

        try (ExecutorService executorService1 = Executors.newFixedThreadPool(2)) {
            executorService1.submit(runnableTask);
            executorService1.submit(runnableTask);
        }

        new Thread(() -> {
            THREAD_LOCAL.set("value1");
            sleep();
            System.out.println(Thread.currentThread().getName() + " THREAD_LOCAL-> " + THREAD_LOCAL.get());
            System.out.println(Thread.currentThread().getName() + " INHERITABLE_THREAD_LOCAL -> " + INHERITABLE_THREAD_LOCAL.get());
        }, "Thread-1").start();

        new Thread(() -> {
            THREAD_LOCAL.set("value2");
            INHERITABLE_THREAD_LOCAL.set("value2");
            sleep();
            System.out.println(Thread.currentThread().getName() + " THREAD_LOCAL-> " + THREAD_LOCAL.get());


            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " THREAD_LOCAL-> " + THREAD_LOCAL.get());
                System.out.println(Thread.currentThread().getName() + " INHERITABLE_THREAD_LOCAL -> " + INHERITABLE_THREAD_LOCAL.get());
            }, "Child-Thread").start();

        }, "Thread-2").start();

        new Thread(() -> {
            sleep();
            System.out.println(Thread.currentThread().getName() + " THREAD_LOCAL-> " + THREAD_LOCAL.get());
            System.out.println(Thread.currentThread().getName() + " INHERITABLE_THREAD_LOCAL -> " + INHERITABLE_THREAD_LOCAL.get());
        }, "Thread-3").start();
    }

    static void sleep() {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (Exception ignored) {
        }
    }
}

class RunnableTask implements Runnable {
    //private Counter counter = new Counter();
    private static final ThreadLocal<Counter> counter = ThreadLocal.withInitial(Counter::new);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                counter.get().incrementCount();
            }
            System.out.println(Thread.currentThread().getName() + " Request counter = " + counter.get().get());
        } finally {
            counter.remove();
        }
    }
}

class Counter {
    private int requestCount;

    public int get() {
        return requestCount;
    }

    public void incrementCount() {
        requestCount++;
    }
}
