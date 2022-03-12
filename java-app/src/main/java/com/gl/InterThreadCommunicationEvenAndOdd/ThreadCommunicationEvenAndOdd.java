package com.gl.InterThreadCommunicationEvenAndOdd;

public class ThreadCommunicationEvenAndOdd {
    public static void main(String[] args) {
        SharableLockObject sharableLockObject = new SharableLockObject();
        new EvenThread(sharableLockObject).start();
        new OddThread(sharableLockObject).start();
    }
}

class EvenThread extends Thread {
    private final SharableLockObject lock;

    public EvenThread(SharableLockObject lock) {
        super("EvenThread");
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 26; i = i + 2) {
            while (lock.getKey() == false) {
                // waiting ...
            }
            System.out.println(i + ") <-" + Thread.currentThread().getName());
            lock.setKey(false);
        }
    }
}

class OddThread extends Thread {
    private final SharableLockObject lock;

    public OddThread(SharableLockObject lock) {
        super("OddThread");
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 26; i = i + 2) {
            while (lock.getKey() == true) {
                // waiting ...
            }
            System.out.println(i + ") <-" + Thread.currentThread().getName());
            lock.setKey(true);
        }
    }
}

class SharableLockObject {
    volatile private boolean key;

    public boolean getKey() {
        return key;
    }

    public synchronized void setKey(boolean key) {
        this.key = key;
    }
}