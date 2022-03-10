package com.gl.JavaTrainingSession32;

public class Sample {
    public static void main(String[] args) {
        Test test = new Test();
        //test.method1(0);
        int n = 5;
        int factorial = test.factorial(n);
        System.out.println("Factorial of (" + n + ") using Recursive call is = " + factorial);
        System.out.println("Factorial of (" + n + ") using for loop call is = " + test.factorialUsingForLoop(n));
        System.out.println("Factorial of (" + n + ") using while loop call is = " + test.factorialUsingWhileLoop(n));
    }
}

class Test {
    int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

    int factorialUsingForLoop(int n) {
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact = fact * i;
        }
        return fact;
    }

    int factorialUsingWhileLoop(int n) {
        int fact = 1;
        while (n >= 1) {
            fact = fact * n;
            n = n - 1;
        }
        return fact;
    }

    int method1(int r) {
        System.out.println("r = " + r++);
        if (r == 10) {
            return r;
        } else {
            return method1(r);
        }
    }
}
