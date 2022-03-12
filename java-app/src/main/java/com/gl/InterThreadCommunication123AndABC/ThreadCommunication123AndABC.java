package com.gl.InterThreadCommunication123AndABC;

public class ThreadCommunication123AndABC {
    public static void main(String[] args) {
        SharableLockObject sharableLockObject = new SharableLockObject();
        new ThreadFor1234(sharableLockObject).start();
        new ThreadForABCD(sharableLockObject).start();
    }
}

class ThreadFor1234 extends Thread {
    private final SharableLockObject lock;

    public ThreadFor1234(SharableLockObject lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 26; i++) {
            while (lock.getKey() == true) {
                // waiting ...
            }
            System.out.print("[" + i + "] ");
            lock.setKey(true);
        }
    }
}

class ThreadForABCD extends Thread {
    private final SharableLockObject lock;

    public ThreadForABCD(SharableLockObject lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 26; i++) {
            while (lock.getKey() == false) {
                // waiting ...
            }
            System.out.print((char) (i + 65));
            System.out.println();
            lock.setKey(false);
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
