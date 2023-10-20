package com.gl.Java2023Session86;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Sample {
    public static void main(String[] args) throws InterruptedException {

        // There are the Thread synchronization APIs
        // ----> Thread.join()    ----> to wait in thread is done / completed
        // ----> CountDownLatch   ----> wait between the thread life cycle
        // ----> CyclicBarrier    ----> wait between the thread life cycle
        // ----> Semaphore
        // ----> Lock
        // ----> Synchronized
        // ----> wait()
        // ----> notify()
        // ----> notifyAll()

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("------------------------------------------");
            System.out.println("All parties are reached, Lets start the game ...");
            System.out.println("------------------------------------------");
        });

        Payer payer = new Payer(cyclicBarrier);
        Thread thread1 = new Thread(payer, "Player-1");
        thread1.start();
        Thread thread2 = new Thread(payer, "Player-2");
        thread2.start();
        Thread thread3 = new Thread(payer, "Player-3");
        thread3.start();
        Thread thread4 = new Thread(payer, "Player-4");
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        cyclicBarrier.reset();
        System.out.println("----------------cyclicBarrier.reset()--------------------------");

        thread1 = new Thread(payer, "Player-11");
        thread1.start();
        thread2 = new Thread(payer, "Player-22");
        thread2.start();
        thread3 = new Thread(payer, "Player-33");
        thread3.start();
        thread4 = new Thread(payer, "Player-44");
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

class Payer implements Runnable {
    CyclicBarrier cyclicBarrier;

    public Payer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {

            System.out.println(Thread.currentThread().getName() + " is coming to play game");
            ThreadSleep.sleep(Duration.ofSeconds(new Random().nextInt(5)));
            System.out.println(Thread.currentThread().getName() + " is waiting to start a game");
            cyclicBarrier.await();

            System.out.print(".... game is going on .... ");
            System.out.print(".... game is completed .... ");
            System.out.println();

        } catch (Exception e) {
        }
    }
}
