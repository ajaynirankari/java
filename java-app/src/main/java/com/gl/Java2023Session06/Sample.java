package com.gl.Java2023Session06;

public class Sample {
    public static void main(String[] args) {
        // Write a program that sum  all the even number between 1 to N;

        boolean r = isEven(9);
        System.out.println("9 is even = " + r);

        r = isEven(8);
        System.out.println("8 is even = " + r);


        int N = 20;

        int sum = sumOffAllEvenNumber(N);
        System.out.println("sum = " + sum);

    }

    static int sumOffAllEvenNumber(int n) {
        int sum = 0;
        //System.out.println("111Outside of loop sum = " + sum);
        for (int x = 1; x <= n; x = x + 1) {
            boolean r = isEven(x);
            //System.out.println("isEven("+x+") = " + r);
            if (r == true) {
                sum = sum + x;
                //System.out.println("Inside---------------> Even = " + x+" sum = "+sum);
                //return sum;
            }
            //return sum;
        }
        //System.out.println("222 Outside of loop sum = " + sum);
        return sum;
    }


    static boolean isEven(int number) {
        int reminder = number % 2;
        if (reminder == 0) {
            return true;
        } else {
            return false;
        }
    }
}
