package com.gl;

public class Sample {
    public static void main(String[] args) {
        int number = 50;
        if (args.length > 0) {
            number = Integer.parseInt(args[0]);
        }
        System.out.println(PrimeNumber.primeNumbers(number));
    }
}
