package com.gl.Java2023Session05;

public class Sample {
    public static void main(String[] args) {

        // -----------Method Syntax--------------
        // void methodName(){}
        // void methodName(int x){}
        // void methodName(int x, int y){}
        // void methodName(int x, int y, float f){}
        // int methodName(){}
        // int methodName(int x){}
        // int methodName(int x, int y){}
        // int methodName(int x, int y, float f){}
        // double methodName(){}
        // double methodName(int x){}
        // double methodName(int x, int y){}
        // double methodName(int x, int y, float f){}
        // boolean isCheckValue(){}
        // boolean isCheckValue(int x){}
        // boolean isCheckValue(int x, int y){}
        // boolean isCheckValue(int x, int y, float f){}

        System.out.println(" --------------------------------------- ");
        for (int n = 0; n < 10; n++) {
            if (isEvenNumber(n)) {
                System.out.println("n = " + n);
            }
        }
        System.out.println(" --------------------------------------- ");
        for (int n = 0; n < 10; n++) {
            if (isOddNumber(n)) {
                System.out.println("n = " + n);
            }
        }
        System.out.println(" --------------------------------------- ");

        test(10);
        test(0);

        sum(100, 500);
        int x = sum(100, 500);
        System.out.println("x = " + x);

        double r1 = squareOfNumber(8.9);
        System.out.println("r1 = " + r1);
        int r2 = squareOfNumber(181);
        System.out.println("r2 = " + r2);
        int r3 = squareOfNumber(81);
        System.out.println("r3 = " + r3);

        methodName();
        methodName();
        methodName();

        methodName1();
        int v = methodName1();
        System.out.println("v = " + v);

        methodName2(70);
        System.out.println("v = " + v);

        methodName3(8);
        int rr = methodName3(2);
        System.out.println("rr = " + rr);

        System.out.println(" --------------------------------------- ");
        System.out.println("call methodName2(10) ");
        methodName2(10);
        System.out.println("after call methodName2() ");
        System.out.println("call methodName2(99) ");
        methodName2(99);
        System.out.println("after call methodName2() ");
        System.out.println(" --------------------------------------- ");

    }

    static int methodName3(int x) {
        System.out.println("methodName3() Line 1 x= " + x);
        System.out.println("methodName3() Line 2");
        System.out.println("methodName3() Line 3");
        return x * 99;
    }

    static void methodName2(int x) {
        System.out.println("methodName2() Line 1 x= " + x);
        System.out.println("methodName2() Line 2");
        System.out.println("methodName2() Line 3");
        if (x == 99) {
            return;   // return is an optional key word
        }
        System.out.println("methodName2() Line 21");
        System.out.println("methodName2() Line 31");
    }

    static int methodName1() {
        System.out.println("methodName1()1");
        System.out.println("methodName1()2");
        System.out.println("methodName1()3");
        return 110;
    }

    static void methodName() {
        System.out.println("methodName()1");
        System.out.println("methodName()2");
        System.out.println("methodName()3");
    }

    static int squareOfNumber(int number) {
        System.out.println("int squareOfNumber () number = " + number);
        return number * number;
    }

    static double squareOfNumber(double number) {
        System.out.println("double squareOfNumber () number = " + number);
        return number * number;
    }

    static int sum(int a, int b) {
        int c = a + b;
        System.out.println("c = " + c);
        return c;
    }

    static int sum() {
        int c = 20 + 30;
        System.out.println("c = " + c);
        return c;
    }

    static void sum(int d) {
        int c = 20 + 30;
        System.out.println("c = " + c);
        //return c;  // Not allow return a value
        return; // allow return a control from the method
    }

    static void test(int x) {
        System.out.println("test()");
        if (x == 0) {
            return;
        }
        System.out.println("test() x = " + x);
    }


    static boolean isEvenNumber(int number) {
        boolean result = number % 2 == 0;
        return result;
    }

    static boolean isOddNumber(int number) {
        boolean result = number % 2 != 0;
        return result;
    }
}
