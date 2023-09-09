package com.gl.Java2023Session59;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Sample {
    public static void main(String[] args) {

        System.out.println("main() started ....");

        // Exception Handling
        Test test = new Test();
        test.process();

        //test.method3(2,2);
        // Compile-time Exception
        // Checked Exception

        test.method4(2);
        // Runtime exception
        // Unchecked exception


        //test.method5(3);
        test.method7(2);

        // Exception Handling
        // Two kind of exception
        // 1.  Compile time
        // 2.  Runtime

        // Throwable
        // 1. Exception
        // 2. Error

        // Exception have a specific subclass Known as RuntimeException
        // Runtime exception - any exception object that subclass of RuntimeException

        // Only Runtime exceptions are NOT required to Handle/ that means compiler not force you to handle


        // Good exception RuntimeException
        // NullPointerException
        // IllegalArgumentException
        // IndexOutOfBoundsException

        System.out.println("main() successfully completed ....");
    }
}

class Test {
    void process() {
        System.out.println("process()");
        method1();
    }

    void method1() {
        System.out.println("method1()");
        try {
            method2();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR FileNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR IOException caught: " + e.getMessage());
        }
        System.out.println("proceed Normal business line 1");
        System.out.println("proceed Normal business line 2");

    }

    void method2() throws FileNotFoundException, IOException {
        System.out.println("method2()");
        //method3(10, 2);
        method3(10, 1);
        //method3(10, 0);
    }

    void method3(int a, int b) throws FileNotFoundException, IOException {
        System.out.println("method3()");
        int d = 0;
        try {
            d = a / b;
        } catch (Exception e) {
            System.out.println("ERROR handle here, i don't want to propagate " + e.getMessage());
        }
        System.out.println("proceed business line 1 d = " + d);
        System.out.println("proceed business line 2");
        if (d < 1) {
            throw new IOException(" throw d < 1 ");
        }
        System.out.println("proceed business line 3");
        System.out.println("proceed business line 4");
        if (d >= 10) {
            throw new FileNotFoundException(" throw d >= 10 ");
        }
        System.out.println("proceed business line 5");
        System.out.println("proceed business line 6");
        method4(d);
    }

    void method4(int d) throws IllegalArgumentException {
        System.out.println("method4()");

        if (d > 5) {
            throw new IllegalArgumentException(" throw d>5");
        }
    }

    void method5(int d) throws MyTestException {
        System.out.println("method5()");

        if (d > 5) {
            throw new MyTestException(" throw d>5");
        }
    }

    void method6(int d) throws MyTestCheckedException {
        System.out.println("method6()");

        if (d > 5) {
            throw new MyTestCheckedException(" throw d>5");
        }
    }

    void method7(int d) throws MyTestUnCheckedException {
        System.out.println("method7()");

        if (d > 5) {
            throw new MyTestUnCheckedException(" throw d>5");
        }
    }
}

class MyTestException extends Throwable {
    private final String message;

    public MyTestException(String message) {
        this.message = message;
    }
}


class MyTestCheckedException extends Exception {
    private final String message;

    public MyTestCheckedException(String message) {
        this.message = message;
    }
}

class MyTestUnCheckedException extends RuntimeException {
    private final String message;

    public MyTestUnCheckedException(String message) {
        this.message = message;
    }
}