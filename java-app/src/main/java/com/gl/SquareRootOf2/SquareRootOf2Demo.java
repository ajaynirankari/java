package com.gl.SquareRootOf2;

public class SquareRootOf2Demo {
    public static void main(String[] args) {
        /**
         * Logic -
         * SquareRootOf2 = (1+1/1)*(1-1/3)*(1+1/5)*(1-1/7)*(1+1/9)*(1-1/11)* . . .
         */
        double squareRootOf2 = 1;
        double d = 1;
        long n = 0;
        while (n < 1000000000) {
            if (n++ % 2 == 0) {
                squareRootOf2 *= 1.0 + (1.0 / d);
            } else {
                squareRootOf2 *= 1.0 - (1.0 / d);
            }
            d = d + 2.0;
        }
        System.out.printf("The square root of (2.0) is: %.9f", squareRootOf2);
        System.out.println();
        System.out.printf("          Math.sqrt(2.0) is: %.9f", Math.sqrt(2.0));
    }
}
