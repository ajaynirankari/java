package com.gl.Java2023Session78;

public class Sample {
    public static void main(String[] args) throws InterruptedException {

        String name = "John";
        System.out.println("name = " + name);
        name.toUpperCase();
        System.out.println("name = " + name);

        String nameToLower = name.toLowerCase();

        System.out.println("name = " + name);
        System.out.println("nameToLower = " + nameToLower);

        String nameConcat = name.concat(" Mark");

        System.out.println("name = " + name);
        System.out.println("nameConcat = " + nameConcat);
        System.out.println("-----------------------------------------------------------");

        MyMutableClass myMutableClass = new MyMutableClass(100);
        System.out.println("myMutableClass = " + myMutableClass);
        myMutableClass.setData(300);
        System.out.println("myMutableClass = " + myMutableClass);
        System.out.println("-----------------------------------------------------------");

        MyImmutableClass myImmutableClass = new MyImmutableClass(100);
        System.out.println("myImmutableClass = " + myImmutableClass);
        System.out.println("myImmutableClass.getData() = " + myImmutableClass.getData());

        MyImmutableClass myImmutableClass1 = new MyImmutableClass(300);
        System.out.println("myImmutableClass1 = " + myImmutableClass1);
        System.out.println("-----------------------------------------------------------");

        Data data = new Data(10);
        System.out.println("original data = " + data);
        data.increment();
        System.out.println("after increment () data = " + data);
        data.increment();
        System.out.println("after another increment () data = " + data);
        System.out.println("-----------------------------------------------------------");

        Data data1 = new Data(0);
        System.out.println("Before start thread the data1 = " + data1);
        MyThread myThread = new MyThread(data1);
        myThread.start();
        System.out.println("Before join() myThread.getData() = " + myThread.getData());
        myThread.join();
        System.out.println("After join() myThread.getData() = " + myThread.getData());
        System.out.println("After completed thread the data1 = " + data1);
        System.out.println("-----------------------------------------------------------");

        Data sharedResourceOrObject = new Data(0);
        System.out.println("sharedResourceOrObject = " + sharedResourceOrObject);
        MyThread myThread1 = new MyThread(sharedResourceOrObject);
        myThread1.start();

        MyThread myThread2 = new MyThread(sharedResourceOrObject);
        myThread2.start();

        MyThread myThread3 = new MyThread(sharedResourceOrObject);
        myThread3.start();

        myThread1.join();
        myThread2.join();
        myThread3.join();

        System.out.println("After all the three threads completed, the sharedResourceOrObject = " + sharedResourceOrObject);
        System.out.println("-----------------------------------------------------------");

    }
}

class MyThread extends Thread {
    private final Data data;

    MyThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            data.increment();
        }
    }

    public Data getData() {
        return data;
    }
}

class Data {
    private long x;

    public Data(long x) {
        this.x = x;
    }

    public synchronized void increment() {
        x++;
    }

    @Override
    public String toString() {
        return "Data{" +
                " x = " + x +
                '}';
    }
}

class MyImmutableClass {
    private int data;

    public MyImmutableClass(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MuImmutableClass{" +
                " data = " + data +
                '}';
    }
}

class MyMutableClass {
    private int data;

    public MyMutableClass(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyMutableClass{" +
                " data = " + data +
                '}';
    }
}
