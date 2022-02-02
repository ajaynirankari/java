package com.gl.JavaTrainingSession16;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        boolean primeNumber = isPrimeNumber(19);
        System.out.println("primeNumber = " + primeNumber);

        for (int n = 1; n <= 100; n++) {
            boolean primeNumber_ = isPrimeNumber(n);
            if (primeNumber_ == true) {
                System.out.print(n + ",");
            }
        }

        char randomSpecialCharacter = getRandomSpecialCharacter();
        System.out.println("randomSpecialCharacter = " + randomSpecialCharacter);

        String str = "This is test message";
        System.out.println("str = " + str);
        String replace = str.replace(" ", "-");
        System.out.println("replace = " + replace);

        String[] charStr = str.split("");
        System.out.println("Arrays.toString(charStr) = " + Arrays.toString(charStr));

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            System.out.println("index = [" + i + "] char= " + c);
        }

        char characterAtGivenIndex = str.charAt(8);
        System.out.println("characterAtGivenIndex = " + characterAtGivenIndex);

    }

    static char getRandomSpecialCharacter() {
        char[] allSpecialChar = {'`', '!', '#', '$', '%', '^', '&', '*', '(', ')'};
        int length = allSpecialChar.length - 1;
        double random = Math.random();
        int randomNumber = (int) (random * 100);
        int randomIndex = randomNumber % length;
        return allSpecialChar[randomIndex];
    }

    static boolean isPrimeNumber(int n) {
        for (int i = 2; i <= n / 2; i++) {
            int r = n % i;
            if (r == 0) {
                return false; // Input number is NOT prime number
            }
        }
        return true; // Input number is prime number
    }
}
