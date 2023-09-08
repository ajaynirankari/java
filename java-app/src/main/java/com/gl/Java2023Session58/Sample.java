package com.gl.Java2023Session58;

public class Sample {
    public static void main(String[] args) {
        System.out.println("main() started application");
        System.out.println("main() application doing step 1");

        int div = test(10, 0);
        System.out.println("main()  div = " + div);

        try {
            int mul = test2(10, 0);
            System.out.println("main()  mul = " + mul);
        } catch (Exception e) {
            System.out.println("----- you have to pass input that multiplication should be > 10");
        }

        System.out.println("main() application doing step 2");
        System.out.println("main() application doing step 2");
        System.out.println("main() application is completed");
    }

    static int test(int a, int b) {
        System.out.println("test() a = " + a + ", b = " + b);
        System.out.println("test() Business logic 1");
        System.out.println("test() Business logic 2");
        int d = 0;
        try {
            d = a / b;
            System.out.println("test() ------------ No error d = " + d);
        } catch (Exception e) {
            //System.err.println("------------ ERROR occurred");
            System.out.println("test() ------------Error caught Input value of b can not be zero  getMessage = " + e.getMessage());
            //e.printStackTrace();
            //throw e;
        }
        System.out.println("test() Business logic 3");
        System.out.println("test() Business logic done");
        return d;
    }

    static int test2(int a, int b) {
        System.out.println("test2() a = " + a + ", b = " + b);
        System.out.println("test2() Business logic 1");
        System.out.println("test2() Business logic 2");
        int d = a * b;
        if (d < 10) {
            throw new IllegalArgumentException("Input is not as per expectation");
            //return -100;
        }
        System.out.println("test2() Business logic 3");
        System.out.println("test2() Business logic done");
        return d;
    }
}
