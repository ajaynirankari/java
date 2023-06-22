package com.gl.Java2023Session09;

public class AllDigitSum {
    public static void main(String[] args) {
        /**
         * Write a program the all digit sum of a given number
         */

        int number = 5634;
        // 5,6,3,4
        // 5 + 6 + 3 + 4
/*
         n%10   -> rem  5634%10   ->  4
         n/10   -> div  5634/10   ->  563

         n%10   -> rem  563%10   ->  3
         n/10   -> div  563/10   ->  56

         n%10   -> rem  56%10   ->  6
         n/10   -> div  56/10   ->  5

         n%10   -> rem  5%10   ->  5
         n/10   -> div  5/10   ->  0

        System.out.println(number);
        System.out.println("number%10 = "+number%10);
        System.out.println("number/10 = "+number/10);
        number = number/10;

        System.out.println(number);
        System.out.println("number%10 = "+number%10);
        System.out.println("number/10 = "+number/10);
        number = number/10;

        System.out.println(number);
        System.out.println("number%10 = "+number%10);
        System.out.println("number/10 = "+number/10);
        number = number/10;

        System.out.println(number);
        System.out.println("number%10 = "+number%10);
        System.out.println("number/10 = "+number/10);
        number = number/10;
*/
        System.out.println(number);
        int s = allDigitSum(number);
        System.out.println("Digit sum = " + s);
    }

    static int allDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int r = n % 10;
            sum = sum + r;
            n = n / 10;
        }
        return sum;
    }
}
